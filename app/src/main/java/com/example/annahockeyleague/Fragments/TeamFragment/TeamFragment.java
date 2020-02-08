package com.example.annahockeyleague.Fragments.TeamFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.annahockeyleague.Adapters.FragmentAdapter;
import com.example.annahockeyleague.AhlConfig.FragmentConfig;
import com.example.annahockeyleague.AhlConfig.FragmentType;
import com.example.annahockeyleague.R;
import com.google.android.material.tabs.TabLayout;

public class TeamFragment extends Fragment {

    private FragmentConfig config;

    public TeamFragment()
    {

    }

    public TeamFragment(FragmentConfig config)
    {
        this.config = config;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.team_fragment_layout,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

    }
}
