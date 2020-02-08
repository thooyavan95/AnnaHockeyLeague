package com.example.annahockeyleague;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.annahockeyleague.Fragments.FixturesFragment.FixturesFragment;
import com.example.annahockeyleague.Fragments.FixturesFragment.FixturesPage;
import com.example.annahockeyleague.Fragments.HomeFragment.HomePage;
import com.example.annahockeyleague.Fragments.HomeFragment.HomePageFragment;
import com.example.annahockeyleague.Fragments.TeamFragment.TeamFragment;
import com.example.annahockeyleague.Fragments.TeamFragment.TeamPage;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

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

        BottomNavigationView bottomNav = findViewById(R.id.home_bottom_nav);
        bottomNav.setOnNavigationItemSelectedListener(this);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.main_activity_container, new HomePage())
                .commit();

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()){

            case R.id.bottom_nav_home:

                getSupportFragmentManager().beginTransaction().replace(R.id.main_activity_container, new HomePage()).commit();
                return true;
            case R.id.bottom_nav_team:

                getSupportFragmentManager().beginTransaction().replace(R.id.main_activity_container, new TeamPage()).commit();
                return true;

            case R.id.bottom_nav_fixtures:

                getSupportFragmentManager().beginTransaction().replace(R.id.main_activity_container, new FixturesPage()).commit();
                return true;

            default:
                return true;

        }
    }
}
