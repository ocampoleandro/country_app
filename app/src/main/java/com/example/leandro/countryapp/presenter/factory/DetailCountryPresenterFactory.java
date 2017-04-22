package com.example.leandro.countryapp.presenter.factory;

import android.support.annotation.Nullable;

import com.example.leandro.countryapp.presenter.DetailCountryPresenter;
import com.example.leandro.countryapp.ui.provider.ParamsProvider;

public class DetailCountryPresenterFactory implements PresenterFactory<DetailCountryPresenter> {

    @Override
    public DetailCountryPresenter create(@Nullable ParamsProvider bundleProvider) {
        return new DetailCountryPresenter(bundleProvider);
    }
}
