package com.example.leandro.countryapp.database;

/**
 * Callback for delivering the result from the database.
 */

interface CallbackTransactionResult {

    void onError(Throwable error);
}
