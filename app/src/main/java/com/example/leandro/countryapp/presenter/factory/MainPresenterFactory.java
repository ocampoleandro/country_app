package com.example.leandro.countryapp.presenter.factory;

import android.support.annotation.Nullable;

import com.example.leandro.countryapp.presenter.ListCountryPresenter;
import com.example.leandro.countryapp.ui.provider.ParamsProvider;

public class MainPresenterFactory implements PresenterFactory<ListCountryPresenter> {

    @Override
    public ListCountryPresenter create(@Nullable ParamsProvider bundleProvider) {
        return new ListCountryPresenter(bundleProvider);
    }
}
