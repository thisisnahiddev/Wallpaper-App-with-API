package com.ezmico.imagee.Api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;


import com.ezmico.imagee.Model.Pexels.PexelsSearchModel;

import retrofit2.http.Query;
import static com.ezmico.imagee.Api.ApiClient.API;



public interface PexelsApiInterface {

    String BASE_URL = "https://api.pexels.com/v1/";


    @Headers("Authorization: "+API)
    @GET("curated")
    Call<PexelsSearchModel> getImage(
            @Query("page") int page,
            @Query("per_page") int per_page

    );

    @Headers("Authorization: "+API)
    @GET("photo")
    Call<PexelsSearchModel> getResource(
            @Query("page") int page,
            @Query("per_page") int per_page

    );

    @Headers("Authorization: "+API)
    @GET("search")
    Call<PexelsSearchModel> getSearchImage(
            @Query("query") String query,
            @Query("page") int page,
            @Query("per_page") int per_page

    );









}
