package com.example.leandro.countryapp.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.leandro.countryapp.presenter.BasePresenter;
import com.example.leandro.countryapp.presenter.factory.PresenterFactory;
import com.example.leandro.countryapp.ui.provider.IntentExtrasProviderImpl;
import com.example.leandro.countryapp.ui.provider.ParamsProvider;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {

    protected P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initInject();
        presenter = getPresenterFactory().create(new IntentExtrasProviderImpl(savedInstanceState, getIntent()));
        //noinspection unchecked
        presenter.onViewCreated(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        presenter.onSaveInstanceState(new ParamsProvider(outState));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroyed();
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.onStart();
    }

    @NonNull
    protected abstract PresenterFactory<P> getPresenterFactory();

    protected abstract void initInject();
}
