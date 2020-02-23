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

import com.example.annahockeyleague.Entity.PointsTable;
import com.example.annahockeyleague.Entity.Team;
import com.example.annahockeyleague.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static com.example.annahockeyleague.AhlConfig.TeamTag.M_BLACK;
import static com.example.annahockeyleague.AhlConfig.TeamTag.M_BLUE;
import static com.example.annahockeyleague.AhlConfig.TeamTag.M_GREEN;
import static com.example.annahockeyleague.AhlConfig.TeamTag.M_RED;
import static com.example.annahockeyleague.AhlConfig.TeamTag.M_VIOLET;
import static com.example.annahockeyleague.AhlConfig.TeamTag.M_WHITE;
import static com.example.annahockeyleague.AhlConfig.TeamTag.M_YELLOW;
import static com.example.annahockeyleague.AhlConfig.TeamTag.W_BLUE;
import static com.example.annahockeyleague.AhlConfig.TeamTag.W_GREEN;
import static com.example.annahockeyleague.AhlConfig.TeamTag.W_RED;
import static com.example.annahockeyleague.AhlConfig.TeamTag.W_VIOLET;
import static com.example.annahockeyleague.AhlConfig.TeamTag.W_WHITE;
import static com.example.annahockeyleague.AhlConfig.TeamTag.W_YELLOW;

public class PointsTableAdapter extends ArrayAdapter<PointsTable> {

    private static final String TAG = PointsTableAdapter.class.getSimpleName();
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
        ((TextView) convertView.findViewById(R.id.PT_row_team_name)).setText(pointsData.getTeam().getTeamTag().getShortTeamName());
        ((TextView) convertView.findViewById(R.id.PT_row_win)).setText(String.valueOf(pointsData.getWon()));
        ((TextView) convertView.findViewById(R.id.PT_row_loss)).setText(String.valueOf(pointsData.getLost()));
        ((TextView) convertView.findViewById(R.id.PT_row_draw)).setText(String.valueOf(pointsData.getDraw()));
        ((TextView) convertView.findViewById(R.id.PT_row_goalDiff)).setText(String.valueOf(pointsData.getGoalDifference()));
        ((TextView) convertView.findViewById(R.id.PT_row_points)).setText(String.valueOf(pointsData.getPoints()));
        ((TextView) convertView.findViewById(R.id.PT_row_matches_played)).setText(String.valueOf(pointsData.getMatchesPlayed()));
        Picasso.get().load(getLogo(pointsData.getTeam())).fit().into((ImageView) convertView.findViewById(R.id.PT_row_team_logo));

        return convertView;
    }

    private int getLogo(Team tag)
    {

        Log.d(TAG, "get logo called");
        int image = 0;

        switch (tag.getTeamTag())
        {

            case W_RED:

            case M_RED:
                image =  R.drawable.red;
                break;

            case M_BLUE:

            case W_BLUE:

                image = R.drawable.bluz;
                break;

            case M_GREEN:

            case W_GREEN:

                image =  R.drawable.griffinz;
                break;

            case M_WHITE:

            case W_WHITE:

                image =  R.drawable.white;
                break;

            case M_VIOLET:

            case W_VIOLET:

                image =  R.drawable.driblerz;
                break;

            case M_YELLOW:

            case W_YELLOW:

                image =  R.drawable.yyy;
                break;

            case M_BLACK:

                image = R.drawable.android_image;
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + tag);
        }

        return image;

    }

}

