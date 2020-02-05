package com.example.annahockeyleague.AhlConfig;

public enum TeamTag {

    M_RED("RR"),

    M_BLUE("SB"),

    M_WHITE("WW"),

    M_YELLOW("YY"),

    M_GREEN("GG"),

    M_VIOLET("VW"),

    W_RED("RR"),

    W_BLUE("SB"),

    W_WHITE("WW"),

    W_YELLOW("YY"),

    W_GREEN("GG"),

    W_VIOLET("VW"),

    M_BLACK("BH"),

    Other("OT");

    private String shortTeamName;

    TeamTag(String shortTeamName) {
        this.shortTeamName = shortTeamName;
    }


    public String getShortTeamName() {
        return shortTeamName;
    }
}
