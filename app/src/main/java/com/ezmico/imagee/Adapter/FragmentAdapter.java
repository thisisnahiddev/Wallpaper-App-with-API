package com.ezmico.imagee.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.ezmico.imagee.Fragments.TrendingFragment;
import com.ezmico.imagee.Fragments.RecentFragment;
import com.ezmico.imagee.Fragments.CategoryFragment;

public class FragmentAdapter extends FragmentStateAdapter {




    public FragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position){
            case 0: return new CategoryFragment();
            case 1: return new TrendingFragment();
            case 2: return new RecentFragment();
            default: return new TrendingFragment();
        }


    }

    @Override
    public int getItemCount() {
        return 3;
    }





}
