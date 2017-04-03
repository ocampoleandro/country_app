package com.example.leandro.countryapp.model.dao.callback;

import java.util.List;

/**
 * Created by leandro on 25/03/17.
 */

public interface ListCallback<T> {
    void onSuccess(List<T> data);
    void onError();
}
