package com.example.annahockeyleague;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.annahockeyleague.Adapters.FragmentAdapter;
import com.example.annahockeyleague.Fragments.HomePage;
import com.example.annahockeyleague.Fragments.HomePageFragment;
import com.example.annahockeyleague.Fragments.TeamFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

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

                getSupportFragmentManager().beginTransaction().replace(R.id.main_activity_container, new HomePageFragment()).commit();
                return true;
            case R.id.bottom_nav_team:

                getSupportFragmentManager().beginTransaction().replace(R.id.main_activity_container, new TeamFragment()).commit();
                return true;

            default:
                return true;

        }
    }
}
