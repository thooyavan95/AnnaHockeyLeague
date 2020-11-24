package com.ahl.annahockeyleague.ui.team

import androidx.fragment.app.Fragment
import com.ahl.annahockeyleague.AhlFragment

class Team : AhlFragment() {

    override fun getFragmentList(): List<Fragment> = listOf(MenTeam(), WomenTeam())
}