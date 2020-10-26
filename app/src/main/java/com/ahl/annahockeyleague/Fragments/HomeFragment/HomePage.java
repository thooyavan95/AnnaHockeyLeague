package com.ahl.annahockeyleague.Fragments.HomeFragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.ahl.annahockeyleague.Adapters.FragmentAdapter;
import com.ahl.annahockeyleague.AhlConfig.FragmentType;
import com.ahl.annahockeyleague.R;
import com.google.android.material.tabs.TabLayout;

public class HomePage extends Fragment {

    private static final String TAG = HomePage.class.getSimpleName();
    private FragmentPagerAdapter adapter;

    public HomePage()
    {
        Log.d(TAG, "home page constructor");
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "on create view");
        return inflater.inflate(R.layout.home_page,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        Log.d(TAG, "on view created");

        TabLayout tabs;
        ViewPager viewPager;

        if(getView() != null) {
            tabs = getView().findViewById(R.id.tabLayout);
            viewPager = getView().findViewById(R.id.viewpager);

            if (adapter == null) {
                adapter = new FragmentAdapter(getChildFragmentManager(), FragmentType.HOME);
            }

            viewPager.setAdapter(adapter);
            tabs.setupWithViewPager(viewPager);
        }

    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "on create");
        setRetainInstance(true);
    }

}
