package com.example.leandro.countryapp.ui.provider;

import android.os.Bundle;

/**
 * Lets fetch information from an {@link Bundle} bundle (information that was passed as parameters mainly).
 * Also gives the {@link ParamsProvider} capabilities.
 */

public class BundleProviderImpl extends ParamsProvider {

    private Bundle params;

    public BundleProviderImpl(Bundle savedInstanceState, Bundle params) {
        super(savedInstanceState);
        this.params = params;
    }


    @Override
    protected Bundle getBundle() {
        return (savedInstanceState != null) ? savedInstanceState : params;
    }

}
