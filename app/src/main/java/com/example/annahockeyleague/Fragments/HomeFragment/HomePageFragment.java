package com.example.annahockeyleague.Fragments.HomeFragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.annahockeyleague.Adapters.PointsTableAdapter;
import com.example.annahockeyleague.Adapters.TopScorersAdapter;
import com.example.annahockeyleague.AhlConfig.AhlConstants;
import com.example.annahockeyleague.AhlConfig.LogoSetter;
import com.example.annahockeyleague.Entity.PointsTable;
import com.example.annahockeyleague.Entity.TopScorers;
import com.example.annahockeyleague.Entity.Fixtures;
import com.example.annahockeyleague.R;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;

import static com.example.annahockeyleague.AhlConfig.LogoSetter.setTeamLogo;

public class HomePageFragment extends Fragment implements HomeViewInterface {

    private String config;
    private static final String TAG = "HomePageFragment";
    private Fixtures nextFixtureData;
    private Fixtures previousFixtureData;
    private ArrayList<PointsTable> pointsTableData;
    private ArrayList<TopScorers> topScorersData;

    public HomePageFragment() {
        Log.d(TAG,"empty constructor called");
        // Required empty public constructor
    }

//    public HomePageFragment(FragmentConfig config) {
//        Log.d(TAG,"Homefragment config constructor");
//        this.config = config;
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        Log.d(TAG,"onCreateView");
        return inflater.inflate(R.layout.fragment_home_page, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        Log.d(TAG,"onViewCreated");

        if(nextFixtureData != null && previousFixtureData != null && pointsTableData != null && topScorersData != null)
        {
            setNextMatchData(nextFixtureData);
            setPreviousMatchData(previousFixtureData);
            setPointsTableData(pointsTableData);
            setTopScorersData(topScorersData);
        }

    }


    private void getHomePageDataFromServer(HomePresenter presenter) {
        Log.d(TAG,"method get home page data from server");

        presenter.fetchData(config);
    }


    @Override
    public void setNextMatchFixture(final Fixtures data) {

        Log.d(TAG,"method set next match Fixtues data");
        if(getActivity() != null) {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    Log.d(TAG,"run on ui thread inside set fixtures data men");

                    Log.d(TAG, "updating ui with next match details");
                    Log.d(TAG, data.toString());

                    nextFixtureData = data;

                    setNextMatchData(data);
                }
            });

        }
        }

    @Override
    public void setPrevoiusMatchFixture(final Fixtures data) {

        if(getActivity() != null) {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    Log.d(TAG,"run on ui thread inside set previous match fixtures data");


                    Log.d(TAG, "updating ui with previous match fixture data");
                    Log.d(TAG, data.toString());

                    previousFixtureData = data;

                    setPreviousMatchData(data);

                }
            });

        }


    }

    @Override
    public void setPointsTable(final ArrayList<PointsTable> pointsData) {

        Log.d(TAG,"method set points table");

        if(getActivity() != null) {

            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    pointsTableData = pointsData;

                    setPointsTableData(pointsData);

                }
            });

        }

    }

    @Override
    public void setTopScorers(final ArrayList<TopScorers> topScorers) {
        Log.d(TAG,"method set top scorers data");

        if(getActivity() != null) {

            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    topScorersData = topScorers;

                    setTopScorersData(topScorers);

                }
            });
        }

    }


    @Override
    public void setFailureToast(final Exception e) {

        Log.d(TAG,"method setfailure toast");

        if(getActivity() != null) {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    Log.d(TAG, "run on ui thread inside set failure toast");
                    Toast.makeText(getContext(), String.valueOf(e), Toast.LENGTH_SHORT).show();
                    Log.d("error msg", String.valueOf(e));
                }
            });
        }

    }

    @Override
    public void setFixtures(ArrayList<Fixtures> fixdata) {

    }


    private void setNextMatchData(Fixtures matchData)
    {
        if(getView() != null) {
            if (config.equals(AhlConstants.men)) {

                Log.d(TAG, "updating ui with next match details men");

                ((TextView) getView().findViewById(R.id.next_match_fixture_date)).setText(milliSecToDate(matchData));
                ((TextView) getView().findViewById(R.id.next_match_fixture_time)).setText(milliSecToTime(matchData));
                ((TextView) getView().findViewById(R.id.next_match_team1_name)).setText(matchData.getTeam1().getName());
                ((TextView) getView().findViewById(R.id.next_match_team2_name)).setText(matchData.getTeam2().getName());
                ((TextView) getView().findViewById(R.id.next_match_team1_score)).setText(getAllGoals(matchData.getTeam1Scorers()));
                ((TextView) getView().findViewById(R.id.next_match_team2_score)).setText(getAllGoals(matchData.getTeam2Scorers()));
                Picasso.get().load(setTeamLogo(matchData.getTeam1())).fit().into((ImageView) getView().findViewById(R.id.next_match_team1_image));
                Picasso.get().load(setTeamLogo(matchData.getTeam2())).fit().into((ImageView) getView().findViewById(R.id.next_match_team2_image));
            } else {

                Log.d(TAG, "updating ui with next match details women");

                ((TextView) getView().findViewById(R.id.next_match_fixture_date)).setText(milliSecToDate(matchData));
                ((TextView) getView().findViewById(R.id.next_match_fixture_time)).setText(milliSecToTime(matchData));
                ((TextView) getView().findViewById(R.id.next_match_team1_name)).setText(matchData.getTeam1().getName());
                ((TextView) getView().findViewById(R.id.next_match_team2_name)).setText(matchData.getTeam2().getName());
                ((TextView) getView().findViewById(R.id.next_match_team1_score)).setText(getAllGoals(matchData.getTeam1Scorers()));
                ((TextView) getView().findViewById(R.id.next_match_team2_score)).setText(getAllGoals(matchData.getTeam2Scorers()));
                Picasso.get().load(LogoSetter.setTeamLogo(matchData.getTeam1())).fit().into((ImageView) getView().findViewById(R.id.next_match_team1_image));
                Picasso.get().load(LogoSetter.setTeamLogo(matchData.getTeam2())).fit().into((ImageView) getView().findViewById(R.id.next_match_team2_image));
            }
        }
    }

    private void setPreviousMatchData(Fixtures matchData)
    {

        if(getView() != null) {
            if (config.equals(AhlConstants.men)) {

                Log.d(TAG, "updating ui with previous match details men");

                ((TextView) getView().findViewById(R.id.previous_match_fixture_date)).setText(milliSecToDate(matchData));
                ((TextView) getView().findViewById(R.id.previous_match_fixture_time)).setText(milliSecToTime(matchData));
                ((TextView) getView().findViewById(R.id.previous_match_team1_name)).setText(matchData.getTeam1().getName());
                ((TextView) getView().findViewById(R.id.previous_match_team2_name)).setText(matchData.getTeam2().getName());
                ((TextView) getView().findViewById(R.id.previous_match_team1_score)).setText(getAllGoals(matchData.getTeam1Scorers()));
                ((TextView) getView().findViewById(R.id.previous_match_team2_score)).setText(getAllGoals(matchData.getTeam2Scorers()));
                Picasso.get().load(setTeamLogo(matchData.getTeam1())).fit().into((ImageView) getView().findViewById(R.id.previous_match_team1_image));
                Picasso.get().load(setTeamLogo(matchData.getTeam2())).fit().into((ImageView) getView().findViewById(R.id.previous_match_team2_image));

                if (matchData.getBuddingPlayer() != null && matchData.getMom() != null) {
                    getView().findViewById(R.id.previous_match__man_of_the_match_image).setVisibility(View.VISIBLE);
                    getView().findViewById(R.id.previous_match__budding_player_image).setVisibility(View.VISIBLE);
                    getView().findViewById(R.id.previous_match_man_of_the_match_name).setVisibility(View.VISIBLE);
                    getView().findViewById(R.id.previous_match_budding_player_name).setVisibility(View.VISIBLE);
                    getView().findViewById(R.id.budding_player).setVisibility(View.VISIBLE);
                    getView().findViewById(R.id.man_of_the_match).setVisibility(View.VISIBLE);

                    Picasso.get().load(R.drawable.men_image).fit().into((ImageView) getView().findViewById(R.id.previous_match__budding_player_image));
                    Picasso.get().load(R.drawable.men_image).fit().into((ImageView) getView().findViewById(R.id.previous_match__man_of_the_match_image));
                    ((TextView) getView().findViewById(R.id.previous_match_budding_player_name)).setText(matchData.getBuddingPlayer().getName());
                    ((TextView) getView().findViewById(R.id.previous_match_man_of_the_match_name)).setText(matchData.getMom().getName());
                }


            } else {

                Log.d(TAG, "updating ui with previous match details women");

                ((TextView) getView().findViewById(R.id.previous_match_fixture_date)).setText(milliSecToDate(matchData));
                ((TextView) getView().findViewById(R.id.previous_match_fixture_time)).setText(milliSecToTime(matchData));
                ((TextView) getView().findViewById(R.id.previous_match_team1_name)).setText(matchData.getTeam1().getName());
                ((TextView) getView().findViewById(R.id.previous_match_team2_name)).setText(matchData.getTeam2().getName());
                ((TextView) getView().findViewById(R.id.previous_match_team1_score)).setText(getAllGoals(matchData.getTeam1Scorers()));
                ((TextView) getView().findViewById(R.id.previous_match_team2_score)).setText(getAllGoals(matchData.getTeam2Scorers()));
                Picasso.get().load(R.drawable.men_image).fit().into((ImageView) getView().findViewById(R.id.previous_match__budding_player_image));
                Picasso.get().load(R.drawable.men_image).fit().into((ImageView) getView().findViewById(R.id.previous_match__man_of_the_match_image));
                Picasso.get().load(setTeamLogo(matchData.getTeam1())).fit().into((ImageView) getView().findViewById(R.id.previous_match_team1_image));
                Picasso.get().load(setTeamLogo(matchData.getTeam2())).fit().into((ImageView) getView().findViewById(R.id.previous_match_team2_image));


                if (matchData.getBuddingPlayer() != null && matchData.getMom() != null) {
                    getView().findViewById(R.id.previous_match__man_of_the_match_image).setVisibility(View.VISIBLE);
                    getView().findViewById(R.id.previous_match__budding_player_image).setVisibility(View.VISIBLE);
                    getView().findViewById(R.id.previous_match_man_of_the_match_name).setVisibility(View.VISIBLE);
                    getView().findViewById(R.id.previous_match_budding_player_name).setVisibility(View.VISIBLE);
                    getView().findViewById(R.id.budding_player).setVisibility(View.VISIBLE);
                    getView().findViewById(R.id.man_of_the_match).setVisibility(View.VISIBLE);

                    Picasso.get().load(R.drawable.men_image).fit().into((ImageView) getView().findViewById(R.id.previous_match__budding_player_image));
                    Picasso.get().load(R.drawable.men_image).fit().into((ImageView) getView().findViewById(R.id.previous_match__man_of_the_match_image));
                    ((TextView) getView().findViewById(R.id.previous_match_budding_player_name)).setText(matchData.getBuddingPlayer().getName());
                    ((TextView) getView().findViewById(R.id.previous_match_man_of_the_match_name)).setText(matchData.getMom().getName());
                }

            }
        }
    }

    private void setPointsTableData(ArrayList<PointsTable> pointsTableData)
    {
        if(getContext() != null && getView() != null) {
            PointsTableAdapter adapter = new PointsTableAdapter(getContext(), pointsTableData);
            ((ListView) getView().findViewById(R.id.points_table_listview)).setAdapter(adapter);

            setListViewHeightBasedOnChildren((ListView) getView().findViewById(R.id.points_table_listview));
        }
    }


    private void setTopScorersData(ArrayList<TopScorers> topScorersData)
    {
        if(getContext() != null && getView() != null) {
            TopScorersAdapter scorersAdapter = new TopScorersAdapter(getContext(), topScorersData);
            ((ListView) getView().findViewById(R.id.top_scorers_listview)).setAdapter(scorersAdapter);
            setListViewHeightBasedOnChildren((ListView) getView().findViewById(R.id.top_scorers_listview));
        }
    }

    private void setListViewHeightBasedOnChildren(ListView listView) {

        Log.d(TAG,"set list view height based on children");

        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) return;
        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(),View.MeasureSpec.UNSPECIFIED);
        int totalHeight = 0;

        View view = null;
        for (int i = 0; i < listAdapter.getCount(); i++)
        {
            view = listAdapter.getView(i, view, listView);

            if (i == 0) view.setLayoutParams(new
                    ViewGroup.LayoutParams(desiredWidth,
                    ViewGroup.LayoutParams.WRAP_CONTENT));

            view.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += view.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();

        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));

        listView.setLayoutParams(params);
        listView.requestLayout();
    }

    private String getAllGoals(Map<String,Integer> allGoals)
    {
        Integer total = 0;
        if(allGoals != null) {
            for (String goal : allGoals.keySet()) {
                total += allGoals.get(goal);
            }
        }

        return total.toString();
    }

    private String milliSecToDate(Fixtures data)
    {
        Log.d(TAG, "method milli sec to date");

        SimpleDateFormat dateFormat = new SimpleDateFormat("d-MMM-yyyy");
        Date date = new Date(data.getMatchDateTime());

        return dateFormat.format(date);
    }


    private String milliSecToTime(Fixtures data)
    {
        Log.d(TAG, "method milli sec to time");

        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(data.getMatchDateTime());
        cal.setTimeZone(cal.getTimeZone());

        return new SimpleDateFormat("hh : mm aa").format(cal.getTime());
    }



    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {

        Log.d(TAG, "on save instance state");
        super.onSaveInstanceState(outState);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "on create");
        setRetainInstance(true);
        HomePresenter presenter = new HomePresenter(HomePageFragment.this);
        getHomePageDataFromServer(presenter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "on activity created");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.d(TAG, "on start fragment");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.d(TAG, "on resume fragment");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.d(TAG, "on pause fragment");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.d(TAG, "o stop fragment");
        super.onStop();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        Log.d(TAG, "on attach fragment");
        super.onAttach(context);
    }

    @Override
    public void onDestroyView() {
        Log.d(TAG, "on destroy view fragment");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "on destroy fragment");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.d(TAG, "on detach fragment");
        super.onDetach();
    }

    public void setConfig(String config)
    {
        Log.d(TAG, "set config called" + config);
        this.config = config;
    }


}
