package com.ahl.annahockeyleague.Fragments.PlayerFragment;

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
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ahl.annahockeyleague.Entity.PlayerDetails;
import com.ahl.annahockeyleague.Entity.Team;
import com.ahl.annahockeyleague.Fragments.PlayerFragment.PlayerRecyclerView.PlayerRecycleAdapter;
import com.ahl.annahockeyleague.R;

import java.util.ArrayList;

public class PlayerFragment extends Fragment implements PlayerViewInterface {

    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private static final String TAG = PlayerFragment.class.getSimpleName();

    public PlayerFragment() {
        Log.d(TAG, "player fragment constructor called");
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

    }

    private void initRecycleView()
    {
        if(getView() != null) {
            Log.d(TAG, "init recycle view");
            recyclerView = getView().findViewById(R.id.player_recycle_view);
            DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView.addItemDecoration(dividerItemDecoration);
            recyclerView.setHasFixedSize(true);
        }
    }


    @Override
    public void showPlayers(final ArrayList<PlayerDetails> playersList) {

        Log.d(TAG, "show players callback");

        if(getActivity() != null) {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    PlayerRecycleAdapter adapter = new PlayerRecycleAdapter(playersList);
                    recyclerView.setAdapter(adapter);

                    if (progressBar != null) {
                        Log.d(TAG, "progress bar is not null");
                        progressBar.setIndeterminate(false);
                        progressBar.setVisibility(View.INVISIBLE);
                    }

                }
            });
        }

    }

    @Override
    public void displayErrorMessage(final Exception e) {
        Log.d(TAG, "display error message" + e.toString());
        if(getActivity() != null) {

            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getContext(), e.toString(), Toast.LENGTH_SHORT).show();
                }
            });

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

         if(getArguments() != null) {
             Team team = getArguments().getParcelable("teamObj");
             PlayerPresenter getPlayers = new PlayerPresenter(PlayerFragment.this);
             assert team != null;
             getPlayers.playerList(team.getId());
        }
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
