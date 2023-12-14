package com.ezmico.imagee.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ezmico.imagee.Activity.SetWallpaper;
import com.ezmico.imagee.Adapter.AdapterClick;
import com.ezmico.imagee.Adapter.ImageAdapter;
import com.ezmico.imagee.Api.ApiClient;
import com.ezmico.imagee.Model.Pexels.PexelsImageModel;
import com.ezmico.imagee.Model.Pexels.PexelsSearchModel;
import com.ezmico.imagee.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.ezmico.imagee.databinding.FragmentBottomSheetBinding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class BottomSheetFragment extends BottomSheetDialogFragment {



    public BottomSheetFragment() {
        // Required empty public constructor
    }
    private ArrayList<PexelsImageModel> pexelsList;
    FragmentBottomSheetBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {






        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bottom_sheet, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



    }

    private void getPexelsPhotos() {

        pexelsList.clear();
        ApiClient.getApiInterface().getImage(1, 80).enqueue(new Callback<PexelsSearchModel>() {
            @Override
            public void onResponse(Call<PexelsSearchModel> call, Response<PexelsSearchModel> response) {

                if (response.isSuccessful()) {
                    PexelsSearchModel myResponse = response.body();
                    if (myResponse != null) {
                        pexelsList = (ArrayList<PexelsImageModel>) myResponse.getPhotos();
                        if (pexelsList != null && pexelsList.size() > 0) {
                            ImageAdapter adapter = new ImageAdapter(getContext(), pexelsList,
                                    null, 1);
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




}