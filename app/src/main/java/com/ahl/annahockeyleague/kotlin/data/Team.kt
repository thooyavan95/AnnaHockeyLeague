package com.ahl.annahockeyleague.kotlin.data

import com.ahl.annahockeyleague.AhlConfig.TeamTag
import org.bson.types.ObjectId

data class Team(
        val id: ObjectId,
        val name: String,
        val teamLogo: String,
        val teamTag: TeamTag,
        val tournamentId: ObjectId
)