package com.ahl.annahockeyleague.kotlin.data

import org.bson.types.ObjectId

data class Card(val id : ObjectId,
                val matchId : ObjectId,
                val playerId : ObjectId,
                val cardType : String,
                val forTeamId : ObjectId ,
                val time : Int)
