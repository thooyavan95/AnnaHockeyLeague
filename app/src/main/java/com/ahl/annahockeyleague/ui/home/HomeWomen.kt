package com.ahl.annahockeyleague.ui.home

import com.ahl.annahockeyleague.data.AhlData

class HomeWomen : BaseHome() {

    override fun getData(ahlData: AhlData) {
        val fixturesData = ahlData.fixturesWoMen

        if(oldData == null || oldData?.fixturesWoMen != fixturesData){
            setMatchData(fixturesData)
        }

        val fixturesDataLoader = ahlData.loaderData.fixturesForWomen

        if(oldData == null || oldData?.loaderData?.fixturesForWomen != fixturesDataLoader){
            showMatchData(fixturesDataLoader)
        }

        val pointsTableData = ahlData.pointsTableWoMen

        if(oldData == null || oldData?.pointsTableWoMen != pointsTableData){
            setPointsData(pointsTableData)
        }

        val pointsDataLoader = ahlData.loaderData.pointsTableForWomen

        if(oldData == null || oldData?.loaderData?.pointsTableForWomen != pointsDataLoader){
            showPointsTable(pointsDataLoader)
        }

        val topScorersData = ahlData.topScorersWoMen

        if(oldData == null || oldData?.topScorersWoMen != topScorersData){
            setTopScorers(topScorersData)
        }

        val topScorersLoader = ahlData.loaderData.topScorersForWomen

        if(oldData == null || oldData?.loaderData?.topScorersForWomen != topScorersLoader){
            showTopScorers(topScorersLoader)
        }

    }

    override fun getGender(): String {
        return "women"
    }
}