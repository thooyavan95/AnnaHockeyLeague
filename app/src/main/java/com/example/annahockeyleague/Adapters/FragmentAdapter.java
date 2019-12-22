package com.example.annahockeyleague.Adapters;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.annahockeyleague.AhlConfig.FragmentConfig;
import com.example.annahockeyleague.Fragments.HomePageFragment;


public class FragmentAdapter extends FragmentPagerAdapter {

    private final String[] title = {"Men","Women"};
    private static final String TAG = "Behaviour";

    public FragmentAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        Log.d(TAG,"getPageTitleCalled");
        return title[position];
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Log.d(TAG,"getItemCalled");
        if(position == 0)
        {
            Log.d(TAG,"getItemCalled position 0");
            return new HomePageFragment(FragmentConfig.MEN);
        }
        else
        {
            Log.d(TAG,"getItemCalled position 1");
            return new HomePageFragment(FragmentConfig.WOMEN);
        }
    }

    @Override
    public int getCount() {
        Log.d(TAG,"getCount called");
        return 2;
    }
}
