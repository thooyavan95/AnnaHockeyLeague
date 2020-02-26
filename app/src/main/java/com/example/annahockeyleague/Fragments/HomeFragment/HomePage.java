package com.example.annahockeyleague.Fragments.HomeFragment;

import android.content.Context;
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
import com.example.annahockeyleague.Adapters.FragmentAdapter;
import com.example.annahockeyleague.AhlConfig.FragmentType;
import com.example.annahockeyleague.R;
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

        tabs = getView().findViewById(R.id.tabLayout);
        viewPager = getView().findViewById(R.id.viewpager);

        if(adapter == null) {
            adapter = new FragmentAdapter(getChildFragmentManager(), FragmentType.HOME);
        }


        viewPager.setAdapter(adapter);
        tabs.setupWithViewPager(viewPager);

    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "on save instance state");
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "on create");
        setRetainInstance(true);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "on activity created");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "on start fragment");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "on resume fragment");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "on pause fragment");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "on stop fragment");
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(TAG, "on attach fragment");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "on destroy view fragment");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "on destroy fragment");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "on detach fragment");
    }


}
