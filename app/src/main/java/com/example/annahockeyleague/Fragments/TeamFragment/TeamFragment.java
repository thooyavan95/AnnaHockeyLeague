package com.example.annahockeyleague.Fragments.TeamFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.annahockeyleague.Adapters.FragmentAdapter;
import com.example.annahockeyleague.AhlConfig.FragmentConfig;
import com.example.annahockeyleague.AhlConfig.FragmentType;
import com.example.annahockeyleague.Entity.TestTeamDetails;
import com.example.annahockeyleague.Fragments.TeamFragment.TeamRecyclerView.TeamRecycleAdapter;
import com.example.annahockeyleague.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class TeamFragment extends Fragment {

    private FragmentConfig config;
    private ArrayList<TestTeamDetails> arraylist;

    public TeamFragment()
    {

    }

    public TeamFragment(FragmentConfig config)
    {
        this.config = config;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.team_fragment_layout,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        arraylist = new ArrayList<>();

        arraylist.add(new TestTeamDetails(R.drawable.bluz));
        arraylist.add(new TestTeamDetails(R.drawable.griffinz));
        arraylist.add(new TestTeamDetails(R.drawable.red));
        arraylist.add(new TestTeamDetails(R.drawable.white));
        arraylist.add(new TestTeamDetails(R.drawable.yyy));
        arraylist.add(new TestTeamDetails(R.drawable.driblerz));


        RecyclerView recyclerView = getView().findViewById(R.id.team_recycle_view);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        recyclerView.setHasFixedSize(true);
        TeamRecycleAdapter adapter = new TeamRecycleAdapter(arraylist);
        recyclerView.setAdapter(adapter);


    }
}
