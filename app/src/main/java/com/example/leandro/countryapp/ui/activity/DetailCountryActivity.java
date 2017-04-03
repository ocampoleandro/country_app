package com.example.leandro.countryapp.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.example.leandro.countryapp.CountryApplication;
import com.example.leandro.countryapp.R;
import com.example.leandro.countryapp.model.data.Country;
import com.example.leandro.countryapp.presenter.DetailCountryPresenter;
import com.example.leandro.countryapp.presenter.factory.DetailCountryPresenterFactory;
import com.example.leandro.countryapp.presenter.factory.PresenterFactory;
import com.example.leandro.countryapp.view.DetailCountryView;

import javax.inject.Inject;

/**
 * Created by leandro on 01/04/17.
 */

public class DetailCountryActivity extends BaseActivity<DetailCountryPresenter>
        implements DetailCountryView<DetailCountryPresenter> {

    @Inject
    DetailCountryPresenterFactory presenterFactory;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_country);

        Country country = presenter.onCountryNeeded();
        TextView tvCountryName = (TextView) findViewById(R.id.tv_country_name);
        tvCountryName.setText(country.getName());
        TextView tvCapital = (TextView) findViewById(R.id.tv_capital);
        tvCapital.setText(country.getCapital());
        TextView tvPopulation = (TextView) findViewById(R.id.tv_population);
        tvPopulation.setText(country.getPopulation());
    }

    @NonNull
    @Override
    protected PresenterFactory<DetailCountryPresenter> getPresenterFactory() {
        return presenterFactory;
    }

    @Override
    protected void initInject() {
        CountryApplication.getInstance().getPresenterFactoryComponent().inject(this);
    }
}
