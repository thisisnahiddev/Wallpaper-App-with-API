package com.ezmico.imagee.Model.Unsplash;

import com.google.gson.annotations.SerializedName;

public class UnsplashUrlModel {

    @SerializedName("raw")
    private String raw;

    @SerializedName("regular")
    private String regular;

    public UnsplashUrlModel(String raw, String regular) {
        this.raw = raw;
        this.regular = regular;
    }

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    public String getRegular() {
        return regular;
    }

    public void setRegular(String regular) {
        this.regular = regular;
    }
}
