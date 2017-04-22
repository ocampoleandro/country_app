package com.example.leandro.countryapp.view;

import com.example.leandro.countryapp.model.data.Country;

import java.util.List;

public interface ListCountryView {
    void deliverCountries(List<Country> countries);

    void deliverErrorFetchingCountries();

    void updateLocalModel(List<Country> countries);

    void launchCountryDetail(Country country);
}
