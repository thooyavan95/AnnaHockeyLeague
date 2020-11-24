package com.ahl.annahockeyleague

import android.os.Bundle
import android.view.*
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.ahl.annahockeyleague.data.UIState
import com.ahl.annahockeyleague.ui.AhlViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()  {

    private val ahlViewModel by viewModels<AhlViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ahlViewModel.tournamentLiveData.observe(this, Observer { it ->
            when(it){

                UIState.SHOW_LOADER -> setErrorVisibility(errorVisibility = View.GONE)

                UIState.SHOW_CONTENT -> setErrorVisibility(errorVisibility = View.GONE)

                UIState.SHOW_ERROR -> setErrorVisibility(errorVisibility = View.VISIBLE)

                else -> return@Observer
            }
        })

        swipe_error.setOnClickListener {
            ahlViewModel.getAhlData()

        }

        ahlViewModel.getAhlData()
        ahl_bottom_nav.setupWithNavController(findNavController(R.id.nav_host_fragment))

    }



    private fun  setErrorVisibility(errorVisibility : Int){
        swipe_error.visibility = errorVisibility
    }

}