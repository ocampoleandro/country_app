package com.example.leandro.countryapp.ui.provider;

import android.os.Bundle;

import org.parceler.Parcels;

/**
 * Lets fetch and save information from and in a {@link Bundle}.
 */
public class ParamsProvider {

    //bundle to save or fetch information from a previous state
    protected Bundle savedInstanceState;

    public ParamsProvider(Bundle savedInstanceState) {
        this.savedInstanceState = savedInstanceState;
    }

    public <T> T getParcelable(String key) {
        Bundle bundle = getBundle();
        if (bundle != null) {
            return Parcels.unwrap(getBundle().getParcelable(key));
        } else {
            return null;
        }
    }

    public String getString(String key) {
        Bundle bundle = getBundle();
        if (bundle != null) {
            return getBundle().getString(key);
        } else {
            return null;
        }
    }

    public void putParcelable(String key, Object value) {
        savedInstanceState.putParcelable(key, Parcels.wrap(value));
    }

    public void putString(String key, String value) {
        savedInstanceState.putString(key, value);
    }

    protected Bundle getBundle() {
        return savedInstanceState;
    }

}
