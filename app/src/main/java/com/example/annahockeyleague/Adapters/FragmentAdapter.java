package com.example.annahockeyleague.Adapters;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.annahockeyleague.AhlConfig.FragmentConfig;
import com.example.annahockeyleague.AhlConfig.FragmentType;
import com.example.annahockeyleague.Fragments.FixturesFragment.FixturesFragment;
import com.example.annahockeyleague.Fragments.HomeFragment.HomePageFragment;
import com.example.annahockeyleague.Fragments.TeamFragment.TeamFragment;


public class FragmentAdapter extends FragmentPagerAdapter {

    private final String[] title = {"Men","Women"};
    private static final String TAG = "Behaviour";

    private FragmentType type;

    public FragmentAdapter(@NonNull FragmentManager fm, FragmentType type) {
        super(fm);
        this.type = type;
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
        Log.d(TAG, "getItemCalled");

        Fragment fragment = null;
        switch (type) {

            case HOME:

            if (position == 0) {
                Log.d(TAG, "getItemCalled position 0");
                fragment = new HomePageFragment(FragmentConfig.MEN);
            } else {
                Log.d(TAG, "getItemCalled position 1");
                fragment = new HomePageFragment(FragmentConfig.WOMEN);
            }

            break;

            case TEAM:

                if (position == 0) {
                    Log.d(TAG, "getItemCalled position 0");
                    fragment = new TeamFragment(FragmentConfig.MEN);
                } else {
                    Log.d(TAG, "getItemCalled position 1");
                    fragment = new TeamFragment(FragmentConfig.WOMEN);
                }

                break;

            case FIXTURES:

                if (position == 0) {
                    Log.d(TAG, "getItemCalled position 0");
                    fragment = new FixturesFragment(FragmentConfig.MEN);
                } else {
                    Log.d(TAG, "getItemCalled position 1");
                    fragment = new FixturesFragment(FragmentConfig.WOMEN);
                }
        }

        return fragment;
    }

    @Override
    public int getCount() {
        Log.d(TAG,"getCount called");
        return 2;
    }
}
