package com.ahl.annahockeyleague.kotlin.kotlinfragments.kotlinFixtures

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ahl.annahockeyleague.R
import com.ahl.annahockeyleague.kotlin.adapters.FragmentAdapter
import kotlinx.android.synthetic.main.viewpager.*

class KotlinFixtures : Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.home_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val adapter = FragmentAdapter(childFragmentManager)
        adapter.updateFragmentList(listOf(KotlinFixturesMen(), KotlinFixturesWomen()))
        viewpager.adapter = adapter
        tabLayout.setupWithViewPager(viewpager)

    }

}