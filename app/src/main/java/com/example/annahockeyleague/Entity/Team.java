package com.example.annahockeyleague.Entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.annahockeyleague.AhlConfig.TeamTag;

import org.bson.types.ObjectId;

public class Team implements Parcelable {

    private ObjectId id;
    private String name;
    private String teamLogo;
    private TeamTag teamTag;
    private ObjectId tournamentId;

    protected Team(Parcel in) {
        name = in.readString();
        teamLogo = in.readString();
    }

    public static final Creator<Team> CREATOR = new Creator<Team>() {
        @Override
        public Team createFromParcel(Parcel in) {
            return new Team(in);
        }

        @Override
        public Team[] newArray(int size) {
            return new Team[size];
        }
    };

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeamLogo() {
        return teamLogo;
    }

    public void setTeamLogo(String teamLogo) {
        this.teamLogo = teamLogo;
    }

    public TeamTag getTeamTag() {
        return teamTag;
    }

    public void setTeamTag(TeamTag teamTag) {
        this.teamTag = teamTag;
    }

    public ObjectId getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(ObjectId tournamentId) {
        this.tournamentId = tournamentId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(teamLogo);
    }
}
