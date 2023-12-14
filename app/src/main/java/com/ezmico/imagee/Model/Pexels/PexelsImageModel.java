package com.ezmico.imagee.Model.Pexels;

import com.google.gson.annotations.SerializedName;

public class PexelsImageModel {

    @SerializedName("src")
    private PexelsUrlModel src;

    public PexelsImageModel(PexelsUrlModel src) {
        this.src = src;
    }

    public PexelsUrlModel getSrc() {
        return src;
    }

    public void setSrc(PexelsUrlModel src) {
        this.src = src;
    }
}
