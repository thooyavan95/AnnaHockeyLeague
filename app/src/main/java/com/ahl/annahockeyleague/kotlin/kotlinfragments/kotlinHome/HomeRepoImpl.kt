package com.ahl.annahockeyleague.kotlin.kotlinfragments.kotlinHome

import android.util.Log
import com.ahl.annahockeyleague.AhlConfig.AhlConstants
import com.ahl.annahockeyleague.kotlin.DataState
import com.ahl.annahockeyleague.kotlin.data.Fixtures
import com.ahl.annahockeyleague.kotlin.data.PointsTable
import com.ahl.annahockeyleague.kotlin.data.TopScorers
import com.ahl.annahockeyleague.kotlin.network.RetrofitService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeRepoImpl() : HomeRepo {


    override suspend fun getHomePageData(tournamentId: String, category: String, responseListener: HomeResponseListener) {

                 withContext(Dispatchers.IO){
                     launch {
                         try{
                             responseListener.onFixturesDataResponse(DataState.RequestSent)
                             val response = RetrofitService.getInstance.getFixturesData( category, tournamentId)
                             responseListener.onFixturesDataResponse(DataState.Success(response))

                         }catch (e : Exception){
                             responseListener.onFixturesDataResponse(DataState.Failure(e.message))

                         }
                     }

                     launch {
                         try {
                             val response = RetrofitService.getInstance.getPointsTableData(category, tournamentId)
                             responseListener.onPointsResponse(DataState.Success(response))
                         }catch (e : Exception){
                             responseListener.onPointsResponse(DataState.Failure(e.message))
                         }
                     }

                     launch {

                         try {
                             val response = RetrofitService.getInstance.getTopScorersData(tournamentId, category)
                             responseListener.onTopScoresResponse(DataState.Success(response))
                         }catch (e : Exception){
                             responseListener.onTopScoresResponse(DataState.Failure(e.message))
                         }
                     }

                }

    }

    interface HomeResponseListener{
        fun onFixturesDataResponse(fixtures : DataState<List<Fixtures>>)

        fun onPointsResponse(pointsTable: DataState<List<PointsTable>>)

        fun onTopScoresResponse(topScorers: DataState<List<TopScorers>>)

    }



}