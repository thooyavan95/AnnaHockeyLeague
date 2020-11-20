package com.ahl.annahockeyleague.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPager2Adapter(fragment : Fragment) : FragmentStateAdapter(fragment) {

    private val fragmentList = mutableListOf<Fragment>()

    override fun getItemCount(): Int {
            if(fragmentList.isEmpty()){
                return 0
            }
            return fragmentList.size
    }


    override fun createFragment(position: Int): Fragment {

       return when(position){
            0 ->  fragmentList[position]
            1 ->  fragmentList[position]
            else -> null!!
        }

    }

    fun updateList(list : List<Fragment>){
        fragmentList.clear()
        fragmentList.addAll(list)
    }

    fun getTitleList(position : Int) : String = arrayListOf("Men", "Women")[position]


}