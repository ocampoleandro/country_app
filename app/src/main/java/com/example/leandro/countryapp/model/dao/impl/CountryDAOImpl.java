package com.example.leandro.countryapp.model.dao.impl;

import com.example.leandro.countryapp.model.dao.CountryDAO;
import com.example.leandro.countryapp.model.dao.RequestData;
import com.example.leandro.countryapp.model.dao.RequestDataNetwork;
import com.example.leandro.countryapp.model.dao.callback.ListCallback;
import com.example.leandro.countryapp.model.data.Country;
import com.example.leandro.countryapp.network.CountryClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by leandro on 24/03/17.
 */

public class CountryDAOImpl implements CountryDAO {

    private CountryClient countryClient;

    public CountryDAOImpl(CountryClient countryClient){
        this.countryClient = countryClient;
    }

    @Override
    public RequestData getCountriesByRegion(final String region, final ListCallback<Country> callback) {
        Call<List<Country>> call = countryClient.getCountriesByRegion(region);
        call.enqueue(new Callback<List<Country>>() {
            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
                if(response.isSuccessful()){
                    callback.onSuccess(response.body());
                }else {
                    callback.onError();
                }
            }

            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {
                callback.onError();
            }
        });
        return new RequestDataNetwork(call);
    }
}
