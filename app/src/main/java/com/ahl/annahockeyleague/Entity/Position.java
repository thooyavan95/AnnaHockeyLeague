package com.ahl.annahockeyleague.Entity;

public enum Position {

    FORWARD("Forward"),

    MIDFIELDER("Mid Fielder"),

    DEFENCE("Defence"),

    GOALKEEPER("Goal Keeper");

    private String position;

    Position(String position)
    {
        this.position = position;
    }

    public String getPosition()
    {
        return position;
    }

}
