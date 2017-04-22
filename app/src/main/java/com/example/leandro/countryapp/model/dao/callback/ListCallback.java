package com.example.leandro.countryapp.model.dao.callback;

import java.util.List;

/**
 * Returns the model information as a list.
 */

public interface ListCallback<T> {
    /**
     * the information could be fetched
     *
     * @param data      the model information
     * @param localData indicates if the information comes from the network or from the local database
     */
    void onSuccess(List<T> data, boolean localData);

    void onError();
}
