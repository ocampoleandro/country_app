package com.example.leandro.countryapp.configuration.injection;

import com.example.leandro.countryapp.network.CountryClient;
import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by leandro on 24/03/17.
 */
@Module(includes = {NetModule.class})
public class CountryAPIModule {

    private static final String BASE_URL = "https://restcountries.eu/rest/v2/";

    @Provides
    @Singleton
    Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .build();
    }

    @Provides
    @Singleton
    CountryClient provideCountryClient(Retrofit retrofit){
        return retrofit.create(CountryClient.class);
    }

}
