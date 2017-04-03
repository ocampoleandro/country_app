package com.example.leandro.countryapp.presenter;

import com.example.leandro.countryapp.view.MainView;

/**
 * Created by leandro on 25/03/17.
 */

public interface MainPresenter extends MvpPresenter<MainView> {
    void onCountriesRequested(String region);
}
