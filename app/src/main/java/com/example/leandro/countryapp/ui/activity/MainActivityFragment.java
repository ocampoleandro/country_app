package com.example.leandro.countryapp.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.leandro.countryapp.R;
import com.example.leandro.countryapp.model.data.Country;
import com.example.leandro.countryapp.ui.fragmet.CountryDetailFragment;
import com.example.leandro.countryapp.ui.fragmet.ListCountryFragment;

import org.parceler.Parcels;

public class MainActivityFragment extends AppCompatActivity {

    private static final String FRAGMENT_ID = "MAIN_FRAGMENT";
    public static final String CONTENT_TYPE_PARAM = "CONTENT_TYPE_PARAM";
    public static final String LIST_COUNTRIES = "LIST_COUNTRIES";
    public static final String COUNTRY_DETAIL = "COUNTRY_DETAIL";

    private String contentType;

    private Fragment fragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fragment);
        Bundle bundle;
        if (savedInstanceState != null) {
            bundle = savedInstanceState;
        } else {
            bundle = getIntent().getExtras();
        }
        contentType = bundle.getString(CONTENT_TYPE_PARAM);
        setupContent(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(CONTENT_TYPE_PARAM, contentType);
        //Save the fragment's instance
        getSupportFragmentManager().putFragment(outState, FRAGMENT_ID, fragment);
    }

    private void setupContent(Bundle savedInstanceState) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Bundle bundle;
        if (savedInstanceState != null) {
            //get saved fragment
            fragment = getSupportFragmentManager().getFragment(savedInstanceState, FRAGMENT_ID);
        } else {
            bundle = getIntent().getExtras();
            switch (contentType) {
                case LIST_COUNTRIES:
                    fragment = ListCountryFragment.newInstance();
                    break;
                case COUNTRY_DETAIL:
                    fragment = CountryDetailFragment.newInstance(
                            (Country) Parcels.unwrap(bundle.getParcelable(CountryDetailFragment.COUNTRY_PARAM)));
                    break;
            }
            fragmentTransaction.replace(R.id.fragment_container, fragment).commit();
        }
    }

}
