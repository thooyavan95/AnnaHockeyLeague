package com.ahl.annahockeyleague.ui.home

import com.ahl.annahockeyleague.data.AhlData
import com.ahl.annahockeyleague.data.Category

class HomeWomen : BaseHome() {

    override fun showData(newData: AhlData) {
        val fixturesData = newData.fixturesWoMen

        if(oldData == null || oldData?.fixturesWoMen != fixturesData){
            setMatchData(fixturesData)
        }

        val fixturesDataLoader = newData.loaderData.fixturesForWomen

        if(oldData == null || oldData?.loaderData?.fixturesForWomen != fixturesDataLoader){
            showMatchData(fixturesDataLoader)
        }

        val pointsTableData = newData.pointsTableWoMen

        if(oldData == null || oldData?.pointsTableWoMen != pointsTableData){
            setPointsData(pointsTableData)
        }

        val pointsDataLoader = newData.loaderData.pointsTableForWomen

        if(oldData == null || oldData?.loaderData?.pointsTableForWomen != pointsDataLoader){
            showPointsTable(pointsDataLoader)
        }

        val topScorersData = newData.topScorersWoMen

        if(oldData == null || oldData?.topScorersWoMen != topScorersData){
            setTopScorers(topScorersData)
        }

        val topScorersLoader = newData.loaderData.topScorersForWomen

        if(oldData == null || oldData?.loaderData?.topScorersForWomen != topScorersLoader){
            showTopScorers(topScorersLoader)
        }

        oldData = newData
    }

    override fun getGender(): Category {
        return Category.WOMEN
    }
}