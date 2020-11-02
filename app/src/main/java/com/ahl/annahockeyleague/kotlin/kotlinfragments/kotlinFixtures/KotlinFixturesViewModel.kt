package com.ahl.annahockeyleague.kotlin.kotlinfragments.kotlinFixtures

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahl.annahockeyleague.kotlin.DataState
import com.ahl.annahockeyleague.kotlin.UIState
import com.ahl.annahockeyleague.kotlin.data.Fixtures
import kotlinx.coroutines.launch

class KotlinFixturesViewModel(private val repoImpl: RepoImpl) : ViewModel(), FixturesListener {

    private val _fixturesListMutableLiveData = MutableLiveData<UIState<List<Fixtures>>>()

    val fixturesListLiveData : LiveData<UIState<List<Fixtures>>>
        get() = _fixturesListMutableLiveData

    override fun onFixturesResponse(response: DataState<List<Fixtures>>) {

        when(response){
            is DataState.Success -> _fixturesListMutableLiveData.postValue(UIState.DataAvailable(response.data))

            is DataState.Failure -> _fixturesListMutableLiveData.postValue(UIState.Error(response.errorMessage))
        }

    }

    fun fetchFixturesList(category: String, tournamentId : String){
        viewModelScope.launch {
            repoImpl.getFixturesDatList(category, tournamentId, this@KotlinFixturesViewModel)
        }

    }

}