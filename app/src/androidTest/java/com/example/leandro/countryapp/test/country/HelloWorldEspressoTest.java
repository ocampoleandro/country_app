package com.example.leandro.countryapp.test.country;

import android.content.Intent;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.IdlingResource;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.leandro.countryapp.CountryTestApplication;
import com.example.leandro.countryapp.R;
import com.example.leandro.countryapp.configuration.injection.DAOMockModule;
import com.example.leandro.countryapp.test.BaseEspressoTest;
import com.example.leandro.countryapp.ui.activity.ListCountryActivity;
import com.example.leandro.countryapp.ui.adapter.CountryListAdapter;
import com.example.leandro.countryapp.util.FileUtil;
import com.jakewharton.espresso.OkHttp3IdlingResource;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by locampo on 4/10/17.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class HelloWorldEspressoTest extends BaseEspressoTest {

    @Inject
    OkHttpClient client;
    private IdlingResource resource;
    private MockWebServer server;

    @Rule
    public ActivityTestRule<ListCountryActivity> mActivityRule = new ActivityTestRule<>(ListCountryActivity.class, true, false);

    @Before
    public void setup() throws IOException {
        ((CountryTestApplication) CountryTestApplication.getInstance()).getDaoComponent().inject(this);
        resource = OkHttp3IdlingResource.create("OkHttp", client);
        Espresso.registerIdlingResources(resource);

        server = new MockWebServer();
        server.start();
        DAOMockModule.setBaseUrl(server.url(COUNTRY_NETWORK_BASE_URL).toString());
    }

    @After
    public void after() throws IOException {
        Espresso.unregisterIdlingResources(resource);
        server.shutdown();
    }

    @Test
    public void listGoesOverTheFold() throws Exception {
        String fileName = COUNTRY_NETWORK_BASE_URL + "list_200_ok_response.json";
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(FileUtil.getStringFromFile(getInstrumentation().getContext(), fileName)));

        Intent intent = new Intent();
        mActivityRule.launchActivity(intent);

        onView(ViewMatchers.withId(R.id.rv_countries)).perform(RecyclerViewActions.scrollToHolder(withHolderTimeView("Argentina")));
        onView(withText("Argentina")).check(matches(isDisplayed()));
    }


    public static Matcher<RecyclerView.ViewHolder> withHolderTimeView(final String text) {
        return new BoundedMatcher<RecyclerView.ViewHolder, CountryListAdapter.CountryViewHolder>(CountryListAdapter.CountryViewHolder.class) {

            @Override
            public void describeTo(Description description) {
                description.appendText("No ViewHolder found with text: " + text);
            }

            @Override
            protected boolean matchesSafely(CountryListAdapter.CountryViewHolder item) {
                TextView timeViewText = (TextView) item.itemView.findViewById(R.id.tv_country_name);
                return timeViewText != null && timeViewText.getText().toString().contains(text);
            }
        };
    }

}
