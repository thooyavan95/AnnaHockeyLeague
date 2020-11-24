package com.ahl.annahockeyleague.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.ahl.annahockeyleague.R
import com.ahl.annahockeyleague.adapters.PointsTableAdapter
import com.ahl.annahockeyleague.adapters.TopScorersAdapter
import com.ahl.annahockeyleague.ahlUtils.DateUtility
import com.ahl.annahockeyleague.ahlUtils.LogoUtility
import com.ahl.annahockeyleague.data.*
import com.ahl.annahockeyleague.ui.AhlViewModel
import com.ahl.annahockeyleague.ui.UIThreadExecutor
import com.squareup.picasso.Picasso
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fixture_template.*
import kotlinx.android.synthetic.main.fragment_home_page.*

abstract class BaseHome : Fragment(){

    private val viewModel by activityViewModels<AhlViewModel>()
    private lateinit var disposable: Disposable
    var oldData : AhlData? = null
    
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
            disposable = viewModel.ahlDataStream.observeOn(Schedulers.from(UIThreadExecutor())).subscribe(this::getData)
    }

    abstract fun getData(ahlData: AhlData)

    abstract fun getGender() : String

    private fun showError(error: String?) {
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
    }

    fun setMatchData(fixturesDataList: List<FixturesData>){

        setPreviousMatch(getPreviousMatchDetails(fixturesDataList))
        setNextMatch(getNextMatchDetails(fixturesDataList))
    }

    fun showMatchData(uiState: UIState){

        if(uiState == UIState.SHOW_CONTENT){

            home_next_match.visibility = View.VISIBLE
            previous_match_fixture_cardview.visibility = View.VISIBLE

            next_match_shimmer.visibility = View.GONE
            previous_match_shimmer.visibility = View.GONE
        }

    }

    fun setPointsData(pointsDatumData: List<PointsTableData>) {
        val adapter = PointsTableAdapter()
        adapter.updatePointsTableData(pointsDatumData)
        points_table_listview.layoutManager = LinearLayoutManager(context)
        points_table_listview.adapter = adapter
    }

    fun setTopScorers(list: List<TopScorersData>) {
        val adapter = TopScorersAdapter(getGender())
        adapter.updateTOpScorersData(list)
        top_scorers_listview.layoutManager = LinearLayoutManager(context)
        top_scorers_listview.adapter = adapter

    }

    fun showTopScorers(uiState: UIState){
        if(uiState == UIState.SHOW_CONTENT){
            top_scorers_shimmer.visibility = View.GONE
            top_scorers_cardview.visibility = View.VISIBLE

        }

    }

    fun showPointsTable(uiState: UIState){
        if(uiState == UIState.SHOW_CONTENT){

            points_table_cardview.visibility = View.VISIBLE
            points_shimmer.visibility = View.GONE

        }

    }

    private fun getPreviousMatchDetails(fixturesDataList: List<FixturesData>) : FixturesData? {

        return fixturesDataList.sortedByDescending { it.matchDateTime }
                .find { it.status == "COMPLETED"}

    }

    private fun getNextMatchDetails(fixturesDataList: List<FixturesData>): FixturesData? {
        return fixturesDataList.sortedBy { it.matchDateTime }
                .find { it.status == "UPCOMING" }
    }

    private fun setPreviousMatch(data : FixturesData?) {

        if(data != null){

            previous_match_fixture_date.text = DateUtility.formattedDate(data.matchDateTime)
            previous_match_team2_score.text = getScore(data.team2Scorers)
            previous_match_team2_name.text = data.team2.name
            previous_match_team1_score.text = getScore(data.team1Scorers)
            previous_match_team1_name.text = data.team1.name

            setBuddingPlayer(data)
            setManOfTheMatch(data)

            val team1Image = LogoUtility.getTeamLogo(data.team1.teamTag)
            val team2Image = LogoUtility.getTeamLogo(data.team2.teamTag)
            Picasso.get().load(team1Image).into(previous_match_team1_image)
            Picasso.get().load(team2Image).into(previous_match_team2_image)

        }

    }

    private fun setNextMatch(data: FixturesData?){


        if(data != null){
            next_match_fixture_date.text = DateUtility.formattedDate(data.matchDateTime)
            next_match_team2_score.text = null
            next_match_team2_name.text = data.team2.name
            next_match_team1_score.text = null
            next_match_team1_name.text = data.team1.name

            val team1Image = LogoUtility.getTeamLogo(data.team1.teamTag)
            val team2Image = LogoUtility.getTeamLogo(data.team2.teamTag)
            Picasso.get().load(team1Image).into(next_match_team1_image)
            Picasso.get().load(team2Image).into(next_match_team2_image)
        }


    }

    private fun setManOfTheMatch(data: FixturesData) {

        if(data.mom != null){
            previous_match_man_of_the_match_name.apply {
                visibility = View.VISIBLE
                text = data.mom.name
                man_of_the_match.visibility = View.VISIBLE
            }

            previous_match__man_of_the_match_image.apply {
                visibility = View.VISIBLE
                when(getGender()){
                    "men" -> Picasso.get().load(data.mom.profile).placeholder(R.drawable.men_image).into(this)
                    "women" -> Picasso.get().load(data.mom.profile).placeholder(R.drawable.women_image).into(this)
                }
            }
        }

    }

    private fun setBuddingPlayer(data : FixturesData) {

        if(data.buddingPlayer != null){
            previous_match_budding_player_name.apply {
                visibility = View.VISIBLE
                text = data.buddingPlayer.name
                budding_player.visibility = View.VISIBLE
            }

            previous_match__budding_player_image.apply {
                visibility = View.VISIBLE
                when(getGender()){
                    "men" -> Picasso.get().load(data.buddingPlayer.profile).placeholder(R.drawable.men_image).into(this)
                    "women" -> Picasso.get().load(data.buddingPlayer.profile).placeholder(R.drawable.women_image).into(this)
                }
            }
        }



    }


    private fun getScore(scorers : Map<String, Int>?): String {
        if(scorers == null){
            return "0"
        }
        return scorers.values.sum().toString()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        if(!disposable.isDisposed){
            disposable.dispose()
        }
    }


}