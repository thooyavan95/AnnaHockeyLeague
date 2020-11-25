package com.ahl.annahockeyleague.data

data class AhlData(
        val loaderData : LoaderData = LoaderData(),

        val fixturesMen : Fixtures = Fixtures(),
        val topScorersMen : TopScorers = TopScorers(),
        val pointsTableMen : PointsTable = PointsTable(),
        val teamsMen : Teams = Teams(),

        val fixturesWoMen : Fixtures = Fixtures(),
        val topScorersWoMen : TopScorers = TopScorers(),
        val pointsTableWoMen : PointsTable = PointsTable(),
        val teamsWoMen : Teams = Teams()

)

data class LoaderData(
        val fixturesForMen : UIState = UIState.SHOW_LOADER,
        val fixturesForWomen : UIState = UIState.SHOW_LOADER,
        val topScorersForMen : UIState = UIState.SHOW_LOADER,
        val topScorersForWomen : UIState = UIState.SHOW_LOADER,
        val pointsTableForMen : UIState = UIState.SHOW_LOADER,
        val pointsTableForWomen : UIState = UIState.SHOW_LOADER,
        val teamsForMen : UIState = UIState.SHOW_LOADER,
        val teamsForWomen : UIState = UIState.SHOW_LOADER
)

enum class DataFailedAction{

    TOURNAMENT,
    FIXTURES_MEN,
    FIXTURES_WOMEN,
    TOP_SCORERS_MEN,
    TOP_SCORERS_WOMEN,
    POINTS_TABLE_MEN,
    POINTS_TABLE_WOMEN,
    TEAMS_MEN,
    TEAMS_WOMEN,

}

enum class UIState{
    SHOW_LOADER,
    SHOW_CONTENT,
    SHOW_ERROR
}