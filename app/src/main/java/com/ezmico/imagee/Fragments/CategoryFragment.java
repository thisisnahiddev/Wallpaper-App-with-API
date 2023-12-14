package com.ezmico.imagee.Fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ezmico.imagee.R;
import com.ezmico.imagee.databinding.FragmentCategoryBinding;
import com.ezmico.imagee.Activity.TagShowActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;



public class CategoryFragment extends Fragment {


    public CategoryFragment() {
        // Required empty public constructor
    }

    FragmentCategoryBinding binding;
    ArrayList<HashMap<String, String>> categoryList = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentCategoryBinding.inflate(inflater, container, false);


        CategoryItemList();

        CategoryAdapter categoryAdapter = new CategoryAdapter();
        binding.categoryRV.setLayoutManager(new GridLayoutManager(getContext(),2));
        binding.categoryRV.setAdapter(categoryAdapter);


        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    private void CategoryItemList() {

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("categoryCover", "https://images.pexels.com/photos/1629236/pexels-photo-1629236.jpeg?auto=compress&cs=tinysrgb&w=512&h=512&dpr=1");
        hashMap.put("categoryName", "Abstract");
        hashMap.put("catQuery","abstract");
        categoryList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("categoryCover", "https://images.pexels.com/photos/15286/pexels-photo.jpg");
        hashMap.put("categoryName", "Nature");
        hashMap.put("catQuery","nature");
        categoryList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("categoryCover", "https://images.pexels.com/photos/1097456/pexels-photo-1097456.jpeg?auto=compress&cs=tinysrgb&w=600");
        hashMap.put("categoryName", "Dark");
        hashMap.put("catQuery","dark");
        categoryList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("categoryCover", "https://images.pexels.com/photos/326055/pexels-photo-326055.jpeg?auto=compress&cs=tinysrgb&w=600");
        hashMap.put("categoryName", "Beautiful");
        hashMap.put("catQuery","beautiful");
        categoryList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("categoryCover", "https://images.pexels.com/photos/87452/flowers-background-butterflies-beautiful-87452.jpeg?auto=compress&cs=tinysrgb&w=600");
        hashMap.put("categoryName", "Flowers");
        hashMap.put("catQuery","flowers");
        categoryList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("categoryCover", "https://images.pexels.com/photos/2531709/pexels-photo-2531709.jpeg?auto=compress&cs=tinysrgb&w=600");
        hashMap.put("categoryName", "Sky");
        hashMap.put("catQuery","sky");
        categoryList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("categoryCover", "https://images.pexels.com/photos/1767434/pexels-photo-1767434.jpeg?auto=compress&cs=tinysrgb&w=600");
        hashMap.put("categoryName", "Love");
        hashMap.put("catQuery","love");
        categoryList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("categoryCover", "https://images.pexels.com/photos/295826/pexels-photo-295826.jpeg?auto=compress&cs=tinysrgb&w=600");
        hashMap.put("categoryName", "Business");
        hashMap.put("catQuery","business");
        categoryList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("categoryCover", "https://images.pexels.com/photos/120049/pexels-photo-120049.jpeg?auto=compress&cs=tinysrgb&w=600");
        hashMap.put("categoryName", "Cars");
        hashMap.put("catQuery","cars");
        categoryList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("categoryCover", "https://images.pexels.com/photos/792381/pexels-photo-792381.jpeg?auto=compress&cs=tinysrgb&w=600");
        hashMap.put("categoryName", "Anime");
        hashMap.put("catQuery","anime");
        categoryList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("categoryCover", "https://images.pexels.com/photos/3861969/pexels-photo-3861969.jpeg?auto=compress&cs=tinysrgb&w=600");
        hashMap.put("categoryName", "Technology");
        hashMap.put("catQuery","technology");
        categoryList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("categoryCover", "https://images.pexels.com/photos/235621/pexels-photo-235621.jpeg?auto=compress&cs=tinysrgb&w=600");
        hashMap.put("categoryName", "Winter");
        hashMap.put("catQuery","winter");
        categoryList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("categoryCover", "https://images.pexels.com/photos/36717/amazing-animal-beautiful-beautifull.jpg?auto=compress&cs=tinysrgb&w=600");
        hashMap.put("categoryName", "Sunset");
        hashMap.put("catQuery","sunset");
        categoryList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("categoryCover", "https://images.pexels.com/photos/1099680/pexels-photo-1099680.jpeg?auto=compress&cs=tinysrgb&w=600");
        hashMap.put("categoryName", "Food");
        hashMap.put("catQuery","food");
        categoryList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("categoryCover", "https://images.pexels.com/photos/5135113/pexels-photo-5135113.jpeg?auto=compress&cs=tinysrgb&w=600");
        hashMap.put("categoryName", "Black and White");
        hashMap.put("catQuery","black and white");
        categoryList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("categoryCover", "https://images.pexels.com/photos/5638603/pexels-photo-5638603.jpeg?auto=compress&cs=tinysrgb&w=600");
        hashMap.put("categoryName", "Thanksgiving");
        hashMap.put("catQuery","thanksgiving");
        categoryList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("categoryCover", "https://images.pexels.com/photos/1671325/pexels-photo-1671325.jpeg?auto=compress&cs=tinysrgb&w=600");
        hashMap.put("categoryName", "Forest");
        hashMap.put("catQuery","forest");
        categoryList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("categoryCover", "https://images.pexels.com/photos/457878/pexels-photo-457878.jpeg?auto=compress&cs=tinysrgb&w=600");
        hashMap.put("categoryName", "Beach");
        hashMap.put("catQuery","beach");
        categoryList.add(hashMap);


    }

    public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {


        public class ViewHolder extends RecyclerView.ViewHolder {

            ImageView catCover;
            TextView catName;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                catCover = itemView.findViewById(R.id.catCover);
                catName = itemView.findViewById(R.id.catName);


            }
        }


        @NonNull
        @Override
        public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.category_item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull CategoryAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {

            HashMap<String, String> hashMap = categoryList.get(position);
            String cover = hashMap.get("categoryCover");
            String name = hashMap.get("categoryName");
            String catQuery = hashMap.get("catQuery");



            Picasso.get().load(cover).into(holder.catCover);
            holder.catName.setText(name);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    HashMap<String,String> hashMap1 = categoryList.get(position);
                    String catName = hashMap1.get("categoryName");

                    Intent intent = new Intent(getContext(),TagShowActivity.class);
                    intent.putExtra("categoryName",catName);
                    intent.putExtra("catQuery",catQuery);
                    startActivity(intent);


                }
            });



        }

        @Override
        public int getItemCount() {
            return categoryList.size();
        }


    }


}