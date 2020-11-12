package com.ahl.annahockeyleague.kotlin.kotlinfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.ahl.annahockeyleague.R
import com.ahl.annahockeyleague.kotlin.adapters.FragmentAdapter
import com.ahl.annahockeyleague.kotlin.adapters.ViewPager2Adapter
import com.ahl.annahockeyleague.kotlin.kotlinfragments.kotlinFixtures.KotlinFixturesMen
import com.ahl.annahockeyleague.kotlin.kotlinfragments.kotlinFixtures.KotlinFixturesWomen
import com.ahl.annahockeyleague.kotlin.kotlinfragments.kotlinHome.KotlinHomeMen
import com.ahl.annahockeyleague.kotlin.kotlinfragments.kotlinHome.KotlinHomeWomen
import com.ahl.annahockeyleague.kotlin.kotlinfragments.kotlinTeam.KotlinMenTeam
import com.ahl.annahockeyleague.kotlin.kotlinfragments.kotlinTeam.KotlinWomenTeam
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.home_page.*

abstract class AhlFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.home_page, container, false)
    }

    abstract override fun onViewCreated(view: View, savedInstanceState: Bundle?)

    fun setAdapter(list : List<Fragment>){
        val adapter = ViewPager2Adapter(list, this)
        viewpager2.adapter = adapter

        TabLayoutMediator(tabLayout2, viewpager2){ tab, position ->
            tab.text = adapter.getTitleList(position)
        }.attach()

    }
}