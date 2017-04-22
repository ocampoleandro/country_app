package com.example.leandro.countryapp.configuration.injection;

import com.example.leandro.countryapp.database.CountryDBClient;
import com.example.leandro.countryapp.database.impl.CountryDBClientImpl;
import com.example.leandro.countryapp.model.dao.CountryDAO;
import com.example.leandro.countryapp.model.dao.impl.CountryDAOImpl;
import com.example.leandro.countryapp.network.CountryNetClient;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Provides the components that give access to the data model. DAO, DATABASE AND NET.
 */
@Module
public class DAOModule {

    private static final String BASE_URL = "https://restcountries.eu/rest/v2/";

    @Provides
    @Singleton
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        return new OkHttpClient();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(getCountryBaseUrl())
                .client(okHttpClient)
                .build();
    }

    @Provides
    @Singleton
    CountryNetClient provideCountryClient(Retrofit retrofit) {
        return retrofit.create(CountryNetClient.class);
    }

    @Provides
    @Singleton
    CountryDBClient provideCountryDBClient() {
        return new CountryDBClientImpl();
    }

    @Provides
    @Singleton
    CountryDAO provideCountryDAO(CountryNetClient countryNetClient, CountryDBClient countryDBClient) {
        return new CountryDAOImpl(countryNetClient, countryDBClient);
    }

    protected String getCountryBaseUrl() {
        return BASE_URL;
    }
}
