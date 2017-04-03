package com.example.leandro.countryapp.configuration.injection;

import com.example.leandro.countryapp.ui.activity.MainActivityUnitTest;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by locampo on 3/31/17.
 */
@Singleton
@Component(modules = {PresenterFactoryTestModule.class})
public interface PresenterFactoryTestComponent extends PresenterFactoryComponent {
  void inject(MainActivityUnitTest mainActivityUnitTest);
}
