package com.ahl.annahockeyleague.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahl.annahockeyleague.data.DataState
import com.ahl.annahockeyleague.data.*
import com.jakewharton.rxrelay2.BehaviorRelay
import com.jakewharton.rxrelay2.PublishRelay
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.bson.types.ObjectId


const val TAG = "ahlData"
class AhlViewModel : ViewModel(), AhlRepoImpl.TournamentListener {

    private val _tournamentStateMLD = MutableLiveData<UIState>()
    private val networkStream = PublishRelay.create<DataState>()
    private lateinit var disposable : Disposable

    val tournamentLiveData : LiveData<UIState>
        get() = _tournamentStateMLD
    val ahlDataStream = BehaviorRelay.createDefault(AhlData())

    private val ahlRepoImpl = AhlRepoImpl(networkStream, this)


    override fun onTournamentIdResponse(tournamentId: Any) {
        when(tournamentId){

            is DataState.RequestSent -> _tournamentStateMLD.postValue(UIState.SHOW_LOADER)

                is DataState.Success -> {

                    _tournamentStateMLD.postValue(UIState.SHOW_CONTENT)
                    val tournamentString = tournamentId.data as ObjectId
                    fetchHomePageData(tournamentString.toString())
                    fetchTeamList(tournamentString.toString())
                }

                is DataState.Failure -> _tournamentStateMLD.postValue(UIState.SHOW_ERROR)
        }
    }

    fun getAhlData(){

        viewModelScope.launch(Dispatchers.IO) {
            ahlRepoImpl.fetchTournamentId()
        }

        getData()

    }


    private fun getData(){

        disposable = networkStream.observeOn(Schedulers.io()).subscribe{

            when(it){

                is DataState.Success ->{

                    val datum = it.data
                    val ahlUpdatedData : AhlData = when(datum){

                        is Fixtures ->{

                            if (datum[0].category == Category.MEN){

                                val fixturesLoaderData = ahlDataStream.value!!.loaderData.copy(fixturesForMen = UIState.SHOW_CONTENT)
                                ahlDataStream.value!!.copy(fixturesMen = datum, loaderData = fixturesLoaderData)

                            }else{

                                val fixturesLoaderData = ahlDataStream.value!!.loaderData.copy(fixturesForWomen = UIState.SHOW_CONTENT)
                                ahlDataStream.value!!.copy(fixturesWoMen = datum, loaderData = fixturesLoaderData)

                            }

                        }

                        is Teams ->{

                            if(datum[0].category == Category.MEN){
                                val teamsLoaderData = ahlDataStream.value!!.loaderData.copy(teamsForMen = UIState.SHOW_CONTENT)
                                ahlDataStream.value!!.copy(teamsMen = datum, loaderData = teamsLoaderData)
                            }else{
                                val teamsLoaderData = ahlDataStream.value!!.loaderData.copy(teamsForWomen = UIState.SHOW_CONTENT)
                                ahlDataStream.value!!.copy(teamsWoMen = datum, loaderData = teamsLoaderData)
                            }

                        }

                        is PointsTable -> {
                            if(datum[0].category == Category.MEN){
                                val pointsLoaderData = ahlDataStream.value!!.loaderData.copy(pointsTableForMen = UIState.SHOW_CONTENT)
                                ahlDataStream.value!!.copy(loaderData = pointsLoaderData, pointsTableMen = datum)
                            }else{
                                val pointsLoaderData = ahlDataStream.value!!.loaderData.copy(pointsTableForWomen = UIState.SHOW_CONTENT)
                                ahlDataStream.value!!.copy(loaderData = pointsLoaderData, pointsTableWoMen = datum)
                            }
                        }

                        is TopScorers -> {
                            if(datum[0].category == Category.MEN){
                                val topScorersLoaderData = ahlDataStream.value!!.loaderData.copy(topScorersForMen = UIState.SHOW_CONTENT)
                                ahlDataStream.value!!.copy(loaderData = topScorersLoaderData, topScorersMen = datum)
                            }else{
                                val topScorersLoaderData = ahlDataStream.value!!.loaderData.copy(topScorersForWomen = UIState.SHOW_CONTENT)
                                ahlDataStream.value!!.copy(loaderData = topScorersLoaderData, topScorersWoMen = datum)
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

    private fun fetchHomePageData(tournamentId: String){

        viewModelScope.launch {
            ahlRepoImpl.fetchHomePageData( category = Category.MEN ,tournamentId = tournamentId)

            launch {
                ahlRepoImpl.fetchHomePageData(tournamentId, Category.WOMEN)
            }
        }

    }


    private fun fetchTeamList(tournamentId: String){
        viewModelScope.launch {
            ahlRepoImpl.fetchTeamList(tournamentId, Category.MEN)
        }

        viewModelScope.launch {
            ahlRepoImpl.fetchTeamList(tournamentId, Category.WOMEN)
        }
    }

    override fun onCleared() {
        super.onCleared()
        if(!disposable.isDisposed){
            disposable.dispose()
        }
    }


}