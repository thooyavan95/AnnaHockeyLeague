package com.ahl.annahockeyleague.Fragments.HomeFragment.SponsorRecycleView;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ahl.annahockeyleague.R;

public class SponsorViewHolder extends RecyclerView.ViewHolder {

    public ImageView imageView;

    public SponsorViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.sponsor_logo);

    }
}
