package com.ahl.annahockeyleague.Fragments.PlayerFragment.PlayerRecyclerView;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ahl.annahockeyleague.R;

public class PlayerRecycleViewHolder extends RecyclerView.ViewHolder {

    public ImageView playerImage;
    public TextView playerName,playerPosition;
    private static final String TAG = PlayerRecycleViewHolder.class.getSimpleName();

    public PlayerRecycleViewHolder(@NonNull View itemView) {
        super(itemView);

        Log.d(TAG, "player recycle view holder");
        playerImage = itemView.findViewById(R.id.top_scorer_avatar);
        playerName = itemView.findViewById(R.id.top_scorer_name);
        playerPosition = itemView.findViewById(R.id.top_scorer_team);
    }
}
