package com.ahl.annahockeyleague.kotlin.kotlinfragments

import android.util.Log
import com.ahl.annahockeyleague.kotlin.DataState
import com.ahl.annahockeyleague.kotlin.data.Action
import com.ahl.annahockeyleague.kotlin.data.LoaderData
import com.ahl.annahockeyleague.kotlin.network.RetrofitService
import com.jakewharton.rxrelay2.PublishRelay
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AhlRepoImpl(private val networkStream : PublishRelay<DataState>) : AhlRepo {


    override suspend fun getHomePageData(tournamentId: String, category: String) {

        Log.d("id", tournamentId)
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



    override suspend fun fetchTeamList(tournamentId: String, category: String) {

        withContext(Dispatchers.IO) {
                getTeamData(category, tournamentId)
        }

    }

    private suspend fun getAsyncFixturesData(category: String, tournamentId: String) {

        try {
            val response = RetrofitService.getInstance.getFixturesData(category, tournamentId)

            response.map {
                it.category = category
            }

            networkStream.accept(DataState.Success(response))

        } catch (e: Exception) {
            if (category == "men") {
                networkStream.accept(DataState.Failure(Action.FixturesForMen, e.message))
            } else {
                networkStream.accept(DataState.Failure(Action.FixturesForWomen, e.message))
            }

        }
    }

    private suspend fun getAsyncPointsData(category: String, tournamentId: String) {

        try {
            val response = RetrofitService.getInstance.getPointsTableData(category, tournamentId)

            response.map {
                it.category = category
            }

            networkStream.accept(DataState.Success(response))
        } catch (e: Exception) {
            if (category == "men") {
                networkStream.accept(DataState.Failure(Action.PointsTableForMen, e.message))
            } else {
                networkStream.accept(DataState.Failure(Action.PointsTableForWomen, e.message))
            }

        }
    }

    private suspend fun getAsyncTopScorersData(category: String, tournamentId: String) {

        try {
            val response = RetrofitService.getInstance.getTopScorersData(tournamentId, category)

            response.map {
                it.category = category
            }

            networkStream.accept(DataState.Success(response))

        } catch (e: Exception) {
            if (category == "men") {
                networkStream.accept(DataState.Failure(Action.TopScorersForMen, e.message))
            } else {
                networkStream.accept(DataState.Failure(Action.TopScorersForWomen, e.message))
            }

        }

    }

    private suspend fun getTeamData(category: String, tournamentId: String){

        try {
            val response = RetrofitService.getInstance.getTeamsListData(tournamentId, category)

            response.map {
                it.category = category
            }

            networkStream.accept(DataState.Success(response))

        } catch (e: Exception) {
            if (category == "men") {
                networkStream.accept(DataState.Failure(Action.TeamsForMen, e.message))
            } else {
                networkStream.accept(DataState.Failure(Action.TeamsForWomen, e.message))
            }
        }
    }
}