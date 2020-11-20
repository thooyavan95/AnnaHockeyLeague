package com.ahl.annahockeyleague.data

import org.bson.types.ObjectId

data class Tournament(val id: ObjectId,
                        val season: String,
                        val theme: String,
                        val tagLine: String,
                        val tournamentName: String,
                        val tournamentLogo: String,
                        val live : Boolean)