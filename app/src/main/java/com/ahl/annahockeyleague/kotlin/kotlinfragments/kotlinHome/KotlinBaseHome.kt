package com.ahl.annahockeyleague.kotlin.kotlinfragments.kotlinHome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ahl.annahockeyleague.R
import com.ahl.annahockeyleague.kotlin.UIState
import com.ahl.annahockeyleague.kotlin.adapters.PointsTableAdapter
import com.ahl.annahockeyleague.kotlin.adapters.TopScorersAdapter
import com.ahl.annahockeyleague.kotlin.data.Fixtures
import com.ahl.annahockeyleague.kotlin.data.PointsTable
import com.ahl.annahockeyleague.kotlin.data.TopScorers
import kotlinx.android.synthetic.main.fixture_template.*
import kotlinx.android.synthetic.main.fragment_home_page.*
import java.text.SimpleDateFormat
import java.util.*

abstract class KotlinBaseHome : Fragment(){

    private lateinit var viewModel: KotlinHomeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel = HomeViewModelFactory.getViewModel(activity as AppCompatActivity)
        return inflater.inflate(R.layout.fragment_home_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setLoadingStatus()

        observePreviousMatchLiveData()
        observeNextMatchLiveData()
        observePointsLiveData()
        observeTopScorersLiveData()

    }

    private fun setLoadingStatus() {
        previous_progress_bar.visibility = View.VISIBLE
        next_progress_bar.visibility = View.VISIBLE
        table_progress_bar.visibility = View.VISIBLE
        top_scorer_progress_bar.visibility = View.VISIBLE
    }


    private fun observePreviousMatchLiveData() {

        viewModel.previousMatchLiveData.observe(viewLifecycleOwner, Observer {
            when(it){
                is UIState.Loading->{
                    Toast.makeText(context, "i am loading", Toast.LENGTH_SHORT).show()
                }

                is UIState.DataAvailable ->{
                    setPreviousMatch(it.data)
                    previous_progress_bar.visibility = View.GONE
                }

                is UIState.Error ->{
                    showError(it.error)
                }

            }
        })
    }

    private fun observeNextMatchLiveData() {

        viewModel.nextMatchLiveData.observe(viewLifecycleOwner, Observer {
                when(it){

                    is UIState.DataAvailable ->{
                        setNextMatch(it.data)
                        next_progress_bar.visibility = View.GONE
                    }

                    is UIState.Error ->{
                        showError(it.error)
                    }

                }
        })
    }


    private fun observePointsLiveData() {

        viewModel.pointsTableLiveData.observe(viewLifecycleOwner, Observer {
            when(it){

                is UIState.DataAvailable ->{
                    setPointsData(it.data)
                    table_progress_bar.visibility = View.GONE
                }

                is UIState.Error ->{
                    showError(it.error)
                }
            }
        })

    }


    private fun observeTopScorersLiveData() {

        viewModel.topScoresLiveData.observe(viewLifecycleOwner, Observer {
            when(it){

                is UIState.DataAvailable ->{
                    setTopScorers(it.data)
                    top_scorer_progress_bar.visibility = View.GONE
                }

                is UIState.Error ->{
                    showError(it.error)
                }

            }
        })

    }


    private fun showError(error: String?) {
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
    }

    private fun setPreviousMatch(fixtureDetails : Fixtures) {

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

    private fun setNextMatch(fixtureDetails: Fixtures){

        next_match_fixture_date.text = formattedDate(fixtureDetails.matchDateTime)
        next_match_team2_score.text = getScore(fixtureDetails.team2Scorers)
        next_match_team2_name.text = fixtureDetails.team2.name
        next_match_team1_score.text = getScore(fixtureDetails.team1Scorers)
        next_match_team1_name.text = fixtureDetails.team1.name
    }

    private fun setPointsData(pointsData: List<PointsTable>) {
            val adapter = PointsTableAdapter()
            adapter.updatePointsTableData(pointsData)
            points_table_listview.layoutManager = LinearLayoutManager(context)
            points_table_listview.adapter = adapter
    }

    private fun setTopScorers(list: List<TopScorers>) {
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


}