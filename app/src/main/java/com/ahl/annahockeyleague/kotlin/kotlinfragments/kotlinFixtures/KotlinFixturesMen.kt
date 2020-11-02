package com.ahl.annahockeyleague.kotlin.kotlinfragments.kotlinFixtures

import android.os.Bundle
import android.view.View
import com.ahl.annahockeyleague.AhlApplication

class KotlinFixturesMen : KotlinBaseFixtures() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        fixtures()
        viewModel.fetchFixturesList("men", AhlApplication.tournamentId)
    }



}