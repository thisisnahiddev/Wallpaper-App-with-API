package com.ezmico.imagee.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ezmico.imagee.Activity.SetWallpaper;
import com.ezmico.imagee.Adapter.ImageAdapter;
import com.ezmico.imagee.Adapter.AdapterClick;
import com.ezmico.imagee.Api.ApiClient;
import com.ezmico.imagee.Model.Pexels.PexelsImageModel;
import com.ezmico.imagee.Model.Pexels.PexelsSearchModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.ezmico.imagee.databinding.FragmentHomeBinding;

public class TrendingFragment extends Fragment implements AdapterClick {

    FragmentHomeBinding binding;

    public TrendingFragment() {
        // Required empty public constructor
    }


    private ArrayList<PexelsImageModel> trendingList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false);

        trendingList = new ArrayList<>();

        binding.progressBar.setVisibility(View.VISIBLE);
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        getPexelsPhotos();


        return binding.getRoot();
    }

    @Override
    public void itemClick(PexelsImageModel pexelsImageModel, int position,String image) {
        Intent intent = new Intent(getContext(), SetWallpaper.class);
        intent.putExtra("position", position);
        startActivity(intent);


    }




    private void getPexelsPhotos() {

        trendingList.clear();

        ApiClient.getApiInterface().getImage(1, 80).enqueue(new Callback<PexelsSearchModel>() {
            @Override
            public void onResponse(Call<PexelsSearchModel> call, Response<PexelsSearchModel> response) {

                binding.progressBar.setVisibility(View.GONE);
                if (response.isSuccessful()) {
                    PexelsSearchModel myResponse = response.body();
                    if (myResponse != null) {
                        trendingList = (ArrayList<PexelsImageModel>) myResponse.getPhotos();
                        if (trendingList != null && trendingList.size() > 0) {
                            ImageAdapter adapter = new ImageAdapter(getContext(), trendingList,
                                    TrendingFragment.this, 0);
                            binding.recyclerView.setAdapter(adapter);
                        }
                    }

                }

            }

            @Override
            public void onFailure(Call<PexelsSearchModel> call, Throwable t) {

            }
        });


    }
}