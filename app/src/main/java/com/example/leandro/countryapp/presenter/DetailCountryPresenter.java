package com.example.leandro.countryapp.presenter;

import com.example.leandro.countryapp.model.data.Country;
import com.example.leandro.countryapp.ui.provider.ParamsProvider;
import com.example.leandro.countryapp.view.DetailCountryView;

/**
 * Created by leandro on 02/04/17.
 */

public class DetailCountryPresenter extends BasePresenter<DetailCountryView> {

    public static final String COUNTRY_PARAM = "COUNTRY_PARAM";

    private Country country;

    public DetailCountryPresenter(ParamsProvider bundleProvider) {
        country = bundleProvider.getParcelable(COUNTRY_PARAM);
    }

    @Override
    public void onViewCreated(DetailCountryView view) {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onDestroyed() {

    }

    @Override
    protected void initInject() {

    }

    @Override
    public void onSaveInstanceState(ParamsProvider bundleProvider) {
        bundleProvider.putParcelable(COUNTRY_PARAM, country);
    }

    public Country onCountryNeeded() {
        return country;
    }
}
