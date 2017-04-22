package com.example.leandro.countryapp.database;

import com.example.leandro.countryapp.model.dao.RequestData;

import io.realm.RealmAsyncTask;

/**
 * Represents a realm request.
 */

public class RequestDataDB implements RequestData {

    private RealmAsyncTask realmAsyncTask;

    public RequestDataDB(RealmAsyncTask realmAsyncTask) {
        this.realmAsyncTask = realmAsyncTask;
    }

    @Override
    public void cancelRequest() {
        realmAsyncTask.cancel();
    }

    @Override
    public boolean isRequestCancelled() {
        return realmAsyncTask.isCancelled();
    }
}
