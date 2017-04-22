package com.example.leandro.countryapp.configuration.injection;

import com.example.leandro.countryapp.presenter.ListCountryPresenter;
import com.example.leandro.countryapp.service.CountryLocalUpdateService;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Inject the dependencies needed in each object.
 */
@Singleton
@Component(modules = {DAOModule.class})
public interface DAOComponent {
    void inject(ListCountryPresenter listCountryPresenter);

    void inject(CountryLocalUpdateService countryLocalUpdateService);
}
