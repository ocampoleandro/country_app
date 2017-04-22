package com.example.leandro.countryapp.model.dao.callback;

/**
 * Returns the model information as a single entity.
 */

public interface EntityCallback<T> {
    void onSuccess(T data);

    void onError();
}
