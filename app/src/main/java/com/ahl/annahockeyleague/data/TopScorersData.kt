package com.ahl.annahockeyleague.data

import org.bson.types.ObjectId

class TopScorers : ArrayList<TopScorersData>()

class TopScorersData(val playerId: ObjectId,
                     val goals: Int,
                     val player: Player,
                     val team: TeamData,
                     var category : Category
)