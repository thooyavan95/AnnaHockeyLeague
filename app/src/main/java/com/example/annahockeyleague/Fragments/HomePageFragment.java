package com.example.annahockeyleague.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.annahockeyleague.Adapters.PointsTableAdapter;
import com.example.annahockeyleague.Adapters.TopScorersAdapter;
import com.example.annahockeyleague.AhlConfig.FragmentConfig;
import com.example.annahockeyleague.Entity.PointsTable;
import com.example.annahockeyleague.Entity.TopScorers;
import com.example.annahockeyleague.Interfaces.ViewInterface;
import com.example.annahockeyleague.Entity.Fixtures;
import com.example.annahockeyleague.Entity.Presenter;
import com.example.annahockeyleague.R;

import java.util.ArrayList;

public class HomePageFragment extends Fragment implements ViewInterface {

    private FragmentConfig config;
    private static final String TAG = "HomePageFragment";

    public HomePageFragment() {
        Log.d(TAG,"empty constructor called");
        // Required empty public constructor
    }

    public HomePageFragment(FragmentConfig config) {
        Log.d(TAG,"Homefragment config constructor");
        this.config = config;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.d(TAG,"onCreateView");
        return inflater.inflate(R.layout.fragment_home_page, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.d(TAG,"onViewCreated");

        Presenter presenter = new Presenter(HomePageFragment.this);

        getHomePageDataFromServer(presenter);
    }


    private void getHomePageDataFromServer(Presenter presenter) {
        Log.d(TAG,"method get home page data from server");
        presenter.fetchData(config);
    }


    @Override
    public void setNextMatchFixture(final Fixtures data, final String date, final String time) {

        Log.d(TAG,"method set next match Fixtues data");
        if(getView() != null) {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    Log.d(TAG,"run on ui thread inside set fixtures data men");

                    Log.d(TAG, "updating ui with next match details");

//                    ((TextView) getView().findViewById(R.id.next_match_fixture_date)).setText(date);
//                    ((TextView) getView().findViewById(R.id.next_match_fixture_time)).setText(time);
//                    ((TextView) getView().findViewById(R.id.next_match_team1_name)).setText(data.getTeam1Name());
//                    ((TextView) getView().findViewById(R.id.next_match_team2_name)).setText(data.getTeam2Name());
//                    ((TextView) getView().findViewById(R.id.next_match_team1_score)).setText(data.getTeam1Goal());
//                    ((TextView) getView().findViewById(R.id.next_match_team2_score)).setText(data.getTeam2Goal());


                    if (config == FragmentConfig.MEN) {

                        Log.d(TAG,"updating ui with next match details men");

                        ((TextView) getView().findViewById(R.id.next_match_fixture_date)).setText(date);
                        ((TextView) getView().findViewById(R.id.next_match_fixture_time)).setText(time);
                        ((TextView) getView().findViewById(R.id.next_match_team1_name)).setText(data.getTeam1Name());
                        ((TextView) getView().findViewById(R.id.next_match_team2_name)).setText(data.getTeam2Name());
                        ((TextView) getView().findViewById(R.id.next_match_team1_score)).setText(data.getTeam1Goal());
                        ((TextView) getView().findViewById(R.id.next_match_team2_score)).setText(data.getTeam2Goal());
                    } else {

                        Log.d(TAG,"updating ui with next match details women");

                        ((TextView) getView().findViewById(R.id.next_match_fixture_date)).setText(date);
                        ((TextView) getView().findViewById(R.id.next_match_fixture_time)).setText(time);
                        ((TextView) getView().findViewById(R.id.next_match_team1_name)).setText(data.getTeam1Name());
                        ((TextView) getView().findViewById(R.id.next_match_team2_name)).setText(data.getTeam2Name());
                        ((TextView) getView().findViewById(R.id.next_match_team1_score)).setText(data.getTeam1Goal());
                        ((TextView) getView().findViewById(R.id.next_match_team2_score)).setText(data.getTeam2Goal());

                    }

                }
            });

        }
        }

    @Override
    public void setPrevoiusMatchFixture(final Fixtures data, final String date, final String time) {

        if(getView() != null) {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    Log.d(TAG,"run on ui thread inside set previous match fixtures data");


                    Log.d(TAG, "updating ui with previous match fixture data");

//                    ((TextView) getView().findViewById(R.id.previous_match_fixture_date)).setText(date);
//                    ((TextView) getView().findViewById(R.id.previous_match_fixture_time)).setText(time);
//                    ((TextView) getView().findViewById(R.id.previous_match_team1_name)).setText(data.getTeam1Name());
//                    ((TextView) getView().findViewById(R.id.previous_match_team2_name)).setText(data.getTeam2Name());
//                    ((TextView) getView().findViewById(R.id.previous_match_team1_score)).setText(data.getTeam1Goal());
//                    ((TextView) getView().findViewById(R.id.previous_match_team2_score)).setText(data.getTeam2Goal());



                    if (config == FragmentConfig.MEN) {

                        Log.d(TAG,"updating ui with previous match details men");

                        ((TextView) getView().findViewById(R.id.previous_match_fixture_date)).setText(date);
                        ((TextView) getView().findViewById(R.id.previous_match_fixture_time)).setText(time);
                        ((TextView) getView().findViewById(R.id.previous_match_team1_name)).setText(data.getTeam1Name());
                        ((TextView) getView().findViewById(R.id.previous_match_team2_name)).setText(data.getTeam2Name());
                        ((TextView) getView().findViewById(R.id.previous_match_team1_score)).setText(data.getTeam1Goal());
                        ((TextView) getView().findViewById(R.id.previous_match_team2_score)).setText(data.getTeam2Goal());

                    } else {

                        Log.d(TAG,"updating ui with previous match details women");

                        ((TextView) getView().findViewById(R.id.previous_match_fixture_date)).setText(date);
                        ((TextView) getView().findViewById(R.id.previous_match_fixture_time)).setText(time);
                        ((TextView) getView().findViewById(R.id.previous_match_team1_name)).setText(data.getTeam1Name());
                        ((TextView) getView().findViewById(R.id.previous_match_team2_name)).setText(data.getTeam2Name());
                        ((TextView) getView().findViewById(R.id.previous_match_team1_score)).setText(data.getTeam1Goal());
                        ((TextView) getView().findViewById(R.id.previous_match_team2_score)).setText(data.getTeam2Goal());

                    }

                }
            });

        }


    }

    @Override
    public void setPointsTable(final ArrayList<PointsTable> pointsData) {

        Log.d(TAG,"method set points table");

        if(getView() != null) {

            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    PointsTableAdapter adapter = new PointsTableAdapter(getContext(), pointsData);
                    ((ListView) getView().findViewById(R.id.points_table_listview)).setAdapter(adapter);

                    setListViewHeightBasedOnChildren((ListView) getView().findViewById(R.id.points_table_listview));
                }
            });

        }

    }

    @Override
    public void setTopScorers(final ArrayList<TopScorers> topScorersData) {
        Log.d(TAG,"method set top scorers data");

        if(getView() != null) {

            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    TopScorersAdapter scorersAdapter = new TopScorersAdapter(getContext(),topScorersData);
                    ((ListView) getView().findViewById(R.id.top_scorers_listview)).setAdapter(scorersAdapter);
                    setListViewHeightBasedOnChildren((ListView) getView().findViewById(R.id.top_scorers_listview));
                }
            });
        }
    }


    @Override
    public void setFailureToast(final Exception e) {

        Log.d(TAG,"method setfailure toast");

        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {

                Log.d(TAG,"run on ui thread inside set failure toast");
                Toast.makeText(getContext(), String.valueOf(e), Toast.LENGTH_SHORT).show();
                Log.d("error msg",String.valueOf(e));
            }
        });


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

}
