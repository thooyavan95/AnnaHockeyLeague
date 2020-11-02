package com.ahl.annahockeyleague.kotlin.kotlinfragments.kotlinFixtures

import android.os.Bundle
import android.view.View
import com.ahl.annahockeyleague.AhlApplication

class KotlinFixturesWomen : KotlinBaseFixtures() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        fixtures()
        viewModel.fetchFixturesList("women", AhlApplication.tournamentId)
    }

}