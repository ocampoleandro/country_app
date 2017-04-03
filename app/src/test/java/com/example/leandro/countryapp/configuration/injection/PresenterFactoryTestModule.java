package com.example.leandro.countryapp.configuration.injection;

import com.example.leandro.countryapp.presenter.factory.DetailCountryPresenterFactory;
import com.example.leandro.countryapp.presenter.factory.MainPresenterFactory;

import org.mockito.Mockito;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by locampo on 3/31/17.
 */
@Module
public class PresenterFactoryTestModule {

  @Singleton
  @Provides
  MainPresenterFactory provideMainPresenterFactory(){
    return Mockito.mock(MainPresenterFactory.class);
  }

    @Singleton
    @Provides
    DetailCountryPresenterFactory provideDetailCountryPresenterFactory() {
        return Mockito.mock(DetailCountryPresenterFactory.class);
  }
}
