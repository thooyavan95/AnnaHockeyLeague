package com.example.annahockeyleague.Fragments.FixturesFragment.FixtureRecycleView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.annahockeyleague.AhlConfig.FragmentConfig;
import com.example.annahockeyleague.Entity.Fixtures;
import com.example.annahockeyleague.Entity.Team;
import com.example.annahockeyleague.R;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;

public class FixturesRecyclerView extends RecyclerView.Adapter<FixturesViewHolder> {

    private ArrayList<Fixtures> fixturesList;
    private FragmentConfig config;
    private static final String TAG = FixturesRecyclerView.class.getSimpleName();

    public FixturesRecyclerView(ArrayList<Fixtures> fixturesList, FragmentConfig config) {
        Log.d(TAG, "fixture recycle view constructor");
        this.fixturesList = fixturesList;
        this.config = config;
    }

    @NonNull
    @Override
    public FixturesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Log.d(TAG, "fixture view holder");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fixture_layout, parent, false);
        return new FixturesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FixturesViewHolder holder, int position) {

        Log.d(TAG, "on bind view holder");
            ((TextView) holder.itemView.findViewById(R.id.next_match_fixture_date)).setText(milliSecToDate(fixturesList.get(position)));
            ((TextView) holder.itemView.findViewById(R.id.next_match_fixture_time)).setText(milliSecToTime(fixturesList.get(position)));
            ((TextView) holder.itemView.findViewById(R.id.next_match_team1_name)).setText(fixturesList.get(position).getTeam1().getName());
            ((TextView) holder.itemView.findViewById(R.id.next_match_team2_name)).setText(fixturesList.get(position).getTeam2().getName());
            ((TextView) holder.itemView.findViewById(R.id.next_match_team1_score)).setText(getGoals(fixturesList.get(position).getTeam1Scorers()));
            ((TextView) holder.itemView.findViewById(R.id.next_match_team2_score)).setText(getGoals(fixturesList.get(position).getTeam2Scorers()));
            Picasso.get().load(setTeamLogo(fixturesList.get(position).getTeam1())).fit().into((ImageView) holder.itemView.findViewById(R.id.next_match_team1_image));
            Picasso.get().load(setTeamLogo(fixturesList.get(position).getTeam2())).fit().into((ImageView) holder.itemView.findViewById(R.id.next_match_team2_image));

    }

    private String milliSecToDate(Fixtures data)
    {

        Log.d(TAG, "millisec to date called");
        SimpleDateFormat dateFormat = new SimpleDateFormat("d-MMM-yyyy");
        Date date = new Date(data.getMatchDateTime());

        return dateFormat.format(date);
    }


    private String milliSecToTime(Fixtures data)
    {

        Log.d(TAG, "millisec to time called");
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(data.getMatchDateTime());
        cal.setTimeZone(cal.getTimeZone());

        return new SimpleDateFormat("hh : mm aa").format(cal.getTime());
    }

    private String getGoals(Map<String, Integer> allGoals)
    {

        Log.d(TAG, "get goals called");

        Integer total = 0;
        if(allGoals != null) {

            for (String goal : allGoals.keySet()) {
                total = total + allGoals.get(goal);
            }
        }
            return total.toString();
    }

    private int setTeamLogo(Team data)
    {

        Log.d(TAG, "set team logo called");

        int image = 0;

        switch (data.getTeamTag())
        {

            case M_RED:

            case W_RED:

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

        }

        return image;
    }






    @Override
    public int getItemCount() {
        Log.d(TAG, "get item count" + fixturesList.size());
        return fixturesList.size();
    }
}
