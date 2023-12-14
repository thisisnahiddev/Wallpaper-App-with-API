package com.ezmico.imagee.Api;

import com.ezmico.imagee.Model.Pixabay.PixabaySearchModel;
import static com.ezmico.imagee.Api.ApiClient.Pixabay_API;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PixabayApiInterface {
    String PIXABAY_BASE_URL = "https://pixabay.com/api/";


    @GET("?key="+Pixabay_API)
    Call<PixabaySearchModel> getPixabayImage(
            @Query("page") int page,
            @Query("per_page") int per_page

    );

    @GET("?key="+Pixabay_API)
    Call<PixabaySearchModel> getPixabaySearchImage(
            @Query("q") String query,
            @Query("page") int page,
            @Query("per_page") int per_page

    );





}
