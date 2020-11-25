package com.ahl.annahockeyleague.ui.team

import com.ahl.annahockeyleague.data.AhlData
import com.ahl.annahockeyleague.data.Category

class WomenTeam : BaseTeam(){

    override fun showData(newData: AhlData) {

        val teamData = newData.teamsWoMen

        if(oldData == null || oldData?.teamsWoMen != teamData){
            setTeams(teamData)
        }

        val teamDataLoader = newData.loaderData.teamsForWomen

        if(oldData == null || oldData?.loaderData?.teamsForWomen != teamDataLoader){
            teamLoader(teamDataLoader)
        }

        oldData = newData
    }

    override fun getGender(): Category = Category.WOMEN
}