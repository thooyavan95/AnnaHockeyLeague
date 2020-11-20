package com.ahl.annahockeyleague.kotlin.kotlinfragments.kotlinTeam

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ahl.annahockeyleague.R
import com.ahl.annahockeyleague.kotlin.UIState
import com.ahl.annahockeyleague.kotlin.adapters.TeamsAdapter
import com.ahl.annahockeyleague.kotlin.data.AhlData
import com.ahl.annahockeyleague.kotlin.data.TeamData
import com.ahl.annahockeyleague.kotlin.kotlinfragments.AhlViewModel
import com.ahl.annahockeyleague.kotlin.kotlinfragments.UIThreadExecutor
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.team_fragment_layout.*

abstract class KotlinBaseTeam : Fragment(), TeamsAdapter.TeamListener {

    private val viewModel by activityViewModels<AhlViewModel>()
    private lateinit var disposable: Disposable

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.team_fragment_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){

        disposable = viewModel.ahlDataStream.observeOn(Schedulers.from(UIThreadExecutor())).subscribe(this::getData)
    }

    abstract fun getData(ahlData: AhlData)

    override fun onTeamSelected(position: Int) {
            Toast.makeText(context, position.toString(), Toast.LENGTH_SHORT).show()
    }


    private fun setTeams(data: List<TeamData>) {

        team_progress_bar.visibility = View.GONE

        val teamsAdapter = TeamsAdapter(this)
        teamsAdapter.updateItems(data)
        team_recycle_view.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = teamsAdapter
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        if(!disposable.isDisposed){
            disposable.dispose()
        }
    }

}