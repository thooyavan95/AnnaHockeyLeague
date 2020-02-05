package com.example.annahockeyleague.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.annahockeyleague.Entity.TopScorers;
import com.example.annahockeyleague.R;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;

public class TopScorersAdapter extends ArrayAdapter<TopScorers> {

    private static final String TAG = "TopScorerAdapter";

    public TopScorersAdapter(@NonNull Context context, @NonNull ArrayList<TopScorers> objects) {
        super(context, 0, objects);
        Log.d(TAG,"top scorer adapter constructor");
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Log.d(TAG,"method get view");

        if(convertView == null)
        {
            Log.d(TAG, "convertview is null");

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.top_scorer_row_template,parent,false);
        }

        TopScorers scorersData = getItem(position);

        ((TextView) convertView.findViewById(R.id.top_scorer_name)).setText(scorersData.getPlayer().getName());
//        ((TextView) convertView.findViewById(R.id.top_scorer_team)).setText(scorersData.getTeamName());
        ((TextView) convertView.findViewById(R.id.top_scorer_goals)).setText(String.valueOf(scorersData.getGoals()));

        Picasso.get().load(R.drawable.sample_kumble).into((ImageView) convertView.findViewById(R.id.top_scorer_avatar));

        return convertView;

    }
}
