package com.ahl.annahockeyleague.kotlin.kotlinfragments


interface AhlRepo {

    suspend fun getHomePageData(tournamentId : String, category : String, responseListener: AhlRepoImpl.AhlResponseListener)

    suspend fun getFixturesDatList(category : String, tournamentId : String, fixturesListener: AhlRepoImpl.AhlResponseListener)

    suspend fun fetchTeamList(tournamentId : String, category : String, teamListListener: AhlRepoImpl.AhlResponseListener)
}