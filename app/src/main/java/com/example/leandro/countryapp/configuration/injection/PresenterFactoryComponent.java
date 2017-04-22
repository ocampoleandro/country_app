package com.example.leandro.countryapp.configuration.injection;

import com.example.leandro.countryapp.ui.activity.DetailCountryActivity;
import com.example.leandro.countryapp.ui.activity.ListCountryActivity;
import com.example.leandro.countryapp.ui.fragmet.CountryDetailFragment;
import com.example.leandro.countryapp.ui.fragmet.ListCountryFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Inject the dependencies needed in each object.
 */
@Singleton
@Component(modules = {PresenterFactoryModule.class})
public interface PresenterFactoryComponent {
    void inject(ListCountryActivity activity);

    void inject(DetailCountryActivity activity);

    void inject(ListCountryFragment fragment);

    void inject(CountryDetailFragment fragment);
}
