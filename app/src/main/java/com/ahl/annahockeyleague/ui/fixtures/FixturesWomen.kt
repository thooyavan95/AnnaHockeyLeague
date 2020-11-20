package com.ahl.annahockeyleague.ui.fixtures

import com.ahl.annahockeyleague.data.AhlData

class FixturesWomen : BaseFixtures() {

    override fun getData(newState: AhlData) {

        val fixtures = newState.fixturesWoMen

        if(oldData == null || oldData?.fixturesWoMen != fixtures){
            setFixtures(fixtures)
        }

        val fixturesLoader = newState.loaderData.fixturesForWomen

        if(oldData == null || oldData?.loaderData?.fixturesForWomen != fixturesLoader){
            setLoader()
        }

    }
}