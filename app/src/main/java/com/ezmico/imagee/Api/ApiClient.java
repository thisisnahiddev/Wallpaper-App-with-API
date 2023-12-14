package com.ezmico.imagee.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiClient {
    private static Retrofit RETROFIT = null;
    public static final String API = "ZODstSdpmRy48GCHwGyRERDKErShFgPhLKAbI8LZSNIpq5VvDp943XDX";
    public static final String Unsplash_API = "lYVqxY6ah7hOzwxQgE7pcDRm3f7ml8JEcMpf9eWwpMg";
    public static final String Pixabay_API = "40030520-4725fec6f7fd303cfc154f9f4";



  //

    public static PexelsApiInterface getApiInterface(){

        if (RETROFIT==null){
            RETROFIT = new Retrofit.Builder().baseUrl(PexelsApiInterface.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }


        return RETROFIT.create(PexelsApiInterface.class);


    }
    public static UnsplashApiInterface getUnsplashApiInterface(){

        if (RETROFIT==null){
            RETROFIT = new Retrofit.Builder().baseUrl(UnsplashApiInterface.UNSPLASH_BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }


        return RETROFIT.create(UnsplashApiInterface.class);


    }
    public static PixabayApiInterface getPixabayApiInterface(){

        if (RETROFIT==null){
            RETROFIT = new Retrofit.Builder().baseUrl(PixabayApiInterface.PIXABAY_BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }


        return RETROFIT.create(PixabayApiInterface.class);


    }







}
