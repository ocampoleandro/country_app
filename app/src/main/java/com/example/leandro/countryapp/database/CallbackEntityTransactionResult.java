package com.example.leandro.countryapp.database;

import com.example.leandro.countryapp.model.data.BaseEntity;

/**
 * Callback for delivering the result from the database as a single entity.
 */

public interface CallbackEntityTransactionResult<T extends BaseEntity> extends CallbackTransactionResult {

    void onSuccess(T entity);

}
