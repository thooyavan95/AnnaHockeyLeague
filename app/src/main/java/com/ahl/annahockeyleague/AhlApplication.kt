package com.ahl.annahockeyleague

import android.app.Application


class AhlApplication : Application() {

    companion object{
        lateinit var tournamentId : String
    }

}