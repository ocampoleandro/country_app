package com.example.leandro.countryapp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.leandro.countryapp.CountryApplication;
import com.example.leandro.countryapp.R;
import com.example.leandro.countryapp.model.data.Country;
import com.example.leandro.countryapp.presenter.ListCountryPresenter;
import com.example.leandro.countryapp.presenter.factory.MainPresenterFactory;
import com.example.leandro.countryapp.presenter.factory.PresenterFactory;
import com.example.leandro.countryapp.service.CountryLocalUpdateService;
import com.example.leandro.countryapp.ui.adapter.CountryListAdapter;
import com.example.leandro.countryapp.ui.decorator.SimpleDividerRecyclerViewDecorator;
import com.example.leandro.countryapp.view.ListCountryView;

import org.parceler.Parcels;

import java.util.List;

import javax.inject.Inject;

public class ListCountryActivity extends BaseActivity<ListCountryPresenter> implements
        ListCountryView {

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
        countryListAdapter = new CountryListAdapter(null, presenter);
        rvCountries.setAdapter(countryListAdapter);

        progressCountry = findViewById(R.id.progress_country);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.fragment_version:
                launchMainActivityFragment();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void launchMainActivityFragment() {
        Intent mainIntent = new Intent(this, MainActivityFragment.class);
        Bundle bundleMain = new Bundle();
        bundleMain.putString(MainActivityFragment.CONTENT_TYPE_PARAM, MainActivityFragment.LIST_COUNTRIES);
        mainIntent.putExtras(bundleMain);
        startActivity(mainIntent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        progressCountry.setVisibility(View.VISIBLE);
        presenter.onCountriesRequested(Country.REGION_AMERICAS);
    }

    @NonNull
    @Override
    protected PresenterFactory<ListCountryPresenter> getPresenterFactory() {
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
        Toast.makeText(this, "Error fetching countries", Toast.LENGTH_SHORT).show();
        progressCountry.setVisibility(View.GONE);
    }

    @Override
    public void updateLocalModel(List<Country> countries) {
        Intent serviceIntent = new Intent(this, CountryLocalUpdateService.class);
        Bundle bundleService = new Bundle();
        bundleService.putParcelable(CountryLocalUpdateService.COUNTRIES_PARAM_KEY, Parcels.wrap(countries));
        serviceIntent.putExtras(bundleService);
        startService(serviceIntent);
    }

    @Override
    public void launchCountryDetail(Country country) {
        Intent detailIntent = new Intent(this, DetailCountryActivity.class);
        Bundle bundleDetail = new Bundle();
        bundleDetail.putParcelable(DetailCountryActivity.COUNTRY_PARAM, Parcels.wrap(country));
        detailIntent.putExtras(bundleDetail);
        startActivity(detailIntent);
    }
}
