package com.example.leandro.countryapp.model.dao;

import retrofit2.Call;

/**
 * Created by leandro on 02/04/17.
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
