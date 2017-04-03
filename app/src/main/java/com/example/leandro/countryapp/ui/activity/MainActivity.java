package com.example.leandro.countryapp.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.leandro.countryapp.CountryApplication;
import com.example.leandro.countryapp.R;
import com.example.leandro.countryapp.model.data.Country;
import com.example.leandro.countryapp.presenter.MainPresenter;
import com.example.leandro.countryapp.presenter.factory.MainPresenterFactory;
import com.example.leandro.countryapp.presenter.factory.PresenterFactory;
import com.example.leandro.countryapp.ui.adapter.CountryListAdapter;
import com.example.leandro.countryapp.ui.decorator.SimpleDividerRecyclerViewDecorator;
import com.example.leandro.countryapp.view.MainView;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends BaseActivity<MainPresenter> implements MainView<MainPresenter> {

    @Inject
    MainPresenterFactory presenterFactory;

    View progressCountry;
    CountryListAdapter countryListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvCountries = (RecyclerView) findViewById(R.id.rv_countries);
        rvCountries.setLayoutManager(new LinearLayoutManager(this));
        rvCountries.setHasFixedSize(true);
        rvCountries.addItemDecoration(new SimpleDividerRecyclerViewDecorator(this));
        countryListAdapter = new CountryListAdapter(null);
        rvCountries.setAdapter(countryListAdapter);

        progressCountry = findViewById(R.id.progress_country);
    }

    @Override
    protected void onStart() {
      super.onStart();
      progressCountry.setVisibility(View.VISIBLE);
      presenter.onCountriesRequested(Country.REGION_AMERICAS);
    }

    @NonNull
    @Override
    protected PresenterFactory<MainPresenter> getPresenterFactory() {
        return presenterFactory;
    }

    @Override
    protected void initInject() {
        CountryApplication.getInstance().getPresenterFactoryComponent().inject(this);
    }

    @Override
    public void deliverCountries(List<Country> countries) {
        countryListAdapter.refreshContent(countries);
        progressCountry.setVisibility(View.GONE);
    }

    @Override
    public void deliverErrorFetchingCountries() {
        Toast.makeText(this,"Error fetching countries",Toast.LENGTH_SHORT).show();
        progressCountry.setVisibility(View.GONE);
    }
}
