package com.ahl.annahockeyleague.kotlin.kotlinfragments

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahl.annahockeyleague.AhlApplication
import com.ahl.annahockeyleague.kotlin.DataState
import com.ahl.annahockeyleague.kotlin.data.*
import com.ahl.annahockeyleague.kotlin.network.RetrofitService
import com.jakewharton.rxrelay2.BehaviorRelay
import com.jakewharton.rxrelay2.PublishRelay
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


const val TAG = "ahlData"
class AhlViewModel : ViewModel() {


    private val networkStream = PublishRelay.create<DataState>()
    private lateinit var disposable : Disposable

    val ahlDataStream = BehaviorRelay.createDefault(AhlData())

    private val ahlRepoImpl = AhlRepoImpl(networkStream)

    fun getAhlData(){

        viewModelScope.launch(Dispatchers.IO) {
            fetchTournamentId()
            fetchHomePageData()
            fetchTeamList()
        }

        getData()

    }

    private suspend fun fetchTournamentId() {

        val tournament = RetrofitService.getInstance.getTournamentId()
        AhlApplication.tournamentId = tournament.id.toString()
    }

    private fun getData(){

        disposable = networkStream.observeOn(Schedulers.io()).subscribe{

            when(it){

                is DataState.Success ->{

                    val datum = it.data
                    val ahlUpdatedData : AhlData = when(datum){

                        is Fixtures ->{

                            if (datum[0].category == "men"){

                                val fixturesLoaderData = ahlDataStream.value!!.loaderData.copy(fixturesForMen = UIState.SHOW_CONTENT)
                                ahlDataStream.value!!.copy(fixturesMen = datum, loaderData = fixturesLoaderData)

                            }else{

                                val fixturesLoaderData = ahlDataStream.value!!.loaderData.copy(fixturesForWomen = UIState.SHOW_CONTENT)
                                ahlDataStream.value!!.copy(fixturesWoMen = datum, loaderData = fixturesLoaderData)

                            }

                        }

                        is Teams ->{

                            if(datum[0].category == "men"){
                                val teamsLoaderData = ahlDataStream.value!!.loaderData.copy(teamsForMen = UIState.SHOW_CONTENT)
                                ahlDataStream.value!!.copy(teamsMen = datum, loaderData = teamsLoaderData)
                            }else{
                                val teamsLoaderData = ahlDataStream.value!!.loaderData.copy(teamsForWomen = UIState.SHOW_CONTENT)
                                ahlDataStream.value!!.copy(teamsWoMen = datum, loaderData = teamsLoaderData)
                            }

                        }

                        is PointsTable -> {
                            if(datum[0].category == "men"){
                                ahlDataStream.value!!.loaderData.copy(pointsTableForMen = UIState.SHOW_CONTENT)
                                ahlDataStream.value!!.copy(pointsTableMen = datum)
                            }else{
                                ahlDataStream.value!!.loaderData.copy(pointsTableForWomen = UIState.SHOW_CONTENT)
                                ahlDataStream.value!!.copy(pointsTableWoMen = datum)
                            }
                        }

                        is TopScorers -> {
                            if(datum[0].category == "men"){
                                ahlDataStream.value!!.loaderData.copy(topScorersForMen = UIState.SHOW_CONTENT)
                                ahlDataStream.value!!.copy(topScorersMen = datum)
                            }else{
                                ahlDataStream.value!!.loaderData.copy(topScorersForWomen = UIState.SHOW_CONTENT)
                                ahlDataStream.value!!.copy(topScorersWoMen = datum)
                            }
                        }

                        else -> ahlDataStream.value!!
                    }

                    ahlDataStream.accept(ahlUpdatedData)
                }

                is DataState.Failure ->{

                    when(it.action){

                        Action.FixturesForMen -> ahlDataStream.value!!.loaderData.copy(fixturesForMen = UIState.SHOW_ERROR)

                        Action.FixturesForWomen -> ahlDataStream.value!!.loaderData.copy(fixturesForWomen = UIState.SHOW_ERROR)

                        Action.TeamsForMen -> ahlDataStream.value!!.loaderData.copy(teamsForMen = UIState.SHOW_ERROR)

                        Action.TeamsForWomen -> ahlDataStream.value!!.loaderData.copy(teamsForWomen = UIState.SHOW_ERROR)

                        Action.TopScorersForWomen -> ahlDataStream.value!!.loaderData.copy(topScorersForWomen = UIState.SHOW_ERROR)

                        Action.TopScorersForMen -> ahlDataStream.value!!.loaderData.copy(topScorersForMen = UIState.SHOW_ERROR)

                        Action.PointsTableForMen -> ahlDataStream.value!!.loaderData.copy(pointsTableForMen = UIState.SHOW_ERROR)

                        Action.PointsTableForWomen -> ahlDataStream.value!!.loaderData.copy(pointsTableForWomen = UIState.SHOW_ERROR)
                    }


                }

            }

        }
    }

    private fun fetchHomePageData(){

        viewModelScope.launch {
            ahlRepoImpl.getHomePageData( category = "men" ,tournamentId = AhlApplication.tournamentId)

            launch {
                ahlRepoImpl.getHomePageData(AhlApplication.tournamentId, "women")
            }
        }

    }


    private fun fetchTeamList(){
        viewModelScope.launch {
            ahlRepoImpl.fetchTeamList(AhlApplication.tournamentId, "men")
        }

        viewModelScope.launch {
            ahlRepoImpl.fetchTeamList(AhlApplication.tournamentId, "women")
        }
    }

    override fun onCleared() {
        super.onCleared()
        if(!disposable.isDisposed){
            disposable.dispose()
        }
    }

}