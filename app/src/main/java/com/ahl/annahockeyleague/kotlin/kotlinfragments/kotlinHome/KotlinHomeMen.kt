package com.ahl.annahockeyleague.kotlin.kotlinfragments.kotlinHome

import android.os.Bundle
import android.view.View

class KotlinHomeMen : KotlinBaseHome() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

            viewModel = HomeViewModelFactory.getViewModel(this)
            viewModel.getAhlData("men")
            setLoadingStatus()

            observePreviousMatchLiveData()
            observeNextMatchLiveData()
            observePointsLiveData()
            observeTopScorersLiveData()

    }
}