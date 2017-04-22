package com.example.leandro.countryapp;

import com.example.leandro.countryapp.configuration.injection.DaggerEspressoComponent;
import com.example.leandro.countryapp.configuration.injection.EspressoComponent;

/**
 * {@link android.app.Application} class for testing purpose.
 */
public class CountryTestApplication extends CountryApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        //override the dao component in order to inject the mocks instead of real implementations
        daoComponent = DaggerEspressoComponent.create();
    }

    @Override
    protected boolean isTestEnvironment() {
        return true;
    }

    public EspressoComponent getDaoComponent() {
        return (EspressoComponent) daoComponent;
    }

}
