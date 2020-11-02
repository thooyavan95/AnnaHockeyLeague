package com.ahl.annahockeyleague.kotlin.kotlinfragments.kotlinHome

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

class KotlinHomeWomen : KotlinBaseHome() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        viewModel = HomeViewModelFactory.getViewModel(this)
        viewModel.getAhlData("women")

        setLoadingStatus()

        observePreviousMatchLiveData()
        observeNextMatchLiveData()
        observePointsLiveData()
        observeTopScorersLiveData()

    }
}