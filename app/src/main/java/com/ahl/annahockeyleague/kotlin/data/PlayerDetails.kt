package com.ahl.annahockeyleague.kotlin.data


data class PlayerDetails(val player: Player,
                        val goals: Int,
                        val card: List<Card>)