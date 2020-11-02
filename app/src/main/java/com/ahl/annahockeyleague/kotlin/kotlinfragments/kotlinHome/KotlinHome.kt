package com.ahl.annahockeyleague.kotlin.kotlinfragments.kotlinHome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ahl.annahockeyleague.R
import com.ahl.annahockeyleague.kotlin.adapters.FragmentAdapter
import kotlinx.android.synthetic.main.viewpager.*

class KotlinHome : Fragment() {

    private var adapter : FragmentAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.home_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


            if (adapter == null){
                adapter = FragmentAdapter(childFragmentManager)
                adapter?.updateFragmentList(listOf(KotlinHomeMen(), KotlinHomeWomen()))
            }

            viewpager.adapter = adapter
            tabLayout.setupWithViewPager(viewpager)

    }
    
}