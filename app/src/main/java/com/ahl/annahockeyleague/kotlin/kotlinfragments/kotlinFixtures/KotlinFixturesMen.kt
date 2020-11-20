package com.ahl.annahockeyleague.kotlin.kotlinfragments.kotlinFixtures

import com.ahl.annahockeyleague.kotlin.data.AhlData

class KotlinFixturesMen : KotlinBaseFixtures() {

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