package com.ahl.annahockeyleague.kotlin.kotlinfragments.kotlinHome

import android.provider.ContactsContract
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahl.annahockeyleague.AhlApplication
import com.ahl.annahockeyleague.AhlConfig.AhlConstants
import com.ahl.annahockeyleague.kotlin.DataState
import com.ahl.annahockeyleague.kotlin.UIState
import com.ahl.annahockeyleague.kotlin.data.Fixtures
import com.ahl.annahockeyleague.kotlin.data.PointsTable
import com.ahl.annahockeyleague.kotlin.data.TopScorers
import com.ahl.annahockeyleague.kotlin.network.RetrofitService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class KotlinHomeViewModel(private val homeRepoImpl: HomeRepoImpl) : ViewModel(), HomeRepoImpl.HomeResponseListener {

    init {

        viewModelScope.launch(Dispatchers.IO) {
            fetchTournamentId()
            fetchData("men")
        }
        
    }

    private suspend fun fetchTournamentId() {

            val tournament = RetrofitService.getInstance.getTournamentId()
            AhlApplication.tournamentId = tournament.id.toString()

    }

    private val _previousMatchMutableLiveData = MutableLiveData<UIState<Fixtures>>()
    private val _nextMatchMutableLiveData = MutableLiveData<UIState<Fixtures>>()
    private val _pointsTableMutableLiveData = MutableLiveData<UIState<List<PointsTable>>>()
    private val _topScoresMutableLiveData = MutableLiveData<UIState<List<TopScorers>>>()

    val previousMatchLiveData : LiveData<UIState<Fixtures>>
    get() = _previousMatchMutableLiveData

    val nextMatchLiveData : LiveData<UIState<Fixtures>>
    get() = _nextMatchMutableLiveData

    val pointsTableLiveData : LiveData<UIState<List<PointsTable>>>
    get() = _pointsTableMutableLiveData

    val topScoresLiveData : LiveData<UIState<List<TopScorers>>>
    get() = _topScoresMutableLiveData


    override fun onFixturesDataResponse(fixtures: DataState<List<Fixtures>>) {

        when(fixtures){

            is DataState.RequestSent ->{
                _previousMatchMutableLiveData.postValue(UIState.Loading)
            }

            is DataState.Success ->{
                    val previousMatchDetails = getPreviousMatchDetails(fixtures.data)
                    val nextMatchDetails = getNextMatchDetails(fixtures.data)
                _previousMatchMutableLiveData.postValue(UIState.DataAvailable(previousMatchDetails!!))
                _nextMatchMutableLiveData.postValue(UIState.DataAvailable(nextMatchDetails!!))
            }

            is DataState.Failure ->{
                _previousMatchMutableLiveData.postValue(UIState.Error(fixtures.errorMessage))
            }

        }
    }

    override fun onPointsResponse(pointsTable: DataState<List<PointsTable>>) {
        when(pointsTable){

            is DataState.Success ->{
                _pointsTableMutableLiveData.postValue(UIState.DataAvailable(pointsTable.data))

            }

            is DataState.Failure->{
                _pointsTableMutableLiveData.postValue(UIState.Error(pointsTable.errorMessage))
            }

        }

    }

    override fun onTopScoresResponse(topScorers: DataState<List<TopScorers>>) {

        when(topScorers){

            is DataState.Success ->{
                _topScoresMutableLiveData.postValue(UIState.DataAvailable(topScorers.data))
            }

            is DataState.Failure ->{
                _topScoresMutableLiveData.postValue(UIState.Error(topScorers.errorMessage))
            }

        }

    }

    private fun getPreviousMatchDetails(fixturesList: List<Fixtures>) : Fixtures? {

         return fixturesList.sortedByDescending { it.matchDateTime }  // sorts the list in descending order
                 .find { it.status == "COMPLETED"}                    // finds the first item with status completed

    }

    private fun getNextMatchDetails(fixturesList: List<Fixtures>): Fixtures? {
        return fixturesList.sortedBy { it.matchDateTime }
                .find { it.status == "UPCOMING" }
    }


    private fun fetchData(category : String){

        viewModelScope.launch(Dispatchers.Main) {
                homeRepoImpl.getHomePageData( category = category ,tournamentId = AhlApplication.tournamentId, responseListener = this@KotlinHomeViewModel)
        }

    }

}