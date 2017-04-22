package com.example.leandro.countryapp.ui.activity;

import com.example.leandro.countryapp.BuildConfig;
import com.example.leandro.countryapp.CountryTestApplication;
import com.example.leandro.countryapp.configuration.injection.DaggerPresenterFactoryTestComponent;
import com.example.leandro.countryapp.model.data.Country;
import com.example.leandro.countryapp.presenter.ListCountryPresenter;
import com.example.leandro.countryapp.presenter.factory.MainPresenterFactory;
import com.example.leandro.countryapp.ui.provider.ParamsProvider;

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
@Config(constants = BuildConfig.class, application = CountryTestApplication.class)
public class MainActivityUnitTest {

    private ListCountryActivity subject;

    @Inject
    MainPresenterFactory mainPresenterFactory;

    private ActivityController<ListCountryActivity> controller;
    private ListCountryPresenter listCountryPresenter;

    @Before
    public void setup() {
        ((DaggerPresenterFactoryTestComponent) ((CountryTestApplication) RuntimeEnvironment.application).getPresenterFactoryComponent()).inject(this);
        listCountryPresenter = Mockito.mock(ListCountryPresenter.class);
        when(mainPresenterFactory.create((ParamsProvider) any())).thenReturn(listCountryPresenter);
        controller = Robolectric.buildActivity(ListCountryActivity.class);
    }

    @Test
    public void onStart_shouldCallOnCountriesRequested() {
        subject = controller.create().start().get();
        verify(listCountryPresenter).onCountriesRequested(Country.REGION_AMERICAS);
    }

}
