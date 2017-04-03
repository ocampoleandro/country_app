package com.example.leandro.countryapp;

import com.example.leandro.countryapp.configuration.injection.DaggerPresenterFactoryTestComponent;

/**
 * Created by locampo on 3/31/17.
 */

public class CountryTestApplication extends CountryApplication {

  @Override
  public void onCreate() {
    super.onCreate();
    presenterFactoryComponent = DaggerPresenterFactoryTestComponent.create();
  }
}
