package com.example.leandro.countryapp.database.impl;

import com.example.leandro.countryapp.CountryApplication;
import com.example.leandro.countryapp.database.CallbackListTransactionResult;
import com.example.leandro.countryapp.database.CountryDBClient;
import com.example.leandro.countryapp.database.RequestDataDB;
import com.example.leandro.countryapp.database.data.CountryDB;
import com.example.leandro.countryapp.model.data.Country;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmAsyncTask;
import io.realm.RealmResults;

/**
 * Created by locampo on 4/6/17.
 */

public class CountryDBClientImpl implements CountryDBClient {


    @Override
    public void save(List<Country> countries) {
        final List<CountryDB> countryDBs = new ArrayList<>(countries.size());
        for (Country c : countries) {
            countryDBs.add(new CountryDB(c));
        }
        Realm.init(CountryApplication.getInstance());
        Realm realm = Realm.getDefaultInstance();

        long nextId = 0;
        for (CountryDB countryDB : countryDBs) {
            CountryDB countryDBPersisted = realm.where(CountryDB.class).equalTo("name", countryDB.getName()).findFirst();
            if (countryDBPersisted != null) {
                countryDB.setId(countryDBPersisted.getId());
            } else {
                // increment index
                Number currentIdNum = realm.where(CountryDB.class).max("id");
                if (currentIdNum == null && nextId == 0) {
                    nextId = 1;
                } else {
                    nextId = (currentIdNum != null && nextId < currentIdNum.longValue()) ? currentIdNum.longValue() + 1 : nextId + 1;
                }
                countryDB.setId(nextId);
            }
            realm.beginTransaction();
            realm.copyToRealmOrUpdate(countryDB);
            realm.commitTransaction();
        }
    }

    @Override
    public RequestDataDB list(final CallbackListTransactionResult<Country> callback) {
        final List<CountryDB> countryDBs = new ArrayList<>();
        Realm.init(CountryApplication.getInstance());
        Realm realm = Realm.getDefaultInstance();
        RealmAsyncTask asyncTask = realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                RealmResults<CountryDB> countryDBsResult = realm.where(CountryDB.class).findAll();
                if (countryDBsResult.size() > 0) {
                    countryDBs.addAll(realm.copyFromRealm(countryDBsResult));
                }
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                List<Country> countriesUpdated = new ArrayList<Country>(countryDBs.size());
                for (CountryDB cDB : countryDBs) {
                    countriesUpdated.add(cDB.buildModel());
                }
                callback.onSuccess(countriesUpdated);
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                callback.onError(error);
            }
        });
        return new RequestDataDB(asyncTask);
    }

}
