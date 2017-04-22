package com.example.leandro.countryapp.model.data;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@SuppressWarnings("WeakerAccess")
@Parcel(Parcel.Serialization.BEAN)
public class Country extends BaseEntity {

    public static final String REGION_AMERICAS = "Americas";

    private String name;
    private String capital;
    private int population;
    @SerializedName("latlng")
    private double[] latLong;
    @SerializedName("flag")
    private String flagUrl;

    public Country() {

    }

    public Country(String name, String capital, int population, double[] latLong, String flagUrl) {
        this.name = name;
        this.capital = capital;
        this.population = population;
        this.latLong = latLong;
        this.flagUrl = flagUrl;
    }

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

    public String getFlagUrl() {
        return flagUrl;
    }

    public void setFlagUrl(String flagUrl) {
        this.flagUrl = flagUrl;
    }

    public double[] getLatLong() {
        return latLong;
    }

    public void setLatLong(double[] latLong) {
        this.latLong = latLong;
    }
}
