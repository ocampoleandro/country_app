package com.example.leandro.countryapp.database;

import com.example.leandro.countryapp.model.data.Country;

import java.util.List;

/**
 * Gives access to countries that are inside the database.
 */

public interface CountryDBClient {

    void save(List<Country> countries);

    RequestDataDB list(final CallbackListTransactionResult<Country> callback);
}
