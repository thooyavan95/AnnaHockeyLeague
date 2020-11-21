package com.ahl.annahockeyleague.ui.home

import com.ahl.annahockeyleague.data.AhlData

class HomeMen : BaseHome() {

    override fun getData(ahlData: AhlData) {

        val fixturesData = ahlData.fixturesMen

        if(oldData == null || oldData?.fixturesMen != fixturesData){
            setMatchData(fixturesData)
        }

        val fixturesDataLoader = ahlData.loaderData.fixturesForMen

        if(oldData == null || oldData?.loaderData?.fixturesForMen != fixturesDataLoader){
            showMatchData(fixturesDataLoader)
        }

        val pointsTableData = ahlData.pointsTableMen

        if(oldData == null || oldData?.pointsTableMen != pointsTableData){
            setPointsData(pointsTableData)
        }

        val pointsDataLoader = ahlData.loaderData.pointsTableForMen

        if(oldData == null || oldData?.loaderData?.pointsTableForMen != pointsDataLoader){
            showPointsTable(pointsDataLoader)
        }

        val topScorersData = ahlData.topScorersMen

        if(oldData == null || oldData?.topScorersMen != topScorersData){
            setTopScorers(topScorersData)
        }

        val topScorersLoader = ahlData.loaderData.topScorersForMen

        if(oldData == null || oldData?.loaderData?.topScorersForMen != topScorersLoader){
            showTopScorers(topScorersLoader)
        }

    }

    override fun getGender(): String {
        return "men"
    }
}