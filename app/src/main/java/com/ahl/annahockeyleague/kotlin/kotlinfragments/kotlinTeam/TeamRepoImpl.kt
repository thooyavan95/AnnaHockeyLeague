package com.ahl.annahockeyleague.kotlin.kotlinfragments.kotlinTeam

import com.ahl.annahockeyleague.kotlin.DataState
import com.ahl.annahockeyleague.kotlin.network.RetrofitService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TeamRepoImpl : TeamRepo {

    override suspend fun fetchTeamList(tournamentId: String, category: String, teamListListener: TeamListListener) {

        withContext(Dispatchers.IO){
            try {
                val response = RetrofitService.getInstance.getTeamsListData(tournamentId, category)
                teamListListener.onTeamList(DataState.Success(response))
            }catch (e : Exception){
                teamListListener.onTeamList(DataState.Failure(e.message))
            }
        }

    }
}

interface TeamListListener{
    fun onTeamList(response : DataState<List<com.ahl.annahockeyleague.kotlin.data.Team>>)
}