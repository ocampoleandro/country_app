package com.example.leandro.countryapp.presenter.impl;

import android.content.Intent;
import android.os.Bundle;

import com.example.leandro.countryapp.model.data.Country;
import com.example.leandro.countryapp.presenter.DetailCountryPresenter;
import com.example.leandro.countryapp.view.DetailCountryView;

import org.parceler.Parcels;

/**
 * Created by leandro on 02/04/17.
 */

public class DetailCountryPresenterImpl extends BasePresenter<DetailCountryView>
        implements DetailCountryPresenter {

    private static final String COUNTRY_PARAM = "COUNTRY_PARAM";

    private Country country;

    public DetailCountryPresenterImpl(Bundle savedInstanceState, Intent intent) {
        if (savedInstanceState != null) {
            country = Parcels.unwrap(savedInstanceState.getParcelable(COUNTRY_PARAM));
        } else {
            country = Parcels.unwrap(intent.getParcelableExtra(COUNTRY_PARAM));
        }
    }

    @Override
    public void onViewCreated(DetailCountryView view) {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onDestroyed() {

    }

    @Override
    protected void initInject() {

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putParcelable(COUNTRY_PARAM, Parcels.wrap(country));
    }

    @Override
    public Country onCountryNeeded() {
        return country;
    }
}
