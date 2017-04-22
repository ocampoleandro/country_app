package com.example.leandro.countryapp.model.dao;

/**
 * Gives the capability of cancelling a request if it is not needed anymore.
 */

public interface RequestData {

    void cancelRequest();

    boolean isRequestCancelled();
}
