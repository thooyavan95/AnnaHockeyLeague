package com.ahl.annahockeyleague.kotlin.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter


class FragmentAdapter(fm : FragmentManager) : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private var listOfFragments : List<Fragment>? = null

    override fun getItem(position: Int): Fragment = listOfFragments!![position]

    override fun getCount(): Int {
        if(listOfFragments == null){
            return 0
        }
        return listOfFragments!!.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
         return when(position){
             0 -> "MEN"
             1-> "WOMEN"
             else -> null
        }
    }

    fun updateFragmentList(fragmentList : List<Fragment>){
        listOfFragments = fragmentList
    }

}