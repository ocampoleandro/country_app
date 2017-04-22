package com.example.leandro.countryapp;

import android.app.Application;

import com.example.leandro.countryapp.configuration.injection.DAOComponent;
import com.example.leandro.countryapp.configuration.injection.DaggerDAOComponent;
import com.example.leandro.countryapp.configuration.injection.DaggerPresenterFactoryComponent;
import com.example.leandro.countryapp.configuration.injection.PresenterFactoryComponent;
import com.facebook.stetho.Stetho;
import com.uphyca.stetho_realm.RealmInspectorModulesProvider;

import io.realm.Realm;

public class CountryApplication extends Application {

    private static CountryApplication instance;

    PresenterFactoryComponent presenterFactoryComponent;
    DAOComponent daoComponent;

    public static CountryApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        presenterFactoryComponent = DaggerPresenterFactoryComponent.create();
        daoComponent = DaggerDAOComponent.create();

        if (BuildConfig.DEBUG && !isTestEnvironment()) {
            Realm.init(this);

            Stetho.initialize(
                    Stetho.newInitializerBuilder(this)
                            .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                            .enableWebKitInspector(RealmInspectorModulesProvider.builder(this).build())
                            .build());
        }
    }

    protected boolean isTestEnvironment() {
        return false;
    }

    public PresenterFactoryComponent getPresenterFactoryComponent() {
        return presenterFactoryComponent;
    }

    public DAOComponent getDaoComponent() {
        return daoComponent;
    }

}
