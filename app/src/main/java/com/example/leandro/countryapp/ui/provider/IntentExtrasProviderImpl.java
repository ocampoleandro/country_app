package com.example.leandro.countryapp.ui.provider;

import android.content.Intent;
import android.os.Bundle;

/**
 * Lets fetch information from an {@link Intent} bundle. Also gives the {@link ParamsProvider} capabilities.
 */

public class IntentExtrasProviderImpl extends ParamsProvider {

    private Intent intent;

    public IntentExtrasProviderImpl(Bundle savedInstanceState, Intent intent) {
        super(savedInstanceState);
        this.intent = intent;
    }

    @Override
    protected Bundle getBundle() {
        return (savedInstanceState != null) ? savedInstanceState : intent.getExtras();
    }

}
