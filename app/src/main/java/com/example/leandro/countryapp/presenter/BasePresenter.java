package com.example.leandro.countryapp.presenter;

import com.example.leandro.countryapp.ui.provider.ParamsProvider;

/**
 * Created by leandro on 25/03/17.
 */

public abstract class BasePresenter<T> {

    protected T view;

    BasePresenter() {
        initInject();
    }

    public void onViewCreated(T view) {
        this.view = view;
    }

    public void onStart() {

    }

    public void onDestroyed() {

    }

    protected abstract void initInject();

    public void onSaveInstanceState(ParamsProvider bundleProvider) {

    }

    ;

}
