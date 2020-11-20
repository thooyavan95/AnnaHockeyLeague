package com.ahl.annahockeyleague.kotlin.kotlinfragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.ahl.annahockeyleague.R
import com.ahl.annahockeyleague.kotlin.adapters.ViewPager2Adapter
import com.ahl.annahockeyleague.kotlin.data.AhlData
import com.ahl.annahockeyleague.kotlin.data.Fixtures
import com.ahl.annahockeyleague.kotlin.kotlinfragments.kotlinFixtures.KotlinFixturesMen
import com.ahl.annahockeyleague.kotlin.kotlinfragments.kotlinHome.KotlinHomeMen
import com.ahl.annahockeyleague.kotlin.kotlinfragments.kotlinHome.KotlinHomeWomen
import com.ahl.annahockeyleague.kotlin.kotlinfragments.kotlinTeam.KotlinMenTeam
import com.ahl.annahockeyleague.kotlin.kotlinfragments.kotlinTeam.KotlinWomenTeam
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.home_page.*

class AhlFragment : Fragment() {

    private val ahlViewModel by activityViewModels<AhlViewModel>()
    private lateinit var disposable : Disposable

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.home_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){

        ahlViewModel.getAhlData()
//        adapterCode()

        disposable = ahlViewModel.ahlDataStream.observeOn(Schedulers.from(UIThreadExecutor())).subscribe{

            val tag = "ahlDataStream"

            Log.d(tag + "men", it.fixturesMen.toString())
            Log.d(tag, it.fixturesWoMen.toString())
            Log.d(tag  +"men", it.pointsTableMen.toString())
            Log.d(tag, it.pointsTableWoMen.toString())
            Log.d(tag  +"men", it.topScorersMen.toString())
            Log.d(tag, it.topScorersWoMen.toString())

        }

    }

    private fun adapterCode() {
        val adapter = ViewPager2Adapter(this)

        val homeList = mutableListOf(KotlinHomeMen(), KotlinHomeWomen())
        val fixturesList = mutableListOf(KotlinFixturesMen())
        val teamLIst = mutableListOf(KotlinMenTeam(), KotlinWomenTeam())

        viewpager2.adapter = adapter

        ahl_bottom_nav.setOnNavigationItemSelectedListener {
            when(it.itemId){

                R.id.kotlinHome -> {
                    adapter.updateList(homeList)
                }

                R.id.kotlinFixtures -> {
                    viewpager2.adapter = ViewPager2Adapter(this)
                    adapter.updateList(fixturesList)
                }

                R.id.kotlinTeam -> adapter.updateList(teamLIst)
            }

            true
        }
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