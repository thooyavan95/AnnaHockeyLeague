package com.example.annahockeyleague.Adapters;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.annahockeyleague.AdapterInterface;
import com.example.annahockeyleague.AhlConfig.FragmentType;
import com.example.annahockeyleague.Fragments.FixturesFragment.FixturesFragment;
import com.example.annahockeyleague.Fragments.HomeFragment.HomePageFragment;
import com.example.annahockeyleague.Fragments.TeamFragment.TeamFragment;


public class FragmentAdapter extends FragmentPagerAdapter {

    private final String[] title = {"Men","Women"};
    private static final String TAG = "Behaviour";

    private FragmentType type;
    private AdapterInterface adapterInterface;


    public FragmentAdapter(@NonNull FragmentManager fm, FragmentType type, AdapterInterface adapterInterface) {
        super(fm);
        this.type = type;
        this.adapterInterface = adapterInterface;
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
                    adapterInterface.getItemPosition(position,getItemId(position),  fragment = new HomePageFragment());
                } else {
                    Log.d(TAG, "getItemCalled position 1");
                    adapterInterface.getItemPosition(position,getItemId(position),  fragment = new HomePageFragment());
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

                if (position == 0) {
                    Log.d(TAG, "getItemCalled position 0");
                    adapterInterface.getItemPosition(position,getItemId(position),  fragment = new TeamFragment());
                } else {
                    Log.d(TAG, "getItemCalled position 1");
                    adapterInterface.getItemPosition(position,getItemId(position),  fragment = new TeamFragment());
                }
                break;

            case FIXTURES:

                if (position == 0) {
                    Log.d(TAG, "getItemCalled position 0");
                    adapterInterface.getItemPosition(position,getItemId(position),  fragment = new FixturesFragment());
                } else {
                    Log.d(TAG, "getItemCalled position 1");
                    adapterInterface.getItemPosition(position,getItemId(position),  fragment = new FixturesFragment());
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
