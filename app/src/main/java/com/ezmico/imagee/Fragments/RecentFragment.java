package com.ezmico.imagee.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ezmico.imagee.Activity.SetWallpaper;
import com.ezmico.imagee.Adapter.ImageAdapter;
import com.ezmico.imagee.Api.ApiClient;
import com.ezmico.imagee.Model.Pexels.PexelsImageModel;
import com.ezmico.imagee.Model.Pexels.PexelsSearchModel;
import com.ezmico.imagee.Adapter.AdapterClick;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.ezmico.imagee.databinding.FragmentRecentBinding;


public class RecentFragment extends Fragment implements AdapterClick {

    FragmentRecentBinding binding;

    public RecentFragment() {
        // Required empty public constructor
    }

    private ArrayList<PexelsImageModel> recentList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRecentBinding.inflate(inflater, container, false);


        recentList = new ArrayList<>();

        binding.progressBar.setVisibility(View.VISIBLE);
        binding.recentRV.setHasFixedSize(true);
        binding.recentRV.setLayoutManager(new GridLayoutManager(getContext(), 2));

        String query = "new";
        getPexelsSearchImage(query);


        return binding.getRoot();
    }

    @Override
    public void itemClick(PexelsImageModel pexelsImageModel, int position, String image) {
        Intent intent = new Intent(getActivity(), SetWallpaper.class);
        intent.putExtra("position", position);
        intent.putExtra("image",image);
        startActivity(intent);
    }




    private void getPexelsSearchImage(String query) {
        recentList.clear();
        ApiClient.getApiInterface().getSearchImage(query, 1, 80).enqueue(new Callback<PexelsSearchModel>() {
            @Override
            public void onResponse(Call<PexelsSearchModel> call, Response<PexelsSearchModel> response) {


                binding.progressBar.setVisibility(View.GONE);
                if (response.isSuccessful()) {

                    PexelsSearchModel mySearchResponse = response.body();
                    if (mySearchResponse != null) {
                        recentList = (ArrayList<PexelsImageModel>) mySearchResponse.getPhotos();
                        if (recentList != null && recentList.size() > 0) {
                            ImageAdapter adapter = new ImageAdapter(getContext(), recentList,
                                    RecentFragment.this, 0);
                            binding.recentRV.setAdapter(adapter);
                        }
                    }

                } else {
                    Toast.makeText(getContext(), "Not able to get", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onFailure(Call<PexelsSearchModel> call, Throwable t) {

            }
        });


    }
}