package com.ahl.annahockeyleague.kotlin.data

import com.ahl.annahockeyleague.Entity.Card
import com.ahl.annahockeyleague.Entity.Player

data class PlayerDetails(val player: Player,
                        val goals: Int,
                        val card: List<Card>)