package com.example.annahockeyleague;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.annahockeyleague.Entity.Team;
import com.example.annahockeyleague.Fragments.FixturesFragment.FixturesPage;
import com.example.annahockeyleague.Fragments.HomeFragment.HomePage;
import com.example.annahockeyleague.Fragments.PlayerFragment.PlayerFragment;
import com.example.annahockeyleague.Fragments.TeamFragment.TeamPage;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, TestInterface {

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
                .add(R.id.main_activity_container, new HomePage(),"home")
                .addToBackStack("home")
                .commit();

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        Log.d(TAG, "on navigation item selected");

        switch (menuItem.getItemId()){

            case R.id.bottom_nav_home:
                Log.d(TAG,"nav_home selected");

                if(getSupportFragmentManager().findFragmentByTag("home") != null)
                {
                    Fragment homePage = getSupportFragmentManager().findFragmentByTag("home");
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_activity_container, homePage).commit();
                }
                else {
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_activity_container, new HomePage(), "home").commit();
                }
                return true;

            case
                    R.id.bottom_nav_team:
                Log.d(TAG,"nav_team selected");

            if(getSupportFragmentManager().findFragmentByTag("team") != null) {
                Fragment teamPage = getSupportFragmentManager().findFragmentByTag("team");
                getSupportFragmentManager().beginTransaction().replace(R.id.main_activity_container, teamPage).commit();
            }
            else
            {
                getSupportFragmentManager().beginTransaction().replace(R.id.main_activity_container,new TeamPage(), "team")
                        .addToBackStack("team").commit();
            }
                return true;

            case R.id.bottom_nav_fixtures:
                Log.d(TAG,"nav_fixtures selected");
                if(getSupportFragmentManager().findFragmentByTag("fixtures") != null)
                {
                    Fragment fixturePage = getSupportFragmentManager().findFragmentByTag("fixtures");
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_activity_container, fixturePage).commit();
                }
                else {
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_activity_container, new FixturesPage(), "fixtures")
                            .addToBackStack("fixtures").commit();
                }
                return true;

            default:
                Log.d(TAG,"default selected");
                return true;

        }
    }


    @Override
    public void showPlayerFragment(Team team) {

        Log.d(TAG,"show player fragment");

        Bundle bundle = new Bundle();
        Fragment playerFragment = new PlayerFragment();
        bundle.putParcelable("teamObj",team);
        playerFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_activity_container, playerFragment)
                .addToBackStack("player")
                .commit();

    }

    @Override
    protected void onStart() {
        Log.d(TAG,"on start activity");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d(TAG,"on resume activity");
        super.onResume();
    }

    @Override
    protected void onRestart() {
        Log.d(TAG,"on restart activity");
        super.onRestart();
    }

    @Override
    protected void onPause() {
        Log.d(TAG,"on pause activity");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG,"on stop activity");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG,"on destroy activity");
        super.onDestroy();
    }

//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//
//        int count = getSupportFragmentManager().getBackStackEntryCount();
//
//        if(count == 0)
//        {
//            Toast.makeText(this, "about to end", Toast.LENGTH_SHORT).show();
//        }
//        else
//        {
//            FragmentManager.BackStackEntry entry = getSupportFragmentManager().getBackStackEntryAt(count);
//            switch(Objects.requireNonNull(entry.getName()))
//            {
//                case "home":
//                    Toast.makeText(this, "home", Toast.LENGTH_SHORT).show();
//                    break;
//
//                case "team":
//                    Toast.makeText(this, "team", Toast.LENGTH_SHORT).show();
//                    break;
//
//                case "fixtures":
//                    Toast.makeText(this, "fixtures", Toast.LENGTH_SHORT).show();
//                    break;
//
//                case "player":
//                    Toast.makeText(this, "player", Toast.LENGTH_SHORT).show();
//                    break;
//            }
//        }
//
//    }
}
