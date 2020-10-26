package com.ahl.annahockeyleague.kotlin.data

import com.ahl.annahockeyleague.Entity.Position
import org.bson.types.ObjectId

data class Player(
        var id: ObjectId,
        val name: String,
        val position: Position,
        val profile: String
)