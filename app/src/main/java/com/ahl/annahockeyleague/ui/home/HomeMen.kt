package com.ahl.annahockeyleague.ui.home

import com.ahl.annahockeyleague.data.AhlData
import com.ahl.annahockeyleague.data.Category

class HomeMen : BaseHome() {

    override fun showData(newData: AhlData) {

        val fixturesData = newData.fixturesMen

        if(oldData == null || oldData?.fixturesMen != fixturesData){
            setMatchData(fixturesData)
        }

        val fixturesDataLoader = newData.loaderData.fixturesForMen

        if(oldData == null || oldData?.loaderData?.fixturesForMen != fixturesDataLoader){
            showMatchData(fixturesDataLoader)
        }

        val pointsTableData = newData.pointsTableMen

        if(oldData == null || oldData?.pointsTableMen != pointsTableData){
            setPointsData(pointsTableData)
        }

        val pointsDataLoader = newData.loaderData.pointsTableForMen

        if(oldData == null || oldData?.loaderData?.pointsTableForMen != pointsDataLoader){
            showPointsTable(pointsDataLoader)
        }

        val topScorersData = newData.topScorersMen

        if(oldData == null || oldData?.topScorersMen != topScorersData){
            setTopScorers(topScorersData)
        }

        val topScorersLoader = newData.loaderData.topScorersForMen

        if(oldData == null || oldData?.loaderData?.topScorersForMen != topScorersLoader){
            showTopScorers(topScorersLoader)
        }

        oldData = newData

    }

    override fun getGender(): Category {
        return Category.MEN
    }
}