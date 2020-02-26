package com.example.annahockeyleague.Fragments.TeamFragment;

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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.annahockeyleague.AhlConfig.FragmentConfig;
import com.example.annahockeyleague.Entity.Team;
import com.example.annahockeyleague.Fragments.TeamFragment.TeamRecyclerView.OnTeamSelected;
import com.example.annahockeyleague.Fragments.TeamFragment.TeamRecyclerView.TeamRecycleAdapter;
import com.example.annahockeyleague.R;
import com.example.annahockeyleague.TestInterface;

import java.util.ArrayList;

public class TeamFragment extends Fragment implements TeamViewInterface {

    private FragmentConfig config;
    private TestInterface testInterface;
    private ArrayList<Team> teamListData;
    private static final String TAG = TeamFragment.class.getSimpleName();

    public TeamFragment()
    {
        Log.d(TAG, "team fragment constructor called");
    }

    public TeamFragment(FragmentConfig config, TestInterface testInterface)
    {
        Log.d(TAG, "team fragment constructor with params called");
        this.config = config;
        this.testInterface = testInterface;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "on create view");
        return inflater.inflate(R.layout.team_fragment_layout,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        Log.d(TAG, "on view created");
        view.findViewById(R.id.team_progress_bar).setVisibility(View.VISIBLE);
        ((ProgressBar)view.findViewById(R.id.team_progress_bar)).setIndeterminate(true);

        if(teamListData != null)
        {
            setTeamListData(teamListData);
        }
    }

    @Override
    public void showTeams(final ArrayList<Team> teamsList) {

        Log.d(TAG, "show teams callback");

        if(getActivity() != null && teamsList != null) {

            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    teamListData = teamsList;

                    setTeamListData(teamsList);

                }
            });

        }

    }

    @Override
    public void displayErrorMessage(Exception e) {
        Log.d(TAG, "display error message");
        if(getActivity() != null) {
            Toast.makeText(getContext(), e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    private void setTeamListData(final ArrayList<Team> teamArrayList)
    {
        if(getView() != null) {
            RecyclerView recyclerView = getView().findViewById(R.id.team_recycle_view);
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
            recyclerView.setHasFixedSize(true);
            recyclerView.setBackgroundColor(getResources().getColor(R.color.colorWhisper));

            TeamRecycleAdapter adapter = new TeamRecycleAdapter(teamArrayList, new OnTeamSelected() {
                @Override
                public void onTeamSelect(int position) {

                    testInterface.showPlayerFragment(teamArrayList.get(position));

                }
            });

            recyclerView.setAdapter(adapter);

            if (getView().findViewById(R.id.team_progress_bar) != null) {
                Log.d(TAG, "progress bar is not null");
                ((ProgressBar) getView().findViewById(R.id.team_progress_bar)).setIndeterminate(false);
                getView().findViewById(R.id.team_progress_bar).setVisibility(View.INVISIBLE);
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

        TeamPresenter fetch = new TeamPresenter(TeamFragment.this);
        fetch.getTeamList(config);

        setRetainInstance(true);

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
