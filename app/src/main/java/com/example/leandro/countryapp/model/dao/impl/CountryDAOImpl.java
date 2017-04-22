package com.example.leandro.countryapp.model.dao.impl;

import com.example.leandro.countryapp.database.CallbackListTransactionResult;
import com.example.leandro.countryapp.database.CountryDBClient;
import com.example.leandro.countryapp.model.dao.CountryDAO;
import com.example.leandro.countryapp.model.dao.RequestData;
import com.example.leandro.countryapp.model.dao.callback.ListCallback;
import com.example.leandro.countryapp.model.data.Country;
import com.example.leandro.countryapp.network.CountryNetClient;
import com.example.leandro.countryapp.network.RequestDataNetwork;
import com.example.leandro.countryapp.util.NetworkUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountryDAOImpl implements CountryDAO {

    private CountryNetClient countryNetClient;
    private CountryDBClient countryDBClient;

    public CountryDAOImpl(CountryNetClient countryNetClient, CountryDBClient countryDBClient) {
        this.countryNetClient = countryNetClient;
        this.countryDBClient = countryDBClient;
    }

    @Override
    public RequestData getCountriesByRegion(final String region, final ListCallback<Country> callback) {
        if (NetworkUtil.testInternetConnection()) {
            Call<List<Country>> call = countryNetClient.getCountriesByRegion(region);
            call.enqueue(new Callback<List<Country>>() {
                @Override
                public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
                    if (response.isSuccessful()) {
                        callback.onSuccess(response.body(), false);
                    } else {
                        callback.onError();
                    }
                }

                @Override
                public void onFailure(Call<List<Country>> call, Throwable t) {
                    callback.onError();
                }
            });
            return new RequestDataNetwork(call);
        } else {
            return countryDBClient.list(new CallbackListTransactionResult<Country>() {
                @Override
                public void onSuccess(List<Country> entities) {
                    callback.onSuccess(entities, true);
                }

                @Override
                public void onError(Throwable error) {
                    callback.onError();
                }
            });

        }
    }
}
