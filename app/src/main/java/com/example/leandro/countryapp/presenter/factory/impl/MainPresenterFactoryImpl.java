package com.example.leandro.countryapp.presenter.factory.impl;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.leandro.countryapp.presenter.factory.MainPresenterFactory;
import com.example.leandro.countryapp.presenter.impl.MainPresenterImpl;

/**
 * Created by leandro on 19/03/17.
 */

public class MainPresenterFactoryImpl implements MainPresenterFactory {

    @Override
    public MainPresenterImpl create(@Nullable Bundle savedInstanceState, @Nullable Bundle params, @Nullable Intent intent) {
        return new MainPresenterImpl(savedInstanceState);
    }
}
