package com.example.annahockeyleague.Fragments.FixturesFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.annahockeyleague.AhlConfig.FragmentConfig;
import com.example.annahockeyleague.Entity.Fixtures;
import com.example.annahockeyleague.Fragments.FixturesFragment.FixtureRecycleView.FixturesRecyclerView;
import com.example.annahockeyleague.R;

import java.util.ArrayList;

public class FixturesFragment extends Fragment {

    private FragmentConfig config;
    private ArrayList<Fixtures> fixturesList;

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

        fixturesList.add(new Fixtures("mom", "budding", "1", "12:40", 1, "done"
                ,4L, "team1", "team2", "3", "4"));

        fixturesList.add(new Fixtures("mom", "budding", "1", "12:40", 1, "done"
                ,4L, "team1", "team2", "3", "4"));

        fixturesList.add(new Fixtures("mom", "budding", "1", "12:40", 1, "done"
                ,4L, "team1", "team2", "3", "4"));


        FixturesRecyclerView adapter = new FixturesRecyclerView(fixturesList, config);
        ((RecyclerView) getView().findViewById(R.id.fixtures_recycler_view)).setAdapter(adapter);

    }

    private void initRecyclerView()
    {
        ((RecyclerView) getView().findViewById(R.id.fixtures_recycler_view)).setLayoutManager(new LinearLayoutManager(getContext()));
        ((RecyclerView) getView().findViewById(R.id.fixtures_recycler_view)).setHasFixedSize(true);
        fixturesList = new ArrayList<>();
    }

}
