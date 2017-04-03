package com.example.leandro.countryapp.presenter.impl;

import android.os.Bundle;

import com.example.leandro.countryapp.CountryApplication;
import com.example.leandro.countryapp.model.dao.CountryDAO;
import com.example.leandro.countryapp.model.dao.RequestData;
import com.example.leandro.countryapp.model.dao.callback.ListCallback;
import com.example.leandro.countryapp.model.data.Country;
import com.example.leandro.countryapp.presenter.MainPresenter;
import com.example.leandro.countryapp.view.MainView;

import org.parceler.Parcels;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by leandro on 19/03/17.
 */

public class MainPresenterImpl extends BasePresenter<MainView> implements MainPresenter {

    private static final String LIST_COUNTRY_PARAM = "LIST_COUNTRY_PARAM";
    private static final String REGION_PARAM = "REGION_PARAM";

    @Inject
    CountryDAO countryDAO;

    private RequestData requestCountries;

    private List<Country> countries;
    //last region passed to list countries
    private String region;

    public MainPresenterImpl(Bundle savedInstanceState) {
        if(savedInstanceState != null){
            countries = Parcels.unwrap(savedInstanceState.getParcelable(LIST_COUNTRY_PARAM));
            region = savedInstanceState.getString(REGION_PARAM);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putParcelable(LIST_COUNTRY_PARAM, Parcels.wrap(countries));
        outState.putString(REGION_PARAM, region);

        if (requestCountries != null) requestCountries.cancelRequest();
    }

    @Override
    public void onCountriesRequested(String region) {
        if (region.equals(this.region) && countries != null) {
            view.deliverCountries(countries);
            return;
        }
        this.region = region;
        requestCountries = countryDAO.getCountriesByRegion(region, new ListCallback<Country>() {
            @Override
            public void onSuccess(List<Country> countries) {
                requestCountries = null;
                MainPresenterImpl.this.countries = countries;
                view.deliverCountries(countries);
            }

            @Override
            public void onError() {
                if (!requestCountries.isRequestCancelled()) view.deliverErrorFetchingCountries();
                requestCountries = null;
            }
        });
    }

    @Override
    protected void initInject() {
        CountryApplication.getInstance().getDaoComponent().inject(this);
    }
}
