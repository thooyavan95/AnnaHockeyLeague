package com.example.annahockeyleague.Fragments.PlayerFragment;

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

import com.example.annahockeyleague.Entity.PlayerDetails;
import com.example.annahockeyleague.Fragments.PlayerFragment.PlayerRecyclerView.PlayerRecycleAdapter;
import com.example.annahockeyleague.R;

import org.bson.types.ObjectId;

import java.util.ArrayList;

public class PlayerFragment extends Fragment implements PlayerViewInterface {

    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private ObjectId teamId;
    private static final String TAG = PlayerFragment.class.getSimpleName();

    public PlayerFragment() {
        Log.d(TAG, "player fragment constructor called");
    }

    public PlayerFragment(ObjectId teamId)
    {
        Log.d(TAG, "player fragment constructor with params");
        this.teamId = teamId;
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "on create view");
        return inflater.inflate(R.layout.player_fragment_layout, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        Log.d(TAG, "on view created");
        initRecycleView();

        progressBar = view.findViewById(R.id.player_progress_bar);
        progressBar.setVisibility(View.VISIBLE);
        progressBar.setIndeterminate(true);

        PlayerPresenter getPlayers = new PlayerPresenter(PlayerFragment.this);
        getPlayers.playerList(teamId);

    }

    private void initRecycleView()
    {
        Log.d(TAG, "init recycle view");
        recyclerView = getView().findViewById(R.id.player_recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
    }


    @Override
    public void showPlayers(final ArrayList<PlayerDetails> playersList) {

        Log.d(TAG, "show players callback");
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {

                PlayerRecycleAdapter adapter = new PlayerRecycleAdapter(playersList);
                recyclerView.setAdapter(adapter);

                if(progressBar != null)
                {
                    Log.d(TAG, "progress bar is not null");
                    progressBar.setIndeterminate(false);
                    progressBar.setVisibility(View.INVISIBLE);
                }

            }
        });

    }

    @Override
    public void displayErrorMessage(Exception e) {
        Log.d(TAG, "display error message" + e.toString());
        Toast.makeText(getContext(), e.toString(), Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {

        Log.d(TAG, "on save instance state");
        super.onSaveInstanceState(outState);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        Log.d(TAG, "on create");
        super.onCreate(savedInstanceState);
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
