package com.ezmico.imagee.Model.Pixabay;

import android.app.WallpaperManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;

import com.google.gson.annotations.SerializedName;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PixabayImageModel {

    @SerializedName("user")
    private String user;

    @SerializedName("largeImageURL")
    private String largeImageURL;

    @SerializedName("previewURL")
    private String previewURL;

    @SerializedName("tags")
    private String tags;

    @SerializedName("downloads")
    private String downloads;

    @SerializedName("type")
    private String type;


    public PixabayImageModel(String user, String largeImageURL, String previewURL, String tags, String downloads, String type) {
        this.user = user;
        this.largeImageURL = largeImageURL;
        this.previewURL = previewURL;
        this.tags = tags;
        this.downloads = downloads;
        this.type = type;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLargeImageURL() {
        return largeImageURL;
    }

    public void setLargeImageURL(String largeImageURL) {
        this.largeImageURL = largeImageURL;
    }

    public String getPreviewURL() {
        return previewURL;
    }

    public void setPreviewURL(String previewURL) {
        this.previewURL = previewURL;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getDownloads() {
        return downloads;
    }

    public void setDownloads(String downloads) {
        this.downloads = downloads;
    }





}
