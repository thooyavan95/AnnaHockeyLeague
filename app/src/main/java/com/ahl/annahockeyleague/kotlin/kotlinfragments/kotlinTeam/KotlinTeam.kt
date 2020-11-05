package com.ahl.annahockeyleague.kotlin.kotlinfragments.kotlinTeam

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ahl.annahockeyleague.R
import com.ahl.annahockeyleague.kotlin.adapters.FragmentAdapter
import kotlinx.android.synthetic.main.viewpager.*

class KotlinTeam : Fragment() {

    private var adapter : FragmentAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.home_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        adapter = FragmentAdapter(childFragmentManager)
        adapter?.updateFragmentList(listOf(KotlinMenTeam(), KotlinWomenTeam()))

        viewpager.adapter = adapter
        tabLayout.setupWithViewPager(viewpager)

    }

}