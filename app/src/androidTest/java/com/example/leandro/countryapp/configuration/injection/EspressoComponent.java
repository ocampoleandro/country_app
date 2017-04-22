package com.example.leandro.countryapp.configuration.injection;

import com.example.leandro.countryapp.test.country.HelloWorldEspressoTest;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by locampo on 3/31/17.
 */
@Singleton
@Component(modules = {DAOMockModule.class})
public interface EspressoComponent extends DAOComponent {
    void inject(HelloWorldEspressoTest test);
}
