package com.example.leandro.countryapp.ui.fragmet;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.leandro.countryapp.CountryApplication;
import com.example.leandro.countryapp.R;
import com.example.leandro.countryapp.model.data.Country;
import com.example.leandro.countryapp.presenter.DetailCountryPresenter;
import com.example.leandro.countryapp.presenter.factory.DetailCountryPresenterFactory;
import com.example.leandro.countryapp.presenter.factory.PresenterFactory;
import com.example.leandro.countryapp.view.DetailCountryView;

import org.parceler.Parcels;

import javax.inject.Inject;

public class CountryDetailFragment extends BaseFragment<DetailCountryPresenter> implements DetailCountryView {

    public static final String COUNTRY_PARAM = DetailCountryPresenter.COUNTRY_PARAM;

    @Inject
    DetailCountryPresenterFactory presenterFactory;

    public CountryDetailFragment() {

    }

    public static CountryDetailFragment newInstance(Country country) {
        CountryDetailFragment fragment = new CountryDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(COUNTRY_PARAM, Parcels.wrap(country));
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail_country, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Country country = presenter.onCountryNeeded();
        TextView tvCountryName = (TextView) view.findViewById(R.id.tv_country_name);
        tvCountryName.setText(country.getName());
        TextView tvCapital = (TextView) view.findViewById(R.id.tv_capital);
        tvCapital.setText(country.getCapital());
        TextView tvPopulation = (TextView) view.findViewById(R.id.tv_population);
        tvPopulation.setText(String.valueOf(country.getPopulation()));
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
