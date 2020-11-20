package com.ahl.annahockeyleague.kotlin.kotlinfragments


interface AhlRepo {

    suspend fun getHomePageData(tournamentId : String, category : String)

    suspend fun fetchTeamList(tournamentId : String, category : String)
}