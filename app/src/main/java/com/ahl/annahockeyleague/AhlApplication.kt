package com.ahl.annahockeyleague

import android.app.Application
import android.util.Log
import com.ahl.annahockeyleague.kotlin.network.RetrofitService
import kotlinx.coroutines.*

class AhlApplication : Application() {

    companion object{
        lateinit var tournamentId : String
    }

    override fun onCreate() {
        super.onCreate()

    }

}