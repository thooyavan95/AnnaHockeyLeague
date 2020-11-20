package com.ahl.annahockeyleague.kotlin.data

import org.bson.types.ObjectId

class Fixtures : ArrayList<FixturesData>()

data class FixturesData(
        val id: ObjectId = ObjectId(),
        val tournamentId: ObjectId = ObjectId(),
        val mom: Player = Player(),
        val buddingPlayer: Player? = Player(),
        val round: String = "",
        val timer: String ="",
        val result : Int = 0,
        val status: String = "",
        val matchDateTime: Long = 0L,
        val team1Scorers: Map<String, Int> = mapOf(),
        val team2Scorers: Map<String, Int> = mapOf(),
        val team1: TeamData = TeamData(),
        val team2: TeamData = TeamData(),
        var category : String = ""
)
