package com.ahl.annahockeyleague.data

import org.bson.types.ObjectId
import kotlin.collections.ArrayList

class Teams : ArrayList<TeamData>()

data class TeamData(
        val id: ObjectId = ObjectId(),
        val name: String = "",
        val teamLogo: String = "",
        val teamTag: TeamTag = TeamTag.DEFAULT,
        val tournamentId: ObjectId = ObjectId(),
        var category : String = ""
)