package com.ahl.annahockeyleague.kotlin.kotlinfragments.kotlinTeam

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ahl.annahockeyleague.R
import com.ahl.annahockeyleague.kotlin.UIState
import com.ahl.annahockeyleague.kotlin.adapters.TeamsAdapter
import com.ahl.annahockeyleague.kotlin.data.Team
import kotlinx.android.synthetic.main.team_fragment_layout.*

abstract class KotlinBaseTeam : Fragment(), TeamsAdapter.TeamListener {

    lateinit var viewModel : KotlinTeamViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = TeamViewModelFactory.getViewModel(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.team_fragment_layout, container, false)
    }

    abstract override fun onViewCreated(view: View, savedInstanceState: Bundle?)

    override fun onTeamSelected(position: Int) {
            Toast.makeText(context, position.toString(), Toast.LENGTH_SHORT).show()
    }

    fun getTeams(category : String){
        viewModel.teamListLiveData.observe(viewLifecycleOwner, Observer {

            when(it){

                is UIState.DataAvailable -> setTeams(it.data)

                is UIState.Error -> Toast.makeText(context, it.error, Toast.LENGTH_SHORT).show()

            }

        })

        viewModel.fetchTeamList(category)
    }

    private fun setTeams(data: List<Team>) {

        team_progress_bar.visibility = View.GONE

        val teamsAdapter = TeamsAdapter(this)
        teamsAdapter.updateItems(data)
        team_recycle_view.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = teamsAdapter
        }


    }

}