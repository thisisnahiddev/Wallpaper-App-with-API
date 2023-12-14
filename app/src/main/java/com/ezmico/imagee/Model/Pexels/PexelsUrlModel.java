package com.ezmico.imagee.Model.Pexels;

import com.google.gson.annotations.SerializedName;

public class PexelsUrlModel {
    @SerializedName("portrait")
    private String portrait;

    @SerializedName("original")
    private String original;

    @SerializedName("photographer")
    private String photographer;

    @SerializedName("photographer_url")
    private String photographer_url;


    public PexelsUrlModel(String portrait, String original, String photographer, String photographer_url) {
        this.portrait = portrait;
        this.original = original;
        this.photographer = photographer;
        this.photographer_url = photographer_url;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getPhotographer() {
        return photographer;
    }

    public void setPhotographer(String photographer) {
        this.photographer = photographer;
    }

    public String getPhotographer_url() {
        return photographer_url;
    }

    public void setPhotographer_url(String photographer_url) {
        this.photographer_url = photographer_url;
    }
}
