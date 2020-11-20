package com.ahl.annahockeyleague.kotlin.data

import org.bson.types.ObjectId

data class Player(
        var id: ObjectId = ObjectId(),
        val name: String = "",
        val position: Position = Position.DEFAULT,
        val profile: String = ""
)