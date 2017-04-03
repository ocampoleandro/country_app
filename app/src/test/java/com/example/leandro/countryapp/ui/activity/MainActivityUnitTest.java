package com.example.leandro.countryapp.ui.activity;

import android.content.Intent;
import android.os.Bundle;

import com.example.leandro.countryapp.BuildConfig;
import com.example.leandro.countryapp.CountryTestApplication;
import com.example.leandro.countryapp.configuration.injection.DaggerPresenterFactoryTestComponent;
import com.example.leandro.countryapp.model.data.Country;
import com.example.leandro.countryapp.presenter.MainPresenter;
import com.example.leandro.countryapp.presenter.factory.MainPresenterFactory;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;

import javax.inject.Inject;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by locampo on 3/31/17.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class,application = CountryTestApplication.class)
public class MainActivityUnitTest {

  private MainActivity subject;

  @Inject MainPresenterFactory mainPresenterFactory;

  private ActivityController<MainActivity> controller;
  private MainPresenter mainPresenter;

  @Before
  public void setup(){
    ((DaggerPresenterFactoryTestComponent) ((CountryTestApplication) RuntimeEnvironment.application).getPresenterFactoryComponent()).inject(this);
    mainPresenter = Mockito.mock(MainPresenter.class);
    when(mainPresenterFactory.create((Bundle) any(), (Bundle) any(), (Intent) any())).thenReturn(mainPresenter);
    controller = Robolectric.buildActivity(MainActivity.class);
  }

  @Test
  public void onCreate_shouldCallOnCountriesRequested(){
    subject = controller.create().start().get();
    verify(mainPresenter).onCountriesRequested(Country.REGION_AMERICAS);
  }

}
