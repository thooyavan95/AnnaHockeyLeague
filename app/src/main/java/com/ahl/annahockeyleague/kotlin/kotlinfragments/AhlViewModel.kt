package com.ahl.annahockeyleague.kotlin.kotlinfragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahl.annahockeyleague.AhlApplication
import com.ahl.annahockeyleague.DataState
import com.ahl.annahockeyleague.UIState
import com.ahl.annahockeyleague.kotlin.data.Fixtures
import com.ahl.annahockeyleague.kotlin.data.PointsTable
import com.ahl.annahockeyleague.kotlin.data.Team
import com.ahl.annahockeyleague.kotlin.data.TopScorers
import com.ahl.annahockeyleague.kotlin.network.RetrofitService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AhlViewModel(private val ahlRepoImpl: AhlRepoImpl) : ViewModel(), AhlRepoImpl.AhlResponseListener {

    private val _previousMatchMenMutableLiveData = MutableLiveData<UIState<Fixtures>>()
    private val _nextMatchMenMutableLiveData = MutableLiveData<UIState<Fixtures>>()
    private val _pointsTableMenMutableLiveData = MutableLiveData<UIState<List<PointsTable>>>()
    private val _topScoresMenMutableLiveData = MutableLiveData<UIState<List<TopScorers>>>()

    private val _previousMatchWomenMutableLiveData = MutableLiveData<UIState<Fixtures>>()
    private val _nextMatchWomenMutableLiveData = MutableLiveData<UIState<Fixtures>>()
    private val _pointsTableWomenMutableLiveData = MutableLiveData<UIState<List<PointsTable>>>()
    private val _topScoresWomenMutableLiveData = MutableLiveData<UIState<List<TopScorers>>>()


    val previousMatchMenLiveData : LiveData<UIState<Fixtures>>
        get() = _previousMatchMenMutableLiveData

    val nextMatchMenLiveData : LiveData<UIState<Fixtures>>
        get() = _nextMatchMenMutableLiveData

    val pointsTableMenLiveData : LiveData<UIState<List<PointsTable>>>
        get() = _pointsTableMenMutableLiveData

    val topScoresMenLiveData : LiveData<UIState<List<TopScorers>>>
        get() = _topScoresMenMutableLiveData



    val previousMatchWomenLiveData : LiveData<UIState<Fixtures>>
        get() = _previousMatchWomenMutableLiveData

    val nextMatchWomenLiveData : LiveData<UIState<Fixtures>>
        get() = _nextMatchWomenMutableLiveData

    val pointsTableWomenLiveData : LiveData<UIState<List<PointsTable>>>
        get() = _pointsTableWomenMutableLiveData

    val topScoresWomenLiveData : LiveData<UIState<List<TopScorers>>>
        get() = _topScoresWomenMutableLiveData

    private val _fixturesListMenMutableLiveData = MutableLiveData<UIState<List<Fixtures>>>()

    val fixturesMenListLiveData : LiveData<UIState<List<Fixtures>>>
        get() = _fixturesListMenMutableLiveData


    private val _fixturesListWomenMutableLiveData = MutableLiveData<UIState<List<Fixtures>>>()

    val fixturesListWomenLiveData : LiveData<UIState<List<Fixtures>>>
        get() = _fixturesListWomenMutableLiveData


    private val _teamMenMutableLiveData = MutableLiveData<UIState<List<Team>>>()

    val teamMenListLiveData : LiveData<UIState<List<Team>>>
        get() = _teamMenMutableLiveData


    private val _teamWomenMutableLiveData = MutableLiveData<UIState<List<Team>>>()

    val teamWomenListLiveData : LiveData<UIState<List<Team>>>
        get() = _teamWomenMutableLiveData

    fun getAhlData(category: String){

        viewModelScope.launch(Dispatchers.IO) {
            fetchTournamentId()
            fetchData(category)
        }
    }

    private suspend fun fetchTournamentId() {

        val tournament = RetrofitService.getInstance.getTournamentId()
        AhlApplication.tournamentId = tournament.id.toString()
    }


    override fun onFixturesResponseMen(fixturesResponse: DataState<List<Fixtures>>) {
        when(fixturesResponse){

            is DataState.Success ->{
                val previousMatchDetails = getPreviousMatchDetails(fixturesResponse.data)
                val nextMatchDetails = getNextMatchDetails(fixturesResponse.data)
                _previousMatchMenMutableLiveData.postValue(UIState.DataAvailable(previousMatchDetails!!))
                _nextMatchMenMutableLiveData.postValue(UIState.DataAvailable(nextMatchDetails!!))
                _fixturesListMenMutableLiveData.postValue(UIState.DataAvailable(fixturesResponse.data))

            }

            is DataState.Failure ->{
                _previousMatchMenMutableLiveData.postValue(UIState.Error(fixturesResponse.errorMessage))
                _nextMatchMenMutableLiveData.postValue(UIState.Error(fixturesResponse.errorMessage))
                _fixturesListMenMutableLiveData.postValue(UIState.Error(fixturesResponse.errorMessage))
            }
        }
    }

    override fun onFixturesResponseWomen(fixturesResponse: DataState<List<Fixtures>>) {
        when(fixturesResponse){

            is DataState.Success ->{
                val previousMatchDetails = getPreviousMatchDetails(fixturesResponse.data)
                val nextMatchDetails = getNextMatchDetails(fixturesResponse.data)
                _previousMatchWomenMutableLiveData.postValue(UIState.DataAvailable(previousMatchDetails!!))
                _nextMatchWomenMutableLiveData.postValue(UIState.DataAvailable(nextMatchDetails!!))
                _fixturesListWomenMutableLiveData.postValue(UIState.DataAvailable(fixturesResponse.data))

            }

            is DataState.Failure ->{
                _previousMatchWomenMutableLiveData.postValue(UIState.Error(fixturesResponse.errorMessage))
                _nextMatchWomenMutableLiveData.postValue(UIState.Error(fixturesResponse.errorMessage))
                _fixturesListWomenMutableLiveData.postValue(UIState.Error(fixturesResponse.errorMessage))
            }
        }
    }

    override fun onPointsMenResponse(pointsTableResponse: DataState<List<PointsTable>>) {
        when(pointsTableResponse){

            is DataState.Success -> _pointsTableMenMutableLiveData.postValue(UIState.DataAvailable(pointsTableResponse.data))

            is DataState.Failure -> _pointsTableMenMutableLiveData.postValue(UIState.Error(pointsTableResponse.errorMessage))
        }
    }

    override fun onPointsWomenResponse(pointsTableResponse: DataState<List<PointsTable>>) {
        when(pointsTableResponse){

            is DataState.Success -> _pointsTableWomenMutableLiveData.postValue(UIState.DataAvailable(pointsTableResponse.data))

            is DataState.Failure -> _pointsTableWomenMutableLiveData.postValue(UIState.Error(pointsTableResponse.errorMessage))
        }
    }

    override fun onTopScoresMenResponse(topScorersResponse: DataState<List<TopScorers>>) {
        when(topScorersResponse){

            is DataState.Success -> _topScoresMenMutableLiveData.postValue(UIState.DataAvailable(topScorersResponse.data))

            is DataState.Failure -> _topScoresMenMutableLiveData.postValue(UIState.Error(topScorersResponse.errorMessage))
        }
    }

    override fun onTopScoresWomenResponse(topScorersResponse: DataState<List<TopScorers>>) {
        when(topScorersResponse){

            is DataState.Success -> _topScoresWomenMutableLiveData.postValue(UIState.DataAvailable(topScorersResponse.data))

            is DataState.Failure -> _topScoresWomenMutableLiveData.postValue(UIState.Error(topScorersResponse.errorMessage))
        }
    }

    override fun onTeamsMenResponse(teamsResponse: DataState<List<Team>>) {
        when(teamsResponse){

            is DataState.Success -> _teamMenMutableLiveData.postValue(UIState.DataAvailable(teamsResponse.data))

            is DataState.Failure -> _teamMenMutableLiveData.postValue(UIState.Error(teamsResponse.errorMessage))
        }
    }

    override fun onTeamsWomenResponse(teamsResponse: DataState<List<Team>>) {
        when(teamsResponse){

            is DataState.Success -> _teamWomenMutableLiveData.postValue(UIState.DataAvailable(teamsResponse.data))

            is DataState.Failure -> _teamWomenMutableLiveData.postValue(UIState.Error(teamsResponse.errorMessage))
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
            ahlRepoImpl.getHomePageData( category = category ,tournamentId = AhlApplication.tournamentId, responseListener = this@AhlViewModel)
        }

    }


//    fun fetchFixturesList(category: String, tournamentId : String){
//        viewModelScope.launch {
//            repoImpl.getFixturesDatList(category, tournamentId, this@KotlinFixturesViewModel)
//        }
//
//    }


    fun fetchTeamList(category: String){
        viewModelScope.launch {
            ahlRepoImpl.fetchTeamList(AhlApplication.tournamentId, category, this@AhlViewModel)
        }
    }

}