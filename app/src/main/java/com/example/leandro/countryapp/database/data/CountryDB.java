package com.example.leandro.countryapp.database.data;

import com.example.leandro.countryapp.model.data.Country;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

@SuppressWarnings("unused")
public class CountryDB extends RealmObject {

    @PrimaryKey
    private Long id;
    private String name;
    private String capital;
    private int population;
    private double latitude;
    private double longitude;
    private String flagUrl;

    public CountryDB() {

    }

    public CountryDB(Country country) {

        this.name = country.getName();
        this.capital = country.getCapital();
        this.population = country.getPopulation();
        if (country.getLatLong().length > 2) {
            this.latitude = country.getLatLong()[0];
            this.longitude = country.getLatLong()[1];

        }
        this.flagUrl = country.getFlagUrl();
    }

    public Country buildModel() {
        double[] latLong = {latitude, longitude};
        return new Country(name, capital, population, latLong, flagUrl);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getFlagUrl() {
        return flagUrl;
    }

    public void setFlagUrl(String flagUrl) {
        this.flagUrl = flagUrl;
    }
}
