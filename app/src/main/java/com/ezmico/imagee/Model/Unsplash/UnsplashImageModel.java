package com.ezmico.imagee.Model.Unsplash;

import com.google.gson.annotations.SerializedName;

public class UnsplashImageModel {

    @SerializedName("urls")
    private UnsplashUrlModel urls;

    @SerializedName("id")
    private int id;

    public UnsplashImageModel(UnsplashUrlModel urls, int id) {
        this.urls = urls;
        this.id = id;
    }

    public UnsplashUrlModel getUrls() {
        return urls;
    }

    public void setUrls(UnsplashUrlModel urls) {
        this.urls = urls;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
