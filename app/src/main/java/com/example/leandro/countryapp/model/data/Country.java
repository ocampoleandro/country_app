package com.example.leandro.countryapp.model.data;

import org.parceler.Parcel;

/**
 * Created by leandro on 25/03/17.
 */
@Parcel(Parcel.Serialization.BEAN)
public class Country {

    public static final String REGION_AMERICAS = "Americas";

    private String name;
    private String capital;
    private int population;
    private int[] latLong;
    private String flagUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int[] getLatLong() {
        return latLong;
    }

    public void setLatLong(int[] latLong) {
        this.latLong = latLong;
    }

    public String getFlagUrl() {
        return flagUrl;
    }

    public void setFlagUrl(String flagUrl) {
        this.flagUrl = flagUrl;
    }
}
