package com.ahl.annahockeyleague.kotlin.kotlinfragments.kotlinHome

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

object HomeViewModelFactory {

    fun getViewModel(activity : AppCompatActivity) : KotlinHomeViewModel{
        return ViewModelProvider(activity, object : ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return KotlinHomeViewModel(HomeRepoImpl ()) as T
            }
        })[KotlinHomeViewModel::class.java]
    }

}