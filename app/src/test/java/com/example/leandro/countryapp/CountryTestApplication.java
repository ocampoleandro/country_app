package com.example.leandro.countryapp;

import com.example.leandro.countryapp.configuration.injection.DaggerPresenterFactoryTestComponent;

/**
 * {@link android.app.Application} class for testing purpose.
 */
public class CountryTestApplication extends CountryApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        //override the factory component in order to inject the mocks instead of real implementations
        presenterFactoryComponent = DaggerPresenterFactoryTestComponent.create();
    }

    @Override
    protected boolean isTestEnvironment() {
        return true;
    }
}
