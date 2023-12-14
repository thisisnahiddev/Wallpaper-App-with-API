package com.ezmico.imagee.Api;

import com.ezmico.imagee.Model.Unsplash.UnsplashSearchModel;

import static com.ezmico.imagee.Api.ApiClient.Unsplash_API;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface UnsplashApiInterface {

    String UNSPLASH_BASE_URL = "https://api.unsplash.com/";

    @Headers("Authorization: Client-ID "+Unsplash_API)
    @GET("photos")
    Call<UnsplashSearchModel> getUnsplashImage(
            @Query("page") int page,
            @Query("per_page") int per_page

    );

    @Headers("Authorization: Client-ID "+Unsplash_API)
    @GET("search/photos/")
    Call<UnsplashSearchModel> getUnsplashSearchImage(
            @Query("query") String query,
            @Query("page") int page,
            @Query("per_page") int per_page


    );


}
