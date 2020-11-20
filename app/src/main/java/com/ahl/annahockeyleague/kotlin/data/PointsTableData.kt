package com.ahl.annahockeyleague.kotlin.data


class PointsTable : ArrayList<PointsTableData>()

data class PointsTableData(
                val position : Int,
                val points : Int,
                val goalScored : Int,
                val goalAgainst : Int,
                val goalDifference : Int,
                val matchesPlayed : Int,
                val won : Int,
                val draw : Int,
                val lost : Int,
                val team: TeamData,
                var category : String
)



