package com.ahl.annahockeyleague.kotlin.kotlinfragments.kotlinTeam

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahl.annahockeyleague.AhlApplication
import com.ahl.annahockeyleague.kotlin.DataState
import com.ahl.annahockeyleague.kotlin.UIState
import com.ahl.annahockeyleague.kotlin.data.Team
import kotlinx.coroutines.launch

class KotlinTeamViewModel(private val teamRepoImpl: TeamRepoImpl) : ViewModel(), TeamListListener {

    private val _teamMutableLiveData = MutableLiveData<UIState<List<Team>>>()

    val teamListLiveData : LiveData<UIState<List<Team>>>
        get() = _teamMutableLiveData

    override fun onTeamList(response: DataState<List<Team>>) {

        when(response){

            is DataState.Success -> _teamMutableLiveData.postValue(UIState.DataAvailable(response.data))

            is DataState.Failure -> _teamMutableLiveData.postValue(UIState.Error(response.errorMessage))
        }

    }

    fun fetchTeamList(category: String){
        viewModelScope.launch {
                teamRepoImpl.fetchTeamList(AhlApplication.tournamentId, category, this@KotlinTeamViewModel)
        }
    }

}