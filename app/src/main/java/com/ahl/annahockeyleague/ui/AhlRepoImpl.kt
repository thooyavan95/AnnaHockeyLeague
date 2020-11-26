package com.ahl.annahockeyleague.ui

import com.ahl.annahockeyleague.data.DataState
import com.ahl.annahockeyleague.data.DataFailedAction
import com.ahl.annahockeyleague.data.Category
import com.ahl.annahockeyleague.network.RetrofitService
import com.jakewharton.rxrelay2.PublishRelay
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AhlRepoImpl(private val networkStream : PublishRelay<DataState>, private val tournamentListener: TournamentListener) : AhlRepo {


    override suspend fun fetchTournamentId() {

        tournamentListener.onTournamentIdResponse(DataState.RequestSent)

            try {
                val tournament = RetrofitService.getInstance.getTournamentId()
                tournamentListener.onTournamentIdResponse(DataState.Success(tournament.id))
            }
            catch(e : Exception){
                tournamentListener.onTournamentIdResponse(DataState.Failure(DataFailedAction.TOURNAMENT, e.message))
            }

    }

    override suspend fun fetchHomePageData(tournamentId: String, category: Category) {

        withContext(Dispatchers.IO) {

            launch {
                getAsyncFixturesData(category, tournamentId)
            }

            launch {
                getAsyncPointsData(category, tournamentId)
            }

            launch {
                getAsyncTopScorersData(category, tournamentId)
            }

        }

    }



    override suspend fun fetchTeamList(tournamentId: String, category: Category) {

        withContext(Dispatchers.IO) {
                getTeamData(category, tournamentId)
        }

    }

    private suspend fun getAsyncFixturesData(category : Category, tournamentId: String) {

        try {
            val response = RetrofitService.getInstance.getFixturesData(category.gender, tournamentId)

            response.map {
                it.category = category
            }

            networkStream.accept(DataState.Success(response))

        } catch (e: Exception) {
            if (category == Category.MEN) {
                networkStream.accept(DataState.Failure(DataFailedAction.FIXTURES_MEN, e.message))
            } else {
                networkStream.accept(DataState.Failure(DataFailedAction.FIXTURES_WOMEN, e.message))
            }

        }
    }

    private suspend fun getAsyncPointsData(category: Category, tournamentId: String) {

        try {
            val response = RetrofitService.getInstance.getPointsTableData(category.gender, tournamentId)

            response.map {
                it.category = category
            }

            networkStream.accept(DataState.Success(response))
        } catch (e: Exception) {
            if (category == Category.MEN) {
                networkStream.accept(DataState.Failure(DataFailedAction.POINTS_TABLE_MEN, e.message))
            } else {
                networkStream.accept(DataState.Failure(DataFailedAction.POINTS_TABLE_WOMEN, e.message))
            }

        }
    }

    private suspend fun getAsyncTopScorersData(category: Category, tournamentId: String) {

        try {
            val response = RetrofitService.getInstance.getTopScorersData(tournamentId, category.gender)

            response.map {
                it.category = category
            }

            networkStream.accept(DataState.Success(response))

        } catch (e: Exception) {
            if (category == Category.MEN) {
                networkStream.accept(DataState.Failure(DataFailedAction.TOP_SCORERS_MEN, e.message))
            } else {
                networkStream.accept(DataState.Failure(DataFailedAction.TOP_SCORERS_WOMEN, e.message))
            }

        }

    }

    private suspend fun getTeamData(category: Category, tournamentId: String){

        try {
            val response = RetrofitService.getInstance.getTeamsListData(tournamentId, category.gender)

            response.map {
                it.category = category
            }

            networkStream.accept(DataState.Success(response))

        } catch (e: Exception) {
            if (category == Category.MEN) {
                networkStream.accept(DataState.Failure(DataFailedAction.TEAMS_MEN, e.message))
            } else {
                networkStream.accept(DataState.Failure(DataFailedAction.TEAMS_WOMEN, e.message))
            }
        }
    }

    interface TournamentListener{
        fun onTournamentIdResponse(tournamentId: Any)
    }

}