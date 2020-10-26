package com.ahl.annahockeyleague.kotlin.data

import com.ahl.annahockeyleague.Entity.Player
import com.ahl.annahockeyleague.Entity.Team
import org.bson.types.ObjectId

data class Fixtures(
                 val id: ObjectId,
                 val tournamentId: ObjectId,
                 val mom: Player?,
                 val buddingPlayer: Player?,
                 val round: String,
                 val timer: String,
                 val result : Int,
                 val status: String,
                 val matchDateTime: Long,
                 val team1Scorers: Map<String, Int>,
                 val team2Scorers: Map<String, Int>,
                 val team1: Team,
                 val team2: Team
)
