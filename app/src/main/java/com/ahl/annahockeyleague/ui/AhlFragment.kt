package com.ahl.annahockeyleague.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.ahl.annahockeyleague.R
import com.ahl.annahockeyleague.adapters.ViewPager2Adapter
import com.ahl.annahockeyleague.ui.home.HomeMen
import com.ahl.annahockeyleague.ui.home.HomeWomen
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_ahl.*

class AhlFragment : Fragment() {

    private val ahlViewModel by activityViewModels<AhlViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_ahl, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){

        ahlViewModel.getAhlData()
        adapterCode()
    }

    private fun adapterCode() {
        val adapter = ViewPager2Adapter(this)
        adapter.updateList(listOf(HomeMen(), HomeWomen()))
        viewpager2.adapter = adapter

        TabLayoutMediator(tabLayout2, viewpager2){ tab, position ->
            tab.text = adapter.getTitleList(position)
        }.attach()

    }


//    fun setAdapter(list : List<Fragment>){
//        val adapter = ViewPager2Adapter(list, requireActivity())
//        viewpager2.adapter = adapter
//
//        TabLayoutMediator(tabLayout2, viewpager2){ tab, position ->
//            tab.text = adapter.getTitleList(position)
//        }.attach()
//
//    }
}