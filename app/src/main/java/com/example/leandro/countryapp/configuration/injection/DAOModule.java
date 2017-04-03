package com.example.leandro.countryapp.configuration.injection;

import com.example.leandro.countryapp.model.dao.CountryDAO;
import com.example.leandro.countryapp.model.dao.impl.CountryDAOImpl;
import com.example.leandro.countryapp.network.CountryClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by leandro on 25/03/17.
 */
@Module
public class DAOModule {

    @Provides
    @Singleton
    CountryDAO provideCountryDAO(CountryClient countryClient){
        return new CountryDAOImpl(countryClient);
    }
}
