package com.ahl.annahockeyleague.Entity;

import org.bson.types.ObjectId;

public class Tournament {

    private ObjectId id;
    private String season;
    private String theme;
    private String tagLine;
    private String tournamentName;
    private String tournamentLogo;
    private boolean live;


    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getTagLine() {
        return tagLine;
    }

    public void setTagLine(String tagLine) {
        this.tagLine = tagLine;
    }

    public String getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    public String getTournamentLogo() {
        return tournamentLogo;
    }

    public void setTournamentLogo(String tournamentLogo) {
        this.tournamentLogo = tournamentLogo;
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    @Override
    public String toString() {
        return "Tournament{" +
                "id=" + id +
                ", season='" + season + '\'' +
                ", theme='" + theme + '\'' +
                ", tagLine='" + tagLine + '\'' +
                ", tournamentName='" + tournamentName + '\'' +
                ", tournamentLogo='" + tournamentLogo + '\'' +
                ", isLive=" + live +
                '}';
    }
}
