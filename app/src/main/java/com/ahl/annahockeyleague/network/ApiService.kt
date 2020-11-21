package com.ahl.annahockeyleague.network

import com.ahl.annahockeyleague.data.*
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("api/tournament")
    suspend fun getTournamentId(@Query ("season") s : String = "2020", @Query("type") type : String = "AHL") : Tournament

    @GET("api/matches")
    suspend fun getFixturesData(@Query("category") category : String, @Query ("tournament") tournamentId : String)
            : Fixtures


    @GET("api/topscorers/{tournament}")
    suspend fun getTopScorersData(@Path ("tournament") tournamentId : String, @Query("category") category : String,
                                  @Query("count") numberOfPositions : String = "3") : TopScorers

    @GET("api/points")
    suspend fun getPointsTableData(@Query("category") category : String, @Query ("tournament") tournamentId : String)
            : PointsTable

    @GET("api/teams")
    suspend fun getTeamsListData(@Query("tournament") tournamentId : String, @Query("category") category : String)
            : Teams

}