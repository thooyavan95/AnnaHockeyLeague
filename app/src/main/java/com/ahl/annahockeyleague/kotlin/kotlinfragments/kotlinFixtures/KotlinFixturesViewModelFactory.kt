package com.ahl.annahockeyleague.kotlin.kotlinfragments.kotlinFixtures

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

object KotlinFixturesViewModelFactory {

    fun getViewModel(fragment: Fragment) : KotlinFixturesViewModel{
        return ViewModelProvider(fragment, object : ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return KotlinFixturesViewModel(RepoImpl()) as T
            }
        })[KotlinFixturesViewModel::class.java]
    }

}