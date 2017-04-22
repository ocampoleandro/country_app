package com.example.leandro.countryapp.configuration.injection;

import com.example.leandro.countryapp.presenter.factory.DetailCountryPresenterFactory;
import com.example.leandro.countryapp.presenter.factory.MainPresenterFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Provides the components that create presenters.
 */
@SuppressWarnings("WeakerAccess")
@Module
public class PresenterFactoryModule {

    @Provides
    @Singleton
    MainPresenterFactory provideMainPresenterFactory() {
        return new MainPresenterFactory();
    }

    @Provides
    @Singleton
    DetailCountryPresenterFactory provideDetailCountryPresenterFactory() {
        return new DetailCountryPresenterFactory();
    }
}
