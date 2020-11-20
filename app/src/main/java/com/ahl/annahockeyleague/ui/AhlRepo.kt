package com.ahl.annahockeyleague.ui


interface AhlRepo {

    suspend fun getHomePageData(tournamentId : String, category : String)

    suspend fun fetchTeamList(tournamentId : String, category : String)
}