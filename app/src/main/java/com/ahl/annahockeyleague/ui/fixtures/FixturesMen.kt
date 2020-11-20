package com.ahl.annahockeyleague.ui.fixtures

import com.ahl.annahockeyleague.data.AhlData

class FixturesMen : BaseFixtures() {

    override fun getData(newData: AhlData) {

        val fixtures = newData.fixturesMen

        if(oldData == null || oldData?.fixturesMen != fixtures){
            setFixtures(fixtures)
        }

        val dataLoader = newData.loaderData.fixturesForMen

        if(oldData == null || oldData?.loaderData?.fixturesForMen != dataLoader){
            setLoader()
        }

    }
}