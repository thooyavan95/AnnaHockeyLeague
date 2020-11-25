package com.ahl.annahockeyleague.ui

import com.ahl.annahockeyleague.data.Category


interface AhlRepo {

    suspend fun fetchTournamentId()

    suspend fun fetchHomePageData(tournamentId : String, category : Category)

    suspend fun fetchTeamList(tournamentId : String, category : Category)
}