package com.example.leandro.countryapp.configuration.injection;

import com.example.leandro.countryapp.ui.activity.DetailCountryActivity;
import com.example.leandro.countryapp.ui.activity.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by leandro on 19/03/17.
 */
@Singleton
@Component(modules = {PresenterFactoryModule.class})
public interface PresenterFactoryComponent {
    void inject(MainActivity activity);

    void inject(DetailCountryActivity activity);
}
