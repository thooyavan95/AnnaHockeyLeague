package com.ahl.annahockeyleague.ui


interface AhlRepo {

    suspend fun fetchTournamentId()

    suspend fun fetchHomePageData(tournamentId : String, category : String)

    suspend fun fetchTeamList(tournamentId : String, category : String)
}