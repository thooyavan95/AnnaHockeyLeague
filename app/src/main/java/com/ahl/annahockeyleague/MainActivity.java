package com.ahl.annahockeyleague;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


import com.ahl.annahockeyleague.Entity.Team;
import com.ahl.annahockeyleague.Fragments.PlayerFragment.PlayerFragment;
import com.google.android.gms.oss.licenses.OssLicensesMenuActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements TestInterface {

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
        NavHostFragment navHostFragment = (NavHostFragment)getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);

        NavigationUI.setupWithNavController(bottomNav, navHostFragment.getNavController());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.privacy:
                Intent intent = new Intent(this, OptionsActivity.class);
                intent.putExtra("privacy","privacy");
                startActivity(intent);
                break;

            case R.id.licence:
                startActivity(new Intent(this, OssLicensesMenuActivity.class));
                break;
        }

        return true;
    }


    @Override
    public void showPlayerFragment(Team team) {

        Log.d(TAG,"show player fragment");

        Bundle bundle = new Bundle();
        Fragment playerFragment = new PlayerFragment();
        bundle.putParcelable("teamObj",team);
        playerFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.nav_host_fragment, playerFragment)
                .addToBackStack("player")
                .commit();

    }


}
