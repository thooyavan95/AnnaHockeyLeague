package com.example.annahockeyleague.Entity;

import org.bson.types.ObjectId;

public class Fixtures {

    private ObjectId id;
    private ObjectId team1;
    private ObjectId team2;
    private ObjectId tournamentId;
    private ObjectId mom;
    private ObjectId buddingPlayer;
    private String momName;
    private String buddingPlayerName;

    private String round;
    private String timer;
    private int result;
    private String status;
    private long matchDateTime;
    private String team1Name;
    private String team2Name;
    private String team1Goal;
    private String team2Goal;


    public Fixtures(String momName, String buddingPlayerName, String round, String timer, int result, String status, long matchDateTime, String team1Name, String team2Name, String team1Goal, String team2Goal) {
        this.momName = momName;
        this.buddingPlayerName = buddingPlayerName;
        this.round = round;
        this.timer = timer;
        this.result = result;
        this.status = status;
        this.matchDateTime = matchDateTime;
        this.team1Name = team1Name;
        this.team2Name = team2Name;
        this.team1Goal = team1Goal;
        this.team2Goal = team2Goal;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public ObjectId getTeam1() {
        return team1;
    }

    public void setTeam1(ObjectId team1) {
        this.team1 = team1;
    }

    public ObjectId getTeam2() {
        return team2;
    }

    public void setTeam2(ObjectId team2) {
        this.team2 = team2;
    }

    public ObjectId getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(ObjectId tournamentId) {
        this.tournamentId = tournamentId;
    }

    public String getMomName() {
        return momName;
    }

    public void setMomName(String momName) {
        this.momName = momName;
    }

    public String getBuddingPlayerName() {
        return buddingPlayerName;
    }

    public void setBuddingPlayerName(String buddingPlayerName) {
        this.buddingPlayerName = buddingPlayerName;
    }

    public ObjectId getMom() {
        return mom;
    }

    public void setMom(ObjectId mom) {
        this.mom = mom;
    }

    public ObjectId getBuddingPlayer() {
        return buddingPlayer;
    }

    public void setBuddingPlayer(ObjectId buddingPlayer) {
        this.buddingPlayer = buddingPlayer;
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }

    public String getTimer() {
        return timer;
    }

    public void setTimer(String timer) {
        this.timer = timer;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getMatchDateTime() {
        return matchDateTime;
    }

    public void setMatchDateTime(long matchDateTime) {
       this.matchDateTime=matchDateTime;
    }

    public void setTeam1Name(String team1Name) {
        this.team1Name = team1Name;
    }

    public void setTeam2Name(String team2Name) {
        this.team2Name = team2Name;
    }

    public void setTeam1Goal(String team1Goal) {
        this.team1Goal = team1Goal;
    }

    public void setTeam2Goal(String team2Goal) {
        this.team2Goal = team2Goal;
    }

    public String getTeam1Name() {
        return team1Name;
    }

    public String getTeam2Name() {
        return team2Name;
    }

    public String getTeam1Goal() {
        return team1Goal;
    }

    public String getTeam2Goal() {
        return team2Goal;
    }


    @Override
    public String toString() {
        return "Fixtures{" +
                "id=" + id +
                ", team1=" + team1 +
                ", team2=" + team2 +
                ", tournamentId=" + tournamentId +
                ", momName=" + momName +
                ", buddingPlayerName=" + buddingPlayerName +
                ", round='" + round + '\'' +
                ", timer='" + timer + '\'' +
                ", result=" + result +
                ", status='" + status + '\'' +
                ", matchDateTime=" + matchDateTime +
                ", team1Name='" + team1Name + '\'' +
                ", team2Name='" + team2Name + '\'' +
                ", team1Goal='" + team1Goal + '\'' +
                ", team2Goal='" + team2Goal + '\'' +
                '}';
    }
}
