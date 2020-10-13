package com.ahl.annahockeyleague.Fragments.FixturesFragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ahl.annahockeyleague.Entity.Fixtures;
import com.ahl.annahockeyleague.Entity.PointsTable;
import com.ahl.annahockeyleague.Entity.TopScorers;
import com.ahl.annahockeyleague.Fragments.FixturesFragment.FixtureRecycleView.FixturesRecyclerViewAdapter;
import com.ahl.annahockeyleague.Fragments.HomeFragment.HomePresenter;
import com.ahl.annahockeyleague.Fragments.HomeFragment.HomeViewInterface;
import com.ahl.annahockeyleague.R;

import java.util.ArrayList;

public class FixturesFragment extends Fragment implements HomeViewInterface {

    private String config;
    private static final String TAG = FixturesFragment.class.getSimpleName();
    private ArrayList<Fixtures> fixturesData;

    public FixturesFragment()
    {
        Log.d(TAG, "fixture fragment constructor");
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "on create view");
        return inflater.inflate(R.layout.fixtures_fragment_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "on view created");

        initRecyclerView();

        view.findViewById(R.id.fixtures_progress_bar).setVisibility(View.VISIBLE);
        ((ProgressBar) view.findViewById(R.id.fixtures_progress_bar)).setIndeterminate(true);

        if(fixturesData != null)
        {
            setAllFixturesData(fixturesData);
        }

    }

    private void initRecyclerView()
    {
        if(getView() != null) {
            Log.d(TAG, "init recycle view");
            ((RecyclerView) getView().findViewById(R.id.fixtures_recycler_view)).setLayoutManager(new LinearLayoutManager(getContext()));
            ((RecyclerView) getView().findViewById(R.id.fixtures_recycler_view)).setHasFixedSize(true);
        }
    }

    @Override
    public void setNextMatchFixture(Fixtures data) {

    }

    @Override
    public void setPrevoiusMatchFixture(Fixtures data) {

    }

    @Override
    public void setPointsTable(ArrayList<PointsTable> pointsData) {

    }

    @Override
    public void setTopScorers(ArrayList<TopScorers> topScorersData) {

    }

    @Override
    public void setFailureToast(final Exception e) {

        if(getActivity() != null)
        {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getContext(), String.valueOf(e), Toast.LENGTH_SHORT).show();
                }
            });
        }

    }

    @Override
    public void setFixtures(final ArrayList<Fixtures> allFixturesData) {

        if(getActivity() != null) {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    fixturesData = allFixturesData;

                    setAllFixturesData(allFixturesData);

                }
            });
        }

    }


    private void setAllFixturesData(ArrayList<Fixtures> fixturesDataList)
    {
        if(getView() != null) {
            FixturesRecyclerViewAdapter adapter = new FixturesRecyclerViewAdapter(fixturesDataList);
            ((RecyclerView) getView().findViewById(R.id.fixtures_recycler_view)).setAdapter(adapter);

            if (getView().findViewById(R.id.fixtures_progress_bar) != null) {
                ((ProgressBar) getView().findViewById(R.id.fixtures_progress_bar)).setIndeterminate(false);
                getView().findViewById(R.id.fixtures_progress_bar).setVisibility(View.INVISIBLE);
            }
        }
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

        if(getArguments() != null) {
            config = getArguments().getString("config");
            Log.d(TAG, "get arguments " + getArguments().get("config"));
        }

        HomePresenter presenter = new HomePresenter(FixturesFragment.this);
        presenter.fetchData(config);

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
}
