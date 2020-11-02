package com.ahl.annahockeyleague.kotlin.kotlinfragments.kotlinFixtures

import android.os.Bundle
import android.util.Log
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
import com.ahl.annahockeyleague.kotlin.adapters.FixturesAdapter
import com.ahl.annahockeyleague.kotlin.data.Fixtures
import com.ahl.annahockeyleague.kotlin.kotlinfragments.kotlinHome.HomeViewModelFactory
import com.ahl.annahockeyleague.kotlin.kotlinfragments.kotlinHome.KotlinHomeViewModel
import kotlinx.android.synthetic.main.fixtures_fragment_layout.*

abstract class KotlinBaseFixtures : Fragment() {

    lateinit var viewModel : KotlinFixturesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = KotlinFixturesViewModelFactory.getViewModel(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fixtures_fragment_layout, container, false)
    }

    abstract override fun onViewCreated(view: View, savedInstanceState: Bundle?)

    fun fixtures(){
        viewModel.fixturesListLiveData.observe(viewLifecycleOwner, Observer {
            when(it){
                is UIState.DataAvailable ->{
                    fixtures_progress_bar.visibility = View.GONE
                    setFixtures(it.data)
                }

                is UIState.Error -> Toast.makeText(context, it.error, Toast.LENGTH_SHORT).show()
            }
        })

    }

    private fun setFixtures(fixturesData : List<Fixtures>) {

        val adapter = FixturesAdapter()
        adapter.updateFixturesData(fixturesData)
        fixtures_recycler_view.layoutManager = LinearLayoutManager(context)
        fixtures_recycler_view.adapter = adapter
    }

}