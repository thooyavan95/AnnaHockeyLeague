package com.ahl.annahockeyleague

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ahl.annahockeyleague.adapters.ViewPager2Adapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_ahl.*

abstract class AhlFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_ahl, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){

        adapterCode()
    }

    abstract fun getFragmentList() : List<Fragment>

    private fun adapterCode() {
        val adapter = ViewPager2Adapter(this)
        adapter.updateList(getFragmentList())
        viewpager2.adapter = adapter

        TabLayoutMediator(tabLayout2, viewpager2){ tab, position ->
            tab.text = adapter.getTitleList(position)
        }.attach()

    }

}