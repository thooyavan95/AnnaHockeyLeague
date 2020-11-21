package com.ahl.annahockeyleague.kotlin.kotlinfragments

import android.util.Log
import com.ahl.annahockeyleague.DataState
import com.ahl.annahockeyleague.kotlin.data.Fixtures
import com.ahl.annahockeyleague.kotlin.data.PointsTable
import com.ahl.annahockeyleague.kotlin.data.Team
import com.ahl.annahockeyleague.kotlin.data.TopScorers
import com.ahl.annahockeyleague.kotlin.network.RetrofitService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AhlRepoImpl : AhlRepo {

    override suspend fun getHomePageData(tournamentId: String, category: String, responseListener : AhlResponseListener) {

        Log.d("id", tournamentId)
        withContext(Dispatchers.IO) {
            launch {
                try {
                    responseListener.onFixturesResponseMen(DataState.RequestSent)
                    val response = RetrofitService.getInstance.getFixturesData(category, tournamentId)
                    if(category == "men"){
                        responseListener.onFixturesResponseMen(DataState.Success(response))
                    }else{
                        responseListener.onFixturesResponseWomen(DataState.Success(response))
                    }


                } catch (e: Exception) {
                    if(category == "men"){
                        responseListener.onFixturesResponseMen(DataState.Failure(e.message))
                    }else{
                        responseListener.onFixturesResponseWomen(DataState.Failure(e.message))
                    }

                }
            }

            launch {
                try {
                    val response = RetrofitService.getInstance.getPointsTableData(category, tournamentId)
                    if(category == "men"){
                        responseListener.onPointsMenResponse(DataState.Success(response))
                    }else{
                        responseListener.onPointsWomenResponse(DataState.Success(response))
                    }

                } catch (e: Exception) {
                    if(category == "men"){
                        responseListener.onPointsMenResponse(DataState.Failure(e.message))
                    }else{
                        responseListener.onPointsWomenResponse(DataState.Failure(e.message))
                    }

                }
            }

            launch {

                try {
                    val response = RetrofitService.getInstance.getTopScorersData(tournamentId, category)
                    if(category == "men"){
                        responseListener.onTopScoresMenResponse(DataState.Success(response))
                    }else{
                        responseListener.onTopScoresWomenResponse(DataState.Success(response))
                    }

                } catch (e: Exception) {
                    if(category == "men"){
                        responseListener.onTopScoresMenResponse(DataState.Failure(e.message))
                    }else{
                        responseListener.onTopScoresWomenResponse(DataState.Failure(e.message))
                    }

                }
            }

        }


    }


    override suspend fun getFixturesDatList(category: String, tournamentId : String, fixturesListener : AhlResponseListener) {
        withContext(Dispatchers.IO){

            try {
                val response = RetrofitService.getInstance.getFixturesData(category ,tournamentId)
                if(category == "men"){
                    fixturesListener.onFixturesResponseMen(DataState.Success(response))
                }else{
                    fixturesListener.onFixturesResponseWomen(DataState.Success(response))
                }

            }catch (e : java.lang.Exception){
                if(category == "men"){
                    fixturesListener.onFixturesResponseMen(DataState.Failure(e.message))
                }else{
                    fixturesListener.onFixturesResponseWomen(DataState.Failure(e.message))
                }

            }
        }

    }

    override suspend fun fetchTeamList(tournamentId: String, category: String, teamListListener: AhlResponseListener) {

        withContext(Dispatchers.IO){
            try {
                val response = RetrofitService.getInstance.getTeamsListData(tournamentId, category)
                if(category == "men"){
                    teamListListener.onTeamsMenResponse(DataState.Success(response))
                }else{
                    teamListListener.onTeamsWomenResponse(DataState.Success(response))
                }

            }catch (e : Exception){
                if(category == "men"){
                    teamListListener.onTeamsMenResponse(DataState.Failure(e.message))
                }else{
                    teamListListener.onTeamsWomenResponse(DataState.Failure(e.message))
                }
            }
        }

    }

        interface AhlResponseListener {

            fun onFixturesResponseMen(fixturesResponse : DataState<List<Fixtures>>)
            fun onFixturesResponseWomen(fixturesResponse : DataState<List<Fixtures>>)
            fun onPointsMenResponse(pointsTableResponse : DataState<List<PointsTable>>)
            fun onPointsWomenResponse(pointsTableResponse : DataState<List<PointsTable>>)
            fun onTopScoresMenResponse(topScorersResponse : DataState<List<TopScorers>>)
            fun onTopScoresWomenResponse(topScorersResponse : DataState<List<TopScorers>>)
            fun onTeamsMenResponse(teamsResponse : DataState<List<Team>>)
            fun onTeamsWomenResponse(teamsResponse : DataState<List<Team>>)

        }

}