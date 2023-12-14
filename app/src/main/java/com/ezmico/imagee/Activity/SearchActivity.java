package com.ezmico.imagee.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;


import com.ezmico.imagee.Adapter.ImageAdapter;
import com.ezmico.imagee.Api.ApiClient;
import com.ezmico.imagee.Model.Pexels.PexelsImageModel;
import com.ezmico.imagee.Model.Pexels.PexelsSearchModel;
import com.ezmico.imagee.databinding.ActivitySearchBinding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.ezmico.imagee.Adapter.AdapterClick;


public class SearchActivity extends AppCompatActivity implements AdapterClick{

    ActivitySearchBinding binding;
    private ArrayList<PexelsImageModel> searchList;
    private ArrayList<String> spinnerList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySearchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        searchList = new ArrayList<>();
        spinnerList = new ArrayList<>();

        binding.searchRV.setHasFixedSize(true);
        binding.searchRV.setLayoutManager(new GridLayoutManager(SearchActivity.this, 2));

        binding.back.setOnClickListener(v -> {
            startActivity(new Intent(SearchActivity.this, MainActivity.class));
            finish();

        });
        binding.searchIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String query = binding.searchInput.getText().toString().trim().toLowerCase();

                if (query.isEmpty()){
                    Toast.makeText(SearchActivity.this, "Enter something",Toast.LENGTH_SHORT).show();
                }else {
                    getPexelsSearchImage(query);

                }


            }
        });


        //--Spinner Implement-------------------------/
        binding.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();

                if (item.contains("None")){
                    String query = "popular";
                    getPexelsSearchImage(query);

                } else if (item.contains("Red")) {
                    String query = "red";
                    getPexelsSearchImage(query);

                }else if (item.contains("Orange")) {
                    String query = "Orange";
                    getPexelsSearchImage(query);

                }else if (item.contains("Yellow")) {
                    String query = "Yellow";
                    getPexelsSearchImage(query);

                }else if (item.contains("Green")) {
                    String query = "Green";
                    getPexelsSearchImage(query);

                }else if (item.contains("Turquoise")) {
                    String query = "Turquoise";
                    getPexelsSearchImage(query);

                }else if (item.contains("Blue")) {
                    String query = "Blue";
                    getPexelsSearchImage(query);

                }else if (item.contains("Violet")) {
                    String query = "Violet";
                    getPexelsSearchImage(query);

                }else if (item.contains("Pink")) {
                    String query = "Pink";
                    getPexelsSearchImage(query);

                }else if (item.contains("Brown")) {
                    String query = "Brown";
                    getPexelsSearchImage(query);

                }else if (item.contains("Black")) {
                    String query = "Black";
                    getPexelsSearchImage(query);

                }else if (item.contains("Gray")) {
                    String query = "Gray";
                    getPexelsSearchImage(query);

                }else if (item.contains("White")) {
                    String query = "White";
                    getPexelsSearchImage(query);

                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerList.add("None");
        spinnerList.add("Red");
        spinnerList.add("Orange");
        spinnerList.add("Yellow");
        spinnerList.add("Green");
        spinnerList.add("Turquoise");
        spinnerList.add("Blue");
        spinnerList.add("Violet");
        spinnerList.add("Pink");
        spinnerList.add("Brown");
        spinnerList.add("Black");
        spinnerList.add("Gray");
        spinnerList.add("White");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, spinnerList);
        adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        binding.spinner.setAdapter(adapter);

        //--Spinner Implement-------------------------//




    }

    private void getPexelsSearchImage(String query) {
        searchList.clear();
        ApiClient.getApiInterface().getSearchImage(query, 1, 80).enqueue(new Callback<PexelsSearchModel>() {
            @Override
            public void onResponse(Call<PexelsSearchModel> call, Response<PexelsSearchModel> response) {


                binding.progressBar.setVisibility(View.GONE);
                if (response.isSuccessful()) {

                    PexelsSearchModel mySearchResponse = response.body();
                    if (mySearchResponse != null) {
                        searchList = (ArrayList<PexelsImageModel>) mySearchResponse.getPhotos();
                        if (searchList != null && searchList.size() > 0) {
                            ImageAdapter adapter = new ImageAdapter(SearchActivity.this, searchList,
                                    SearchActivity.this, 0);
                            binding.searchRV.setAdapter(adapter);
                        }
                    }

                } else {
                    Toast.makeText(SearchActivity.this, "Not able to get", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onFailure(Call<PexelsSearchModel> call, Throwable t) {

            }
        });


    }

    @Override
    public void itemClick(PexelsImageModel pexelsImageModel, int position,String image) {
        Intent intent = new Intent(SearchActivity.this, SetWallpaper.class);
        intent.putExtra("position", position);
        intent.putExtra("image",image);
        startActivity(intent);
    }


}