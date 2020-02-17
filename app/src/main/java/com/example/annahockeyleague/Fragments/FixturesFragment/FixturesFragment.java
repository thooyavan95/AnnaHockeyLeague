package com.example.annahockeyleague.Fragments.FixturesFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.annahockeyleague.AhlConfig.FragmentConfig;
import com.example.annahockeyleague.Entity.Fixtures;
import com.example.annahockeyleague.Entity.PointsTable;
import com.example.annahockeyleague.Entity.TopScorers;
import com.example.annahockeyleague.Fragments.FixturesFragment.FixtureRecycleView.FixturesRecyclerView;
import com.example.annahockeyleague.Fragments.HomeFragment.HomePresenter;
import com.example.annahockeyleague.Fragments.HomeFragment.HomeViewInterface;
import com.example.annahockeyleague.R;
import com.example.annahockeyleague.TestFixtureModel.FixtureViewInterface;

import java.util.ArrayList;

public class FixturesFragment extends Fragment implements HomeViewInterface {

    private FragmentConfig config;
    private ProgressBar progressBar;

    public FixturesFragment()
    {

    }

    public FixturesFragment(FragmentConfig config)

    {
        this.config = config;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fixtures_fragment_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        initRecyclerView();

        progressBar = view.findViewById(R.id.fixtures_progress_bar);
        progressBar.setVisibility(View.VISIBLE);
        progressBar.setIndeterminate(true);

        HomePresenter presenter = new HomePresenter(FixturesFragment.this);
        presenter.fetchData(config);

    }

    private void initRecyclerView()
    {
        ((RecyclerView) getView().findViewById(R.id.fixtures_recycler_view)).setLayoutManager(new LinearLayoutManager(getContext()));
        ((RecyclerView) getView().findViewById(R.id.fixtures_recycler_view)).setHasFixedSize(true);
    }

    @Override
    public void setNextMatchFixture(Fixtures data, String date, String time) {

    }

    @Override
    public void setPrevoiusMatchFixture(Fixtures data, String date, String time) {

    }

    @Override
    public void setPointsTable(ArrayList<PointsTable> pointsData) {

    }

    @Override
    public void setTopScorers(ArrayList<TopScorers> topScorersData) {

    }

    @Override
    public void setFailureToast(Exception e) {

    }

    @Override
    public void setFixtures(final ArrayList<Fixtures> fixdata) {

        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                FixturesRecyclerView adapter = new FixturesRecyclerView(fixdata, config);
                ((RecyclerView) getView().findViewById(R.id.fixtures_recycler_view)).setAdapter(adapter);

                if(progressBar != null)
                {
                    progressBar.setIndeterminate(false);
                    progressBar.setVisibility(View.INVISIBLE);
                }
            }
        });

    }

}
