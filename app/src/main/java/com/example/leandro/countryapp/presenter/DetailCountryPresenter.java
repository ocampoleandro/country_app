package com.example.leandro.countryapp.presenter;

import com.example.leandro.countryapp.model.data.Country;
import com.example.leandro.countryapp.view.DetailCountryView;

/**
 * Created by leandro on 01/04/17.
 */

public interface DetailCountryPresenter extends MvpPresenter<DetailCountryView> {
    Country onCountryNeeded();
}
