package com.ahl.annahockeyleague.kotlin.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ahl.annahockeyleague.R
import com.ahl.annahockeyleague.kotlin.data.TopScorers
import kotlinx.android.synthetic.main.top_scorer_row_template.view.*

class TopScorersAdapter : RecyclerView.Adapter<TopScorersAdapter.TopScorersViewHolder>() {

    private var topScorersData : List<TopScorers>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopScorersViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.top_scorer_row_template, parent, false)
        return TopScorersViewHolder(view)
    }

    override fun getItemCount(): Int {

        if(topScorersData == null){
            return 0
        }
        return topScorersData!!.size
    }

    override fun onBindViewHolder(holder: TopScorersViewHolder, position: Int) {
        holder.bindViews(topScorersData!![position])
    }

    fun updateTOpScorersData(topScorersDataList : List<TopScorers>){
        topScorersData = topScorersDataList
        notifyDataSetChanged()
    }

    inner class TopScorersViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        fun bindViews(topScorersObject: TopScorers) {

            itemView.top_scorer_name.text = topScorersObject.player.name
            itemView.top_scorer_team.text = topScorersObject.team.name
            itemView.top_scorer_goals.text = topScorersObject.goals.toString()
        }

    }

}