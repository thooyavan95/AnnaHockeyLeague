package com.ahl.annahockeyleague.ui.fixtures

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.ahl.annahockeyleague.R
import com.ahl.annahockeyleague.adapters.FixturesAdapter
import com.ahl.annahockeyleague.data.AhlData
import com.ahl.annahockeyleague.data.FixturesData
import com.ahl.annahockeyleague.data.UIState
import com.ahl.annahockeyleague.ui.AhlViewModel
import com.ahl.annahockeyleague.ui.UIThreadExecutor
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fixtures_fragment_layout.*

abstract class BaseFixtures : Fragment() {

    private val viewModel by activityViewModels<AhlViewModel>()
    private lateinit var disposable: Disposable

    var oldData : AhlData? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fixtures_fragment_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){

        disposable = viewModel.ahlDataStream.observeOn(Schedulers.from(UIThreadExecutor())).subscribe(this::showData)
    }

    abstract fun showData(newData : AhlData)

    fun showLoader(uiState : UIState){

        when(uiState){

            UIState.SHOW_LOADER -> shimmer_fixtures_layout.visibility = View.VISIBLE

            UIState.SHOW_CONTENT -> {
                shimmer_fixtures_layout.visibility = View.GONE
                fixtures_recycler_view.visibility = View.VISIBLE
            }

            UIState.SHOW_ERROR -> shimmer_fixtures_layout.visibility = View.GONE

        }

    }

    fun setFixtures(fixturesDataData : List<FixturesData>) {

        val adapter = FixturesAdapter()
        adapter.updateFixturesData(fixturesDataData)
        fixtures_recycler_view.layoutManager = LinearLayoutManager(context)
        fixtures_recycler_view.adapter = adapter

    }

    override fun onDestroyView() {
        super.onDestroyView()
        if(!disposable.isDisposed){
            disposable.dispose()
        }
    }

}