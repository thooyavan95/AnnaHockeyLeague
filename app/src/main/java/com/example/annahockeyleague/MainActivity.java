package com.example.annahockeyleague;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;

import com.example.annahockeyleague.Adapters.FragmentAdapter;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    public FragmentAdapter adapter;
    private static final String TAG = "Main Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG,"On create");
        initViews();

    }

    public void initViews()
    {
        Log.d(TAG,"method initviews");
        TabLayout tabs;
        ViewPager viewPager;

        tabs = findViewById(R.id.home_tabLayout);
        viewPager = findViewById(R.id.home_viewpager);
        viewPager.setOffscreenPageLimit(10);

        adapter = new FragmentAdapter(getSupportFragmentManager());

        viewPager.setAdapter(adapter);
        tabs.setupWithViewPager(viewPager);
    }
}
