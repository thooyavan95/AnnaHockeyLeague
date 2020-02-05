package com.example.annahockeyleague.Entity;

import com.example.annahockeyleague.AhlConfig.TeamTag;

import org.bson.types.ObjectId;

public class Team {

    private ObjectId id;
    private String name;
    private String teamLogo;
    private TeamTag teamTag;
    private ObjectId tournamentId;

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
}
