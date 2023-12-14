package com.ezmico.imagee.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.SnapHelper;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.ezmico.imagee.Api.ApiClient;
import com.ezmico.imagee.Fragments.BottomSheetFragment;
import com.ezmico.imagee.Model.Pexels.PexelsSearchModel;
import com.ezmico.imagee.Model.Pexels.PexelsImageModel;
import com.ezmico.imagee.R;


import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.ezmico.imagee.Adapter.ImageAdapter;
import com.ezmico.imagee.databinding.ActivitySetWallpaperBinding;

public class SetWallpaper extends AppCompatActivity {

    ActivitySetWallpaperBinding binding;

    private static int SET_TYPE = 0;

    private ArrayList<PexelsImageModel> pexelsList;
    public static int IntentPosition;
    String selectedImage;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySetWallpaperBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        pexelsList = new ArrayList<>();



        binding.progressBar.setVisibility(View.VISIBLE);
        // ProgressBoxForImage();
        intent = getIntent();
        if (intent != null) {
            IntentPosition = intent.getIntExtra("position",0);
            selectedImage = intent.getStringExtra("image");

        }


        binding.imageRecyclerview.setHasFixedSize(true);
        binding.imageRecyclerview.setLayoutManager(new LinearLayoutManager(SetWallpaper.this,
                LinearLayoutManager.HORIZONTAL, false));
        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(binding.imageRecyclerview);


        getPexelsPhotos();


        binding.setBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Dialog setDialog = new Dialog(SetWallpaper.this);
                setDialog.setContentView(R.layout.custom_set);

                TextView homeScreen = setDialog.findViewById(R.id.homeScreen);
                TextView lockScreen = setDialog.findViewById(R.id.lockScreen);
                TextView bothScreen = setDialog.findViewById(R.id.bothScreen);

                //........

                homeScreen.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        setDialog.dismiss();

                        SET_TYPE = 1;

                        setWallpaperFromUrl(SetWallpaper.this, selectedImage);


                        Toast.makeText(getApplicationContext(), "Set Wallpaper Successfully", Toast.LENGTH_SHORT).show();


                    }
                });
                lockScreen.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setDialog.dismiss();
                        SET_TYPE = 2;

                        setWallpaperFromUrl(SetWallpaper.this, selectedImage);

                        Toast.makeText(getApplicationContext(), "Set Wallpaper Successfully", Toast.LENGTH_SHORT).show();


                    }
                });
                bothScreen.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setDialog.dismiss();

                        SET_TYPE = 0;

                        setWallpaperFromUrl(SetWallpaper.this, selectedImage);
                        Toast.makeText(getApplicationContext(), "Set Wallpaper Successfully", Toast.LENGTH_SHORT).show();


                    }
                });

                setDialog.show();


            }
        });

        binding.topMenu.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {


                BottomSheetFragment bottomSheetFragment = new BottomSheetFragment();
                bottomSheetFragment.show(getSupportFragmentManager(), bottomSheetFragment.getTag());





            }
        });
        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(SetWallpaper.this, MainActivity.class));
                finishAffinity();

            }
        });


    }


    private void getPexelsPhotos() {


        ApiClient.getApiInterface().getImage(1, 80).enqueue(new Callback<PexelsSearchModel>() {
            @Override
            public void onResponse(Call<PexelsSearchModel> call, Response<PexelsSearchModel> response) {

                binding.progressBar.setVisibility(View.GONE);
                if (response.isSuccessful()) {
                    PexelsSearchModel myResponse = response.body();
                    if (myResponse != null) {
                        pexelsList = (ArrayList<PexelsImageModel>) myResponse.getPhotos();
                        if (pexelsList != null && pexelsList.size() > 0) {
                            ImageAdapter adapter = new ImageAdapter(SetWallpaper.this, pexelsList,
                                    null, 1);
                            binding.imageRecyclerview.setAdapter(adapter);
                            binding.imageRecyclerview.scrollToPosition(IntentPosition);
                        }
                    }

                }

            }

            @Override
            public void onFailure(Call<PexelsSearchModel> call, Throwable t) {

                Log.e("failure", t.getLocalizedMessage());
            }
        });


    }


    //----- Setting Wallpaper----//////////////////////////////////////////
    public static void setWallpaperFromUrl(Context context, String imageUrl) {

        new WallpaperAsyncTask(context).execute(imageUrl);
    }

    private static class WallpaperAsyncTask extends AsyncTask<String, Void, BitmapDrawable> {

        private final Context context;


        public WallpaperAsyncTask(Context context) {
            this.context = context;
        }

        @Override
        protected BitmapDrawable doInBackground(String... params) {
            String imageUrl = params[0];

            try {
                URL url = new URL(imageUrl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoInput(true);
                connection.connect();

                InputStream input = connection.getInputStream();

                Bitmap bitmap = BitmapFactory.decodeStream(input);

                BitmapDrawable drawable = new BitmapDrawable(Resources.getSystem(), bitmap);

                input.close();
                connection.disconnect();

                return drawable;


            } catch (Exception e) {
                return null;
            }

        }

        @Override
        protected void onPostExecute(BitmapDrawable bitmapDrawable) {

            if (bitmapDrawable != null) {
                setWallpaper(context, bitmapDrawable);
            }
        }

        private void setWallpaper(Context context, BitmapDrawable drawable) {

            WallpaperManager wallpaperManager = WallpaperManager.getInstance(context);

            try {
                if (SET_TYPE == 1) {

                    wallpaperManager.setBitmap(drawable.getBitmap(), null, true, WallpaperManager.FLAG_SYSTEM);

                } else if (SET_TYPE == 2) {
                    wallpaperManager.setBitmap(drawable.getBitmap(), null, true, WallpaperManager.FLAG_LOCK);


                } else {
                    wallpaperManager.setBitmap(drawable.getBitmap());
                }


            } catch (Exception e) {

            }


        }
    }

    //----- Setting Wallpaper----//////////////////////////////////////////--


}