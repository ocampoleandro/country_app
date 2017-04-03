package com.example.leandro.countryapp.view;

import com.example.leandro.countryapp.model.data.Country;
import com.example.leandro.countryapp.presenter.MainPresenter;

import java.util.List;

/**
 * Created by leandro on 25/03/17.
 */

public interface MainView<P extends MainPresenter> extends MvpView<P> {
    void deliverCountries(List<Country> countries);
    void deliverErrorFetchingCountries();
}
