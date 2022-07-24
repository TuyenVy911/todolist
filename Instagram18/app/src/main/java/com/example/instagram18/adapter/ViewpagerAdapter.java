package com.example.instagram18.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;


import com.example.instagram18.fragment.HomeFragment;
import com.example.instagram18.fragment.FavoritePhotoFragment;
import com.example.instagram18.fragment.ProfileFragment;
import com.example.instagram18.fragment.SearchFragment;

public class ViewpagerAdapter extends FragmentStatePagerAdapter {


    public ViewpagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new HomeFragment();
            case 1: return new SearchFragment();
            case 2: return new FavoritePhotoFragment();
            case 3: return new ProfileFragment();
            default: return new HomeFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }


}
