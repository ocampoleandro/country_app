package com.example.leandro.countryapp.presenter;

import android.os.Bundle;

import com.example.leandro.countryapp.view.MvpView;

/**
 * Created by leandro on 19/03/17.
 */

public interface MvpPresenter<V extends MvpView> {

    void onViewCreated(V view);
    void onStart();
    void onDestroyed();
    void onSaveInstanceState(Bundle outState);
}
