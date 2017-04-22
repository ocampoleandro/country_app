package com.example.leandro.countryapp.network;

import com.example.leandro.countryapp.model.dao.RequestData;

import retrofit2.Call;

/**
 * Represents a retrofit network request.
 */

public class RequestDataNetwork implements RequestData {

    private Call request;

    public RequestDataNetwork(Call request) {
        this.request = request;
    }

    @Override
    public void cancelRequest() {
        this.request.cancel();
    }

    @Override
    public boolean isRequestCancelled() {
        return request.isCanceled();
    }
}
