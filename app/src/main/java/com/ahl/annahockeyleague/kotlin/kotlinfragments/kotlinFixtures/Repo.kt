package com.ahl.annahockeyleague.kotlin.kotlinfragments.kotlinFixtures

interface Repo {

   suspend fun getFixturesDatList(category : String, tournamentId : String, fixturesListener: FixturesListener)

}