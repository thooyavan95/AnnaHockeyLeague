package com.ahl.annahockeyleague.ui.fixtures

import androidx.fragment.app.Fragment
import com.ahl.annahockeyleague.AhlFragment

class Fixtures : AhlFragment() {

    override fun getFragmentList(): List<Fragment> = listOf(FixturesMen(), FixturesWomen())
}