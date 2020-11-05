package com.ahl.annahockeyleague.kotlin.network

import com.ahl.annahockeyleague.Entity.Tournament
import com.ahl.annahockeyleague.kotlin.data.Fixtures
import com.ahl.annahockeyleague.kotlin.data.PointsTable
import com.ahl.annahockeyleague.kotlin.data.Team
import com.ahl.annahockeyleague.kotlin.data.TopScorers
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("api/tournament")
    suspend fun getTournamentId(@Query ("season") s : String = "2020", @Query("type") type : String = "AHL") : Tournament

    @GET("api/matches")
    suspend fun getFixturesData(@Query("category") category : String, @Query ("tournament") tournamentId : String) : List<Fixtures>


    @GET("api/topscorers/{tournament}")
    suspend fun getTopScorersData(@Path ("tournament") tournamentId : String, @Query("category") category : String,
                                  @Query("count") numberOfPositions : String = "3") : List<TopScorers>

    @GET("api/points")
    suspend fun getPointsTableData(@Query("category") category : String, @Query ("tournament") tournamentId : String) : List<PointsTable>

    @GET("api/teams")
    suspend fun getTeamsListData(@Query("tournament") tournamentId : String, @Query("category") category : String) : List<Team>

}