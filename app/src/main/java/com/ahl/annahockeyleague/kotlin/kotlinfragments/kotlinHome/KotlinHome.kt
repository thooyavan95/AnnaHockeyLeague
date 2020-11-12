package com.ahl.annahockeyleague.kotlin.kotlinfragments.kotlinHome

import android.os.Bundle
import android.view.View
import com.ahl.annahockeyleague.kotlin.kotlinfragments.AhlFragment

class KotlinHome : AhlFragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setAdapter(listOf(KotlinHomeMen(), KotlinHomeWomen()))
    }
}