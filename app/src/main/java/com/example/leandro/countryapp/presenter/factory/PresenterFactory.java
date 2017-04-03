package com.example.leandro.countryapp.presenter.factory;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.leandro.countryapp.presenter.MvpPresenter;

/**
 * Creates a Presenter object.
 * @param <T> presenter type
 */
public interface PresenterFactory<T extends MvpPresenter> {

    T create(@Nullable Bundle savedInstanceState, @Nullable Bundle params, @Nullable Intent intent);
}
