package com.example.leandro.countryapp.ui.fragmet;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.example.leandro.countryapp.presenter.MvpPresenter;
import com.example.leandro.countryapp.presenter.factory.PresenterFactory;
import com.example.leandro.countryapp.view.MvpView;

/**
 * Created by leandro on 19/03/17.
 */

public abstract class BasePresenterFragment<P extends MvpPresenter>  extends Fragment
        implements MvpView<P> {

    protected P presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = getPresenterFactory().create(savedInstanceState, getArguments(), null);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        presenter.onSaveInstanceState(outState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroyed();
    }

    @NonNull
    protected abstract PresenterFactory<P> getPresenterFactory();
}
