package com.ezmico.imagee.Activity;



import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;


import com.ezmico.imagee.Adapter.FragmentAdapter;


import android.content.Intent;
import android.os.Bundle;



import android.widget.Toast;

import com.ezmico.imagee.R;

import com.google.android.material.tabs.TabLayoutMediator;
import com.ezmico.imagee.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), getLifecycle());
        binding.viewPager.setAdapter(fragmentAdapter);
        int DEFAULT_POSITION = 1;

        new TabLayoutMediator(binding.TabLay, binding.viewPager, (tab, position) -> {


            binding.viewPager.setCurrentItem(DEFAULT_POSITION);
            if (position == 0) {
                tab.setText("Category");

            } else if (position == 1) {
                tab.setText("Trending");


            } else if (position == 2) {
                tab.setText("Recent");
            }


        }).attach();


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                MainActivity.this, binding.drawerLayout, binding.materialToolbar, R.string.drawer_close, R.string.drawer_open
        );
        binding.drawerLayout.addDrawerListener(toggle);
        binding.navigationView.setNavigationItemSelectedListener(item -> {

            if (item.getItemId()== R.id.home){
                startActivity(new Intent(MainActivity.this,MainActivity.class));

            } else if (item.getItemId()== R.id.favourites) {
                Toast.makeText(MainActivity.this,"Favorites",Toast.LENGTH_SHORT).show();

            }else if (item.getItemId()== R.id.rateus) {

                Toast.makeText(MainActivity.this,"Rate Us",Toast.LENGTH_SHORT).show();
            }else if (item.getItemId()== R.id.share) {
                Toast.makeText(MainActivity.this,"Share",Toast.LENGTH_SHORT).show();

            } else if (item.getItemId()== R.id.privacy) {

                Toast.makeText(MainActivity.this,"Privacy & Policy",Toast.LENGTH_SHORT).show();
            }


            return false;
        });


        binding.materialToolbar.setOnMenuItemClickListener(item -> {

            if (item.getItemId() == R.id.search) {
                startActivity(new Intent(getApplicationContext(), SearchActivity.class));


            }


            return true;
        });


    }


}