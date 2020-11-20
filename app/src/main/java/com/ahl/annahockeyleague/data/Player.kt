package com.ahl.annahockeyleague.data

import org.bson.types.ObjectId

data class Player(
        var id: ObjectId = ObjectId(),
        val name: String = "",
        val position: Position = Position.DEFAULT,
        val profile: String = ""
)