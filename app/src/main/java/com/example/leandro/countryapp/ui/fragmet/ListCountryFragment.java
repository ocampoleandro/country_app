package com.example.leandro.countryapp.ui.fragmet;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.leandro.countryapp.CountryApplication;
import com.example.leandro.countryapp.R;
import com.example.leandro.countryapp.model.data.Country;
import com.example.leandro.countryapp.presenter.ListCountryPresenter;
import com.example.leandro.countryapp.presenter.factory.MainPresenterFactory;
import com.example.leandro.countryapp.presenter.factory.PresenterFactory;
import com.example.leandro.countryapp.service.CountryLocalUpdateService;
import com.example.leandro.countryapp.ui.activity.MainActivityFragment;
import com.example.leandro.countryapp.ui.adapter.CountryListAdapter;
import com.example.leandro.countryapp.ui.decorator.SimpleDividerRecyclerViewDecorator;
import com.example.leandro.countryapp.view.ListCountryView;

import org.parceler.Parcels;

import java.util.List;

import javax.inject.Inject;

public class ListCountryFragment extends BaseFragment<ListCountryPresenter> implements
        ListCountryView {

    @Inject
    MainPresenterFactory presenterFactory;

    View progressCountry;
    CountryListAdapter countryListAdapter;

    public ListCountryFragment() {

    }

    public static ListCountryFragment newInstance() {
        return new ListCountryFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_country, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView rvCountries = (RecyclerView) view.findViewById(R.id.rv_countries);
        rvCountries.setLayoutManager(new LinearLayoutManager(getContext()));
        rvCountries.setHasFixedSize(true);
        rvCountries.addItemDecoration(new SimpleDividerRecyclerViewDecorator(getContext()));
        countryListAdapter = new CountryListAdapter(null, presenter);
        rvCountries.setAdapter(countryListAdapter);

        progressCountry = view.findViewById(R.id.progress_country);
    }

    @Override
    public void onStart() {
        super.onStart();
        progressCountry.setVisibility(View.VISIBLE);
        presenter.onCountriesRequested(Country.REGION_AMERICAS);
    }

    @Override
    public void deliverCountries(List<Country> countries) {
        countryListAdapter.refreshContent(countries);
        progressCountry.setVisibility(View.GONE);
    }

    @Override
    public void deliverErrorFetchingCountries() {
        Toast.makeText(getContext(), "Error fetching countries", Toast.LENGTH_SHORT).show();
        progressCountry.setVisibility(View.GONE);
    }

    @Override
    public void updateLocalModel(List<Country> countries) {
        Intent serviceIntent = new Intent(getActivity(), CountryLocalUpdateService.class);
        Bundle bundleService = new Bundle();
        bundleService.putParcelable(CountryLocalUpdateService.COUNTRIES_PARAM_KEY, Parcels.wrap(countries));
        serviceIntent.putExtras(bundleService);
        getActivity().startService(serviceIntent);
    }

    @Override
    public void launchCountryDetail(Country country) {
        Intent detailIntent = new Intent(getActivity(), MainActivityFragment.class);
        Bundle bundleDetail = new Bundle();
        bundleDetail.putString(MainActivityFragment.CONTENT_TYPE_PARAM, MainActivityFragment.COUNTRY_DETAIL);
        bundleDetail.putParcelable(CountryDetailFragment.COUNTRY_PARAM, Parcels.wrap(country));
        detailIntent.putExtras(bundleDetail);
        startActivity(detailIntent);
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
}
