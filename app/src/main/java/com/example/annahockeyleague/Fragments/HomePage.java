package com.example.annahockeyleague.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.annahockeyleague.Adapters.FragmentAdapter;
import com.example.annahockeyleague.R;
import com.google.android.material.tabs.TabLayout;

public class HomePage extends Fragment {

    public HomePage()
    {

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_page,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        TabLayout tabs;
        ViewPager viewPager;

        tabs = getView().findViewById(R.id.home_tabLayout);
        viewPager = getView().findViewById(R.id.home_viewpager);

        FragmentAdapter adapter = new FragmentAdapter(getFragmentManager());

        viewPager.setAdapter(adapter);
        tabs.setupWithViewPager(viewPager);

    }

}
