package com.ahl.annahockeyleague.kotlin.kotlinfragments.kotlinHome

interface HomeRepo {

    suspend fun getHomePageData(tournamentId : String, category : String, responseListener: HomeRepoImpl.HomeResponseListener)

}