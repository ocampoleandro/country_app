package com.example.leandro.countryapp.presenter.factory;

import android.support.annotation.Nullable;

import com.example.leandro.countryapp.presenter.BasePresenter;
import com.example.leandro.countryapp.ui.provider.ParamsProvider;

/**
 * Creates a Presenter object.
 *
 * @param <T> presenter type
 */
public interface PresenterFactory<T extends BasePresenter> {

    T create(@Nullable ParamsProvider bundleProvider);
}
