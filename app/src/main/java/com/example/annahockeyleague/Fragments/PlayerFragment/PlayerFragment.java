package com.example.annahockeyleague.Fragments.PlayerFragment;

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
import com.example.annahockeyleague.Entity.Player;
import com.example.annahockeyleague.Fragments.PlayerFragment.PlayerRecyclerView.PlayerRecycleAdapter;
import com.example.annahockeyleague.R;

import org.bson.types.ObjectId;

import java.util.ArrayList;

public class PlayerFragment extends Fragment implements PlayerViewInterface {

    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private ObjectId teamId;
    private FragmentConfig config;

    public PlayerFragment() {
    }

    public PlayerFragment(ObjectId teamId, FragmentConfig config)
    {
        this.teamId = teamId;
        this.config = config;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.player_fragment_layout, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        initRecycleView();

        progressBar = view.findViewById(R.id.player_progress_bar);
        progressBar.setVisibility(View.VISIBLE);
        progressBar.setIndeterminate(true);

        PlayerPresenter getPlayers = new PlayerPresenter(PlayerFragment.this);
        getPlayers.playerList(teamId, config);

    }

    private void initRecycleView()
    {
        recyclerView = getView().findViewById(R.id.player_recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
    }


    @Override
    public void showPlayers(ArrayList<Player> playersList) {

        PlayerRecycleAdapter adapter = new PlayerRecycleAdapter(playersList);
        recyclerView.setAdapter(adapter);

        if(progressBar != null)
        {
            progressBar.setIndeterminate(false);
            progressBar.setVisibility(View.INVISIBLE);
        }

    }
}
