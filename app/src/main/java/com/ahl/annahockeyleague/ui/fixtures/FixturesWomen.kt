package com.ahl.annahockeyleague.ui.fixtures

import com.ahl.annahockeyleague.data.AhlData

class FixturesWomen : BaseFixtures() {

    override fun showData(newData: AhlData) {

        val fixtures = newData.fixturesWoMen

        if(oldData == null || oldData?.fixturesWoMen != fixtures){
            setFixtures(fixtures)
        }

        val fixturesLoader = newData.loaderData.fixturesForWomen

        if(oldData == null || oldData?.loaderData?.fixturesForWomen != fixturesLoader){
            showLoader(fixturesLoader)
        }

        oldData = newData
    }
}