package com.ahl.annahockeyleague.ui.team

import com.ahl.annahockeyleague.data.AhlData
import com.ahl.annahockeyleague.data.Category

class MenTeam : BaseTeam() {

    override fun showData(newData: AhlData) {

        val teamData = newData.teamsMen

        if(oldData == null || oldData?.teamsMen != teamData){
            setTeams(teamData)
        }

        val teamDataLoader = newData.loaderData.teamsForMen

        if(oldData == null || oldData?.loaderData?.teamsForMen != teamDataLoader){
            teamLoader(teamDataLoader)
        }

        oldData = newData
    }

    override fun getGender(): Category = Category.MEN
}