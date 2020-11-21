package com.ahl.annahockeyleague.ahlUtils

import com.ahl.annahockeyleague.R
import com.ahl.annahockeyleague.data.TeamTag

object LogoUtility {

    fun getTeamLogo(tag : TeamTag) : Int{

        return when(tag){

            TeamTag.M_RED, TeamTag.W_RED -> R.drawable.red_ruffianz
            TeamTag.M_BLUE, TeamTag.W_BLUE -> R.drawable.sizzling_bluz
            TeamTag.M_WHITE, TeamTag.W_WHITE -> R.drawable.white_warriorz
            TeamTag.M_YELLOW, TeamTag.W_YELLOW -> R.drawable.yo_yo_yakz
            TeamTag.M_GREEN, TeamTag.W_GREEN -> R.drawable.green_griffinz
            TeamTag.M_VIOLET, TeamTag.W_VIOLET -> R.drawable.violet_whalez
            TeamTag.M_BLACK -> R.drawable.black_hawkz

            else -> 0
        }
    }

}