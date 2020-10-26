package com.ahl.annahockeyleague.kotlin.data

import com.ahl.annahockeyleague.Entity.Player
import com.ahl.annahockeyleague.Entity.Team
import org.bson.types.ObjectId

class TopScorers(val playerId: ObjectId,
                val goals: Int,
                val player: Player,
                val team: Team)