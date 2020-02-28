package com.ahl.annahockeyleague.Entity;

import java.util.List;

public class PlayerDetails {

    private Player player;
    private int goals;
    private List<Card> card;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public List<Card> getCard() {
        return card;
    }

    public void setCard(List<Card> card) {
        this.card = card;
    }
}
