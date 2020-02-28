package com.ahl.annahockeyleague.Entity;

import org.bson.types.ObjectId;

import java.util.Map;

public class Fixtures {

    private ObjectId id;
    private ObjectId tournamentId;
    private Player mom;
    private Player buddingPlayer;

    private String round;
    private String timer;
    private int result;
    private String status;
    private long matchDateTime;
    private Map<String,Integer> team1Scorers;
    private Map<String, Integer> team2Scorers;
    private Team team1;

    private Team team2;


    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public ObjectId getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(ObjectId tournamentId) {
        this.tournamentId = tournamentId;
    }

    public Player getMom() {
        return mom;
    }

    public void setMom(Player mom) {
        this.mom = mom;
    }

    public Player getBuddingPlayer() {
        return buddingPlayer;
    }

    public void setBuddingPlayer(Player buddingPlayer) {
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
        this.matchDateTime = matchDateTime;
    }

    public Map<String, Integer> getTeam1Scorers() {
        return team1Scorers;
    }

    public void setTeam1Scorers(Map<String, Integer> team1Scorers) {
        this.team1Scorers = team1Scorers;
    }

    public Map<String, Integer> getTeam2Scorers() {
        return team2Scorers;
    }

    public void setTeam2Scorers(Map<String, Integer> team2Scorers) {
        this.team2Scorers = team2Scorers;
    }

    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    @Override
    public String toString() {
        return "Fixtures{" +
                "id=" + id +
                ", tournamentId=" + tournamentId +
                ", mom=" + mom +
                ", buddingPlayer=" + buddingPlayer +
                ", round='" + round + '\'' +
                ", timer='" + timer + '\'' +
                ", result=" + result +
                ", status='" + status + '\'' +
                ", matchDateTime=" + matchDateTime +
                ", team1Scorers=" + team1Scorers +
                ", team2Scorers=" + team2Scorers +
                ", team1=" + team1 +
                ", team2=" + team2 +
                '}';
    }
}
