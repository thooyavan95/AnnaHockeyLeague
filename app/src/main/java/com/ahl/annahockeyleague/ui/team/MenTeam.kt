package com.ahl.annahockeyleague.ui.team

import com.ahl.annahockeyleague.data.AhlData

class MenTeam : BaseTeam() {

    override fun getData(ahlData: AhlData) {

        val teamData = ahlData.teamsMen

        if(oldData == null || oldData?.teamsMen != teamData){
            setTeams(teamData)
        }

        val teamDataLoader = ahlData.loaderData.teamsForMen

        if(oldData == null || oldData?.loaderData?.teamsForMen != teamDataLoader){
            teamLoader()
        }
    }

    override fun getGender(): String = "men"
}