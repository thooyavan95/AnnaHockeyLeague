package com.ahl.annahockeyleague.kotlin.kotlinfragments.kotlinFixtures

import com.ahl.annahockeyleague.kotlin.data.AhlData

class KotlinFixturesWomen : KotlinBaseFixtures() {

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