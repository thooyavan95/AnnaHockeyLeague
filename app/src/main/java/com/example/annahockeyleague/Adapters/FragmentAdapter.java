package com.example.annahockeyleague.Adapters;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.annahockeyleague.AhlConfig.FragmentConfig;
import com.example.annahockeyleague.AhlConfig.FragmentType;
import com.example.annahockeyleague.Fragments.FixturesFragment.FixturesFragment;
import com.example.annahockeyleague.Fragments.HomeFragment.HomePageFragment;
import com.example.annahockeyleague.Fragments.TeamFragment.TeamFragment;
import com.example.annahockeyleague.R;
import com.example.annahockeyleague.TestInterface;


public class FragmentAdapter extends FragmentPagerAdapter {

    private final String[] title = {"Men","Women"};
    private static final String TAG = "Behaviour";

    private FragmentType type;
    private TestInterface testInterface;
    private FragmentManager fragmentManager;

    public FragmentAdapter(@NonNull FragmentManager fm, FragmentType type) {
        super(fm);
        this.fragmentManager = fm;
        this.type = type;
    }

    public FragmentAdapter(@NonNull FragmentManager fm, FragmentType type, TestInterface testInterface) {
        super(fm);
        this.type = type;
        this.testInterface = testInterface;
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
                    fragment = new TeamFragment(FragmentConfig.MEN, testInterface);
                } else {
                    Log.d(TAG, "getItemCalled position 1");
                    fragment = new TeamFragment(FragmentConfig.WOMEN, testInterface);
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
