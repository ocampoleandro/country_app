package com.example.leandro.countryapp.model.dao;

import com.example.leandro.countryapp.model.dao.callback.ListCallback;
import com.example.leandro.countryapp.model.data.Country;

/**
 * Created by leandro on 25/03/17.
 */

public interface CountryDAO {
    RequestData getCountriesByRegion(String region, ListCallback<Country> callback);
}
