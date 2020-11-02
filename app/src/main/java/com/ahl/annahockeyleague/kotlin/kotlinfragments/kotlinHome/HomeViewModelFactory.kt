package com.ahl.annahockeyleague.kotlin.kotlinfragments.kotlinHome

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

object HomeViewModelFactory {

    fun getViewModel(fragment : Fragment) : KotlinHomeViewModel{
        return ViewModelProvider(fragment, object : ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return KotlinHomeViewModel(HomeRepoImpl ()) as T
            }
        })[KotlinHomeViewModel::class.java]
    }

}