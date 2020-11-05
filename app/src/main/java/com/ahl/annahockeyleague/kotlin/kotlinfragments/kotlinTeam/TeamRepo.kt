package com.ahl.annahockeyleague.kotlin.kotlinfragments.kotlinTeam

interface TeamRepo {

    suspend fun fetchTeamList(tournamentId : String, category : String, teamListListener: TeamListListener)

}