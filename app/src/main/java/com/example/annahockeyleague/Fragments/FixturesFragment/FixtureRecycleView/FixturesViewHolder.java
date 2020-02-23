package com.example.annahockeyleague.Fragments.FixturesFragment.FixtureRecycleView;

import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FixturesViewHolder extends RecyclerView.ViewHolder {

    public FixturesViewHolder(@NonNull View itemView) {
        super(itemView);
        Log.d(FixturesViewHolder.class.getSimpleName(), "fixture view holder");
    }

}
