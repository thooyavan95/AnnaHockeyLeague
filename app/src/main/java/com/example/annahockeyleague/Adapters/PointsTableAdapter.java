package com.example.annahockeyleague.Adapters;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.annahockeyleague.Entity.PointsTable;
import com.example.annahockeyleague.R;

import java.util.ArrayList;

public class PointsTableAdapter extends ArrayAdapter<PointsTable> {

    private static final String TAG = "PointsTableAdapter";
    public PointsTableAdapter(@NonNull Context context, @NonNull ArrayList<PointsTable> objects) {
        super(context, 0, objects);
        Log.d(TAG, "points table adapter constructor");
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Log.d(TAG, "getView method called");

        if(convertView == null)
        {
            Log.d(TAG,"convertView null");
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.points_table_row_template,parent,false);
        }

        PointsTable pointsData = getItem(position);

        ((TextView) convertView.findViewById(R.id.PT_row_position)).setText(String.valueOf(pointsData.getPosition()));
        ((TextView) convertView.findViewById(R.id.PT_row_team_name)).setText(pointsData.getTeamName());
        ((TextView) convertView.findViewById(R.id.PT_row_win)).setText(String.valueOf(pointsData.getWon()));
        ((TextView) convertView.findViewById(R.id.PT_row_loss)).setText(String.valueOf(pointsData.getLost()));
        ((TextView) convertView.findViewById(R.id.PT_row_draw)).setText(String.valueOf(pointsData.getDraw()));
        ((TextView) convertView.findViewById(R.id.PT_row_goalDiff)).setText(String.valueOf(pointsData.getGoalDifference()));
        ((TextView) convertView.findViewById(R.id.PT_row_points)).setText(String.valueOf(pointsData.getPoints()));
        ((TextView) convertView.findViewById(R.id.PT_row_matches_played)).setText(String.valueOf(pointsData.getMatchesPlayed()));


        return convertView;
    }
}

