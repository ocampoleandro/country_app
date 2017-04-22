package com.example.leandro.countryapp.presenter;

import com.example.leandro.countryapp.CountryApplication;
import com.example.leandro.countryapp.model.dao.CountryDAO;
import com.example.leandro.countryapp.model.dao.RequestData;
import com.example.leandro.countryapp.model.dao.callback.ListCallback;
import com.example.leandro.countryapp.model.data.Country;
import com.example.leandro.countryapp.ui.adapter.ClickItemListener;
import com.example.leandro.countryapp.ui.provider.ParamsProvider;
import com.example.leandro.countryapp.view.ListCountryView;

import java.util.List;

import javax.inject.Inject;

public class ListCountryPresenter extends BasePresenter<ListCountryView> implements ClickItemListener<Country> {

    private static final String LIST_COUNTRY_PARAM = "LIST_COUNTRY_PARAM";
    private static final String REGION_PARAM = "REGION_PARAM";

    @Inject
    CountryDAO countryDAO;

    private RequestData requestCountries;

    private List<Country> countries;
    //last region passed to list countries
    private String region;

    public ListCountryPresenter(ParamsProvider bundleProvider) {
        countries = bundleProvider.getParcelable(LIST_COUNTRY_PARAM);
        region = bundleProvider.getString(REGION_PARAM);
    }

    @Override
    public void onSaveInstanceState(ParamsProvider bundleProvider) {
        bundleProvider.putParcelable(LIST_COUNTRY_PARAM, countries);
        bundleProvider.putString(REGION_PARAM, region);

        if (requestCountries != null) requestCountries.cancelRequest();
    }

    public void onCountriesRequested(String region) {
        if (region.equals(this.region) && countries != null) {
            view.deliverCountries(countries);
            return;
        }
        this.region = region;
        requestCountries = countryDAO.getCountriesByRegion(region, new ListCallback<Country>() {
            @Override
            public void onSuccess(List<Country> countries, boolean localData) {
                requestCountries = null;
                ListCountryPresenter.this.countries = countries;
                if (!localData) view.updateLocalModel(countries);
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

    @Override
    public void onClickItem(Country item) {
        view.launchCountryDetail(item);
    }
}
