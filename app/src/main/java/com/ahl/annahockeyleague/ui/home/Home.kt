package com.ahl.annahockeyleague.ui.home


import androidx.fragment.app.Fragment
import com.ahl.annahockeyleague.AhlFragment

class Home : AhlFragment() {

    override fun getFragmentList(): List<Fragment> = listOf(HomeMen(), HomeWomen())
}