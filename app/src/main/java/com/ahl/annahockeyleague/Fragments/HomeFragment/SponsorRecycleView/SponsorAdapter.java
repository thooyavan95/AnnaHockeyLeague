package com.ahl.annahockeyleague.Fragments.HomeFragment.SponsorRecycleView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ahl.annahockeyleague.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SponsorAdapter extends RecyclerView.Adapter<SponsorViewHolder> {

    private ArrayList<Integer> sponsorList;

    public SponsorAdapter(ArrayList<Integer> sponsorList)
    {
        this.sponsorList = sponsorList;
    }

    @NonNull
    @Override
    public SponsorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sponsor_row_template, parent, false);
        return new SponsorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SponsorViewHolder holder, int position) {

        Picasso.get().load(sponsorList.get(position)).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return sponsorList.size();
    }
}
