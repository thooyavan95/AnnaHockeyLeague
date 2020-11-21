package com.ahl.annahockeyleague.ui.team

import com.ahl.annahockeyleague.data.AhlData

class WomenTeam : BaseTeam(){

    override fun getData(ahlData: AhlData) {

        val teamData = ahlData.teamsWoMen

        if(oldData == null || oldData?.teamsWoMen != teamData){
            setTeams(teamData)
        }

        val teamDataLoader = ahlData.loaderData.teamsForWomen

        if(oldData == null || oldData?.loaderData?.teamsForWomen != teamDataLoader){
            teamLoader()
        }
    }
}