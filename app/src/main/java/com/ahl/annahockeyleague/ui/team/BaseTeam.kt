package com.ahl.annahockeyleague.ui.team

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.ahl.annahockeyleague.R
import com.ahl.annahockeyleague.adapters.TeamsAdapter
import com.ahl.annahockeyleague.data.AhlData
import com.ahl.annahockeyleague.data.TeamData
import com.ahl.annahockeyleague.ui.AhlViewModel
import com.ahl.annahockeyleague.ui.UIThreadExecutor
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.team_fragment_layout.*

abstract class BaseTeam : Fragment(), TeamsAdapter.TeamListener {

    private val viewModel by activityViewModels<AhlViewModel>()
    private lateinit var disposable: Disposable

    var oldData : AhlData? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.team_fragment_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){

        disposable = viewModel.ahlDataStream.observeOn(Schedulers.from(UIThreadExecutor())).subscribe(this::getData)
    }

    abstract fun getData(ahlData: AhlData)

    abstract fun getGender() : String

    override fun onTeamSelected(position: Int) {
            Toast.makeText(context, position.toString(), Toast.LENGTH_SHORT).show()
    }

    fun teamLoader(){

    }

    fun setTeams(data: List<TeamData>) {

        val teamsAdapter = TeamsAdapter(getGender(), this)
        teamsAdapter.updateItems(data)
        team_recycle_view.apply {
            layoutManager = GridLayoutManager(context, 3)
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