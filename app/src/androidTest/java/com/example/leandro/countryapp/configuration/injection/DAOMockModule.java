package com.example.leandro.countryapp.configuration.injection;

import dagger.Module;

/**
 * Provides mocks for each dependency.
 */
@Module
public class DAOMockModule extends DAOModule {

    private static String COUNTRY_BASE_URL = "/";

    @Override
    protected String getCountryBaseUrl() {
        return COUNTRY_BASE_URL;
    }

    public static void setBaseUrl(String baseUrl) {
        COUNTRY_BASE_URL = baseUrl;
    }
}
