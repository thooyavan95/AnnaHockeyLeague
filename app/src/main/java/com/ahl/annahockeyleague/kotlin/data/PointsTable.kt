package com.ahl.annahockeyleague.kotlin.data

import com.ahl.annahockeyleague.Entity.Team

data class PointsTable(
                val position : Int,
                val points : Int,
                val goalScored : Int,
                val goalAgainst : Int,
                val goalDifference : Int,
                val matchesPlayed : Int,
                val won : Int,
                val draw : Int,
                val lost : Int,
                val team: Team
)



