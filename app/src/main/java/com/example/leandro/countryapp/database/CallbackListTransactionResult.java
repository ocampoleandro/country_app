package com.example.leandro.countryapp.database;

import com.example.leandro.countryapp.model.data.BaseEntity;

import java.util.List;

/**
 * Callback for delivering the result from the database as a list.
 */

public interface CallbackListTransactionResult<T extends BaseEntity> extends CallbackTransactionResult {
    void onSuccess(List<T> entities);
}
