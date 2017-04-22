package com.example.leandro.countryapp.ui.fragmet;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.example.leandro.countryapp.presenter.BasePresenter;
import com.example.leandro.countryapp.presenter.factory.PresenterFactory;
import com.example.leandro.countryapp.ui.provider.BundleProviderImpl;
import com.example.leandro.countryapp.ui.provider.ParamsProvider;

public abstract class BaseFragment<P extends BasePresenter> extends Fragment {

    protected P presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initInject();
        presenter = getPresenterFactory().create(new BundleProviderImpl(savedInstanceState, getArguments()));
        presenter.onViewCreated(this);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        presenter.onSaveInstanceState(new ParamsProvider(outState));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroyed();
    }

    @NonNull
    protected abstract PresenterFactory<P> getPresenterFactory();

    protected abstract void initInject();
}
