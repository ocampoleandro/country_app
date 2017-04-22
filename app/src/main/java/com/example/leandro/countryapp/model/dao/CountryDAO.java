package com.example.leandro.countryapp.model.dao;

import com.example.leandro.countryapp.model.dao.callback.ListCallback;
import com.example.leandro.countryapp.model.data.Country;

/**
 * Gives access to countries from different sources such as NET and Database.
 */

public interface CountryDAO {
    RequestData getCountriesByRegion(String region, ListCallback<Country> callback);
}
