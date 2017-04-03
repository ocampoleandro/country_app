package com.example.leandro.countryapp.configuration.injection;

import com.example.leandro.countryapp.presenter.factory.DetailCountryPresenterFactory;
import com.example.leandro.countryapp.presenter.factory.MainPresenterFactory;
import com.example.leandro.countryapp.presenter.factory.impl.DetailCountryPresenterFactoryImpl;
import com.example.leandro.countryapp.presenter.factory.impl.MainPresenterFactoryImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by leandro on 19/03/17.
 */
@Module
public class PresenterFactoryModule {

    @Provides
    @Singleton
    MainPresenterFactory provideMainPresenterFactory(){
        return new MainPresenterFactoryImpl();
    }

    @Provides
    @Singleton
    DetailCountryPresenterFactory provideDetailCountryPresenterFactory() {
        return new DetailCountryPresenterFactoryImpl();
    }
}
