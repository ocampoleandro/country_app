package com.example.leandro.countryapp.configuration.injection;

import com.example.leandro.countryapp.presenter.impl.MainPresenterImpl;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by leandro on 25/03/17.
 */
@Singleton
@Component(modules = {DAOModule.class, CountryAPIModule.class})
public interface DAOComponent {
    void inject(MainPresenterImpl mainPresenter);
}
