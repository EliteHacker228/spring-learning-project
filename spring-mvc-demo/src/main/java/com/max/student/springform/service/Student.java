package com.max.student.springform.service;

import java.util.HashMap;

public class Student {
    private String firstName;
    private String lastName;

    private String country;
    private HashMap<String, String> countryOptions;

    private String favouriteLanguage;

    private String[] operatingSystems;

    public Student() {
        countryOptions = new HashMap<>();
        countryOptions.put("RU", "Russian Federation");
        countryOptions.put("US", "USA");
        countryOptions.put("DE", "Germany");
        countryOptions.put("FR", "France");
        countryOptions.put("ES", "Spain");
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public HashMap<String, String> getCountryOptions() {
        return countryOptions;
    }

    public void setCountryOptions(HashMap<String, String> countryOptions) {
        this.countryOptions = countryOptions;
    }

    public String getFavouriteLanguage() {
        return favouriteLanguage;
    }

    public void setFavouriteLanguage(String favouriteLanguage) {
        this.favouriteLanguage = favouriteLanguage;
    }

    public String[] getOperatingSystems() {
        return operatingSystems;
    }

    public void setOperatingSystems(String[] operatingSystems) {
        this.operatingSystems = operatingSystems;
    }
}