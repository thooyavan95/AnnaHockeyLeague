package com.ahl.annahockeyleague.kotlin.kotlinfragments.kotlinTeam

import android.os.Bundle
import android.view.View

class KotlinWomenTeam : KotlinBaseTeam(){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        getTeams("women")
    }
}