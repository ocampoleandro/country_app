package com.example.leandro.countryapp.presenter.impl;

import com.example.leandro.countryapp.presenter.MvpPresenter;
import com.example.leandro.countryapp.view.MvpView;

/**
 * Created by leandro on 25/03/17.
 */

abstract class BasePresenter<T extends MvpView> implements MvpPresenter<T> {

    protected T view;

    BasePresenter(){
        initInject();
    }

    @Override
    public void onViewCreated(T view) {
        this.view = view;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onDestroyed() {

    }

    protected abstract void initInject();

}
