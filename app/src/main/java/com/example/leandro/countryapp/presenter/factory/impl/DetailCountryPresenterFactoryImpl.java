package com.example.leandro.countryapp.presenter.factory.impl;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.leandro.countryapp.presenter.DetailCountryPresenter;
import com.example.leandro.countryapp.presenter.factory.DetailCountryPresenterFactory;
import com.example.leandro.countryapp.presenter.impl.DetailCountryPresenterImpl;

/**
 * Created by leandro on 01/04/17.
 */

public class DetailCountryPresenterFactoryImpl implements DetailCountryPresenterFactory {

    @Override
    public DetailCountryPresenter create(@Nullable Bundle savedInstanceState, @Nullable Bundle params, @Nullable Intent intent) {
        return new DetailCountryPresenterImpl(savedInstanceState, intent);
    }
}
