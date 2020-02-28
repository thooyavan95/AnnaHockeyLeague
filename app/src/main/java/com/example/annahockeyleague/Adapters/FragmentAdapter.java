package com.example.annahockeyleague.Adapters;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.annahockeyleague.AhlConfig.AhlConstants;
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

                fragment = new HomePageFragment();

                if (position == 0) {
                    Log.d(TAG, "getItemCalled position 0");
                    fragment.setArguments(setBundleArguments(position));
                } else {
                    Log.d(TAG, "getItemCalled position 1");
                    fragment.setArguments(setBundleArguments(position));
                }


//                if (position == 0) {
//                Log.d(TAG, "getItemCalled position 0");
//                if(fragmentManager.findFragmentByTag("android:switcher:" + R.id.viewpager + ":" + getItemId(position)) == null) {
//                    fragment = new HomePageFragment(FragmentConfig.MEN);
//                }
//                else
//                {
//                    fragment = fragmentManager.findFragmentByTag("android:switcher:" + R.id.viewpager + ":" + getItemId(position));
//                }
//
//            } else {
//                Log.d(TAG, "getItemCalled position 1");
//                    if(fragmentManager.findFragmentByTag("android:switcher:" + R.id.viewpager + ":" + getItemId(position)) == null) {
//                        fragment = new HomePageFragment(FragmentConfig.WOMEN);
//                    }
//                    else
//                    {
//                        fragment = fragmentManager.findFragmentByTag("android:switcher:" + R.id.viewpager + ":" + getItemId(position));
//                    }
//            }

            break;

            case TEAM:

                fragment = new TeamFragment();

                if (position == 0) {
                    Log.d(TAG, "getItemCalled position 0");
                    fragment.setArguments(setBundleArguments(position));
                } else {
                    Log.d(TAG, "getItemCalled position 1");
                    fragment.setArguments(setBundleArguments(position));
                }
                break;

            case FIXTURES:

                fragment = new FixturesFragment();

                if (position == 0) {
                    Log.d(TAG, "getItemCalled position 0");
                    fragment.setArguments(setBundleArguments(position));
                } else {
                    Log.d(TAG, "getItemCalled position 1");
                    fragment.setArguments(setBundleArguments(position));
                }
        }
        return fragment;
    }

    @Override
    public int getCount() {
        Log.d(TAG,"getCount called");
        return 2;
    }

    private Bundle setBundleArguments(int position)
    {
        Log.d(TAG, "set bundle arguments");
        Bundle bundle = new Bundle();

        if(position == 0) {
            bundle.putString("config", AhlConstants.men);
            return bundle;
        }
        else
        {
            bundle.putString("config", AhlConstants.women);
            return bundle;
        }
    }

}
