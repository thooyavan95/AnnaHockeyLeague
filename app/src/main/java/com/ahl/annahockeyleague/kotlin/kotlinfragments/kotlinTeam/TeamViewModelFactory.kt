package com.ahl.annahockeyleague.kotlin.kotlinfragments.kotlinTeam

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

object TeamViewModelFactory {

    fun getViewModel(fragment : Fragment) : KotlinTeamViewModel{

        return ViewModelProvider(fragment, object : ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return KotlinTeamViewModel(TeamRepoImpl()) as T
            }
        })[KotlinTeamViewModel::class.java]

    }

}