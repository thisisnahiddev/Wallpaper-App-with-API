package com.ezmico.imagee.Model.Unsplash;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UnsplashSearchModel {

    @SerializedName("results")
    private List<UnsplashImageModel> results;

    public UnsplashSearchModel(List<UnsplashImageModel> results) {
        this.results = results;
    }

    public List<UnsplashImageModel> getResults() {
        return results;
    }

    public void setResults(List<UnsplashImageModel> results) {
        this.results = results;
    }
}
