package com.ezmico.imagee.Model.Pexels;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PexelsSearchModel {

    @SerializedName("photos")
    private List<PexelsImageModel> photos;

    public PexelsSearchModel(List<PexelsImageModel> photos) {
        this.photos = photos;
    }

    public List<PexelsImageModel> getPhotos() {
        return photos;
    }

    public void setPhotos(List<PexelsImageModel> photos) {
        this.photos = photos;
    }
}
