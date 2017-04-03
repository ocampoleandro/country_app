package com.example.leandro.countryapp.model.dao.callback;

/**
 * Created by leandro on 25/03/17.
 */

public interface EntityCallback<T> {
    void onSuccess(T data);
    void onError();
}
