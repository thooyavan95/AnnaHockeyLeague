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
import com.ahl.annahockeyleague.data.AhlData
import com.ahl.annahockeyleague.data.FixturesData
import com.ahl.annahockeyleague.data.PointsTableData
import com.ahl.annahockeyleague.data.TopScorersData
import com.ahl.annahockeyleague.ui.AhlViewModel
import com.ahl.annahockeyleague.ui.UIThreadExecutor
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fixture_template.*
import kotlinx.android.synthetic.main.fragment_home_page.*
import java.text.SimpleDateFormat
import java.util.*

abstract class BaseHome : Fragment(){

    private val viewModel by activityViewModels<AhlViewModel>()
    private lateinit var disposable: Disposable
    
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
            disposable = viewModel.ahlDataStream.observeOn(Schedulers.from(UIThreadExecutor())).subscribe(this::getData)
    }

    abstract fun getData(ahlData: AhlData)

    private fun showError(error: String?) {
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
    }

    private fun getPreviousMatchDetails(fixturesDataList: List<FixturesData>) : FixturesData? {

        return fixturesDataList.sortedByDescending { it.matchDateTime }
                .find { it.status == "COMPLETED"}

    }

    private fun getNextMatchDetails(fixturesDataList: List<FixturesData>): FixturesData? {
        return fixturesDataList.sortedBy { it.matchDateTime }
                .find { it.status == "UPCOMING" }
    }


    private fun setPreviousMatch(fixtureDetails : FixturesData) {

        previous_match_fixture_date.text = formattedDate(fixtureDetails.matchDateTime)
        previous_match_team2_score.text = getScore(fixtureDetails.team2Scorers)
        previous_match_team2_name.text = fixtureDetails.team2.name
        previous_match_team1_score.text = getScore(fixtureDetails.team1Scorers)
        previous_match_team1_name.text = fixtureDetails.team1.name
        previous_match_budding_player_name.apply {
            if(fixtureDetails.buddingPlayer != null){
                visibility = View.VISIBLE
                text = fixtureDetails.buddingPlayer.name
            }
        }
        previous_match_man_of_the_match_name.apply {
            if(fixtureDetails.mom != null){
                 visibility = View.VISIBLE
                text = fixtureDetails.mom.name
            }
        }

    }

    private fun setNextMatch(fixtureDetails: FixturesData){

        next_match_fixture_date.text = formattedDate(fixtureDetails.matchDateTime)
        next_match_team2_score.text = getScore(fixtureDetails.team2Scorers)
        next_match_team2_name.text = fixtureDetails.team2.name
        next_match_team1_score.text = getScore(fixtureDetails.team1Scorers)
        next_match_team1_name.text = fixtureDetails.team1.name
    }

    private fun setPointsData(pointsDatumData: List<PointsTableData>) {
            val adapter = PointsTableAdapter()
            adapter.updatePointsTableData(pointsDatumData)
            points_table_listview.layoutManager = LinearLayoutManager(context)
            points_table_listview.adapter = adapter
    }

    private fun setTopScorers(list: List<TopScorersData>) {
            val adapter = TopScorersAdapter()
            adapter.updateTOpScorersData(list)
            top_scorers_listview.layoutManager = LinearLayoutManager(context)
            top_scorers_listview.adapter = adapter

    }

    private fun getScore(scorers : Map<String, Int>?): String {
        if(scorers == null){
            return "0"
        }
        return scorers.values.sum().toString()

    }

    private fun formattedDate(timeInMillis : Long): String {

        val pattern = "dd:MMM:yyyy - hh:mm a"
        val date = Date(timeInMillis)
        val sdf = SimpleDateFormat(pattern, Locale.getDefault())
        return sdf.format(date)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        if(!disposable.isDisposed){
            disposable.dispose()
        }
    }


}