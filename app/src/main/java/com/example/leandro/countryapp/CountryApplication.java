package com.example.leandro.countryapp;

import android.app.Application;

import com.example.leandro.countryapp.configuration.injection.DAOComponent;
import com.example.leandro.countryapp.configuration.injection.DaggerDAOComponent;
import com.example.leandro.countryapp.configuration.injection.DaggerPresenterFactoryComponent;
import com.example.leandro.countryapp.configuration.injection.PresenterFactoryComponent;

/**
 * Created by leandro on 19/03/17.
 */

public class CountryApplication extends Application {

    private static CountryApplication instance;

    PresenterFactoryComponent presenterFactoryComponent;
    private DAOComponent daoComponent;

    public static CountryApplication getInstance(){
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        presenterFactoryComponent = DaggerPresenterFactoryComponent.create();
        daoComponent = DaggerDAOComponent.create();
    }

    public PresenterFactoryComponent getPresenterFactoryComponent() {
        return presenterFactoryComponent;
    }

    public DAOComponent getDaoComponent() {
        return daoComponent;
    }
}
