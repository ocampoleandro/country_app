package com.example.leandro.countryapp.service;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.example.leandro.countryapp.CountryApplication;
import com.example.leandro.countryapp.database.CountryDBClient;
import com.example.leandro.countryapp.model.data.Country;

import org.parceler.Parcels;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by locampo on 4/7/17.
 */

public class CountryLocalUpdateService extends IntentService {

    private static final String SERVICE_NAME = "COUNTRY_LOCAL_UPDATE";
    public static final String COUNTRIES_PARAM_KEY = "COUNTRIES_PARAM_KEY";

    @Inject
    CountryDBClient countryDBClient;

    public CountryLocalUpdateService() {
        super(SERVICE_NAME);
        CountryApplication.getInstance().getDaoComponent().inject(this);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        List<Country> countriesToUpdate = Parcels.unwrap(intent.getExtras().getParcelable(COUNTRIES_PARAM_KEY));
        countryDBClient.save(countriesToUpdate);
    }
}
