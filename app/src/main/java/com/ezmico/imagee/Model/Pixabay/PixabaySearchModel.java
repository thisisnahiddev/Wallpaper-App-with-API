package com.ezmico.imagee.Model.Pixabay;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class PixabaySearchModel {

    @SerializedName("hits")
    private ArrayList<PixabayImageModel> hits;

    public PixabaySearchModel(ArrayList<PixabayImageModel> hits) {
        this.hits = hits;
    }

    public ArrayList<PixabayImageModel> getHits() {
        return hits;
    }

    public void setHits(ArrayList<PixabayImageModel> hits) {
        this.hits = hits;
    }
}
