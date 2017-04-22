package com.example.leandro.countryapp;

import android.app.Application;
import android.content.Context;
import android.support.test.runner.AndroidJUnitRunner;

/**
 * Custom runner that lets us use a custom {@link Application}.
 */
public class EspressoTestRunner extends AndroidJUnitRunner {

    @Override
    public Application newApplication(ClassLoader cl, String className, Context context) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return super.newApplication(cl, CountryTestApplication.class.getName(), context);
    }

}
