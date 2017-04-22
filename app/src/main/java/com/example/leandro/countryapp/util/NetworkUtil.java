package com.example.leandro.countryapp.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.leandro.countryapp.CountryApplication;

/**
 * Check the network connection.
 */

public class NetworkUtil {

    /**
     * Test the network connection.
     *
     * @return true if there is connection available.
     */
    public static boolean testInternetConnection() {
        ConnectivityManager cm =
                (ConnectivityManager) CountryApplication.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnected() && netInfo.isAvailable();
    }

}
