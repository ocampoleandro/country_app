package com.example.leandro.countryapp.network;

import com.example.leandro.countryapp.model.data.Country;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by leandro on 24/03/17.
 */

public interface CountryClient {

    @SuppressWarnings("SpellCheckingInspection")
    @GET("region/{region}?fields=name;capital;population;latlng;flag")
    Call<List<Country>> getCountriesByRegion(@Path("region")String region);
}
