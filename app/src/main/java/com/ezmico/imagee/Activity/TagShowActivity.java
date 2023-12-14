package com.ezmico.imagee.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.ezmico.imagee.Adapter.ImageAdapter;
import com.ezmico.imagee.Api.ApiClient;
import com.ezmico.imagee.Model.Pexels.PexelsImageModel;
import com.ezmico.imagee.Model.Pexels.PexelsSearchModel;
import com.ezmico.imagee.databinding.ActivityTagShowBinding;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.ezmico.imagee.Adapter.AdapterClick;

public class TagShowActivity extends AppCompatActivity implements AdapterClick {

    ActivityTagShowBinding binding;

    private ArrayList<PexelsImageModel> tagList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTagShowBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        tagList = new ArrayList<>();

        binding.progressBar.setVisibility(View.VISIBLE);
        binding.tagShowRV.setHasFixedSize(true);
        binding.tagShowRV.setLayoutManager(new GridLayoutManager(TagShowActivity.this, 2));

        Intent intent = getIntent();
        String categoryName = intent.getStringExtra("categoryName");
        String query = intent.getStringExtra("catQuery");



        getPexelsSearchImage(query);

        binding.tagName.setText(categoryName);
        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(TagShowActivity.this,MainActivity.class));


            }
        });


    }
    @Override
    public void itemClick(PexelsImageModel pexelsImageModel, int p,String image) {
        Intent intent = new Intent(TagShowActivity.this, SetWallpaper.class);
        intent.putExtra("position", p);
        intent.putExtra("image", image);
        startActivity(intent);
    }



    private void getPexelsSearchImage(String query) {
        tagList.clear();
        ApiClient.getApiInterface().getSearchImage(query, 1, 80).enqueue(new Callback<PexelsSearchModel>() {
            @Override
            public void onResponse(Call<PexelsSearchModel> call, Response<PexelsSearchModel> response) {


                binding.progressBar.setVisibility(View.GONE);
                if (response.isSuccessful()) {

                    PexelsSearchModel mySearchResponse = response.body();
                    if (mySearchResponse != null) {
                        tagList = (ArrayList<PexelsImageModel>) mySearchResponse.getPhotos();
                        if (tagList != null && tagList.size() > 0) {
                            ImageAdapter adapter = new ImageAdapter(TagShowActivity.this, tagList,
                                    TagShowActivity.this, 0);
                            binding.tagShowRV.setAdapter(adapter);
                        }
                    }

                } else {
                    Toast.makeText(TagShowActivity.this, "Not able to get", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onFailure(Call<PexelsSearchModel> call, Throwable t) {

            }
        });


    }
}