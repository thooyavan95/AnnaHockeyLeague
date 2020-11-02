package com.ahl.annahockeyleague.kotlin.kotlinfragments.kotlinFixtures

import com.ahl.annahockeyleague.kotlin.DataState
import com.ahl.annahockeyleague.kotlin.data.Fixtures
import com.ahl.annahockeyleague.kotlin.network.RetrofitService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class RepoImpl : Repo {


    override suspend fun getFixturesDatList(category: String, tournamentId : String, fixturesListener: FixturesListener) {
     withContext(Dispatchers.IO){

         try {
             val response = RetrofitService.getInstance.getFixturesData(category ,tournamentId)
             fixturesListener.onFixturesResponse(DataState.Success(response))

         }catch (e : Exception){
             fixturesListener.onFixturesResponse(DataState.Failure(e.message))
         }
     }

    }
}

interface FixturesListener{
    fun onFixturesResponse(response : DataState<List<Fixtures>>)
}