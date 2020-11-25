package com.ahl.annahockeyleague.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ahl.annahockeyleague.R
import com.ahl.annahockeyleague.data.Category
import com.ahl.annahockeyleague.data.TopScorersData
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.top_scorer_row_template.view.*

class TopScorersAdapter(private val category : Category) : RecyclerView.Adapter<TopScorersAdapter.TopScorersViewHolder>() {

    private var topScorersDataData : List<TopScorersData>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopScorersViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.top_scorer_row_template, parent, false)
        return TopScorersViewHolder(view)
    }

    override fun getItemCount(): Int {

        if(topScorersDataData == null){
            return 0
        }
        return topScorersDataData!!.size
    }

    override fun onBindViewHolder(holder: TopScorersViewHolder, position: Int) {
        holder.bindViews(topScorersDataData!![position])
    }

    fun updateTOpScorersData(topScorersDataDataList : List<TopScorersData>){
        topScorersDataData = topScorersDataDataList
        notifyDataSetChanged()
    }

    inner class TopScorersViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        fun bindViews(topScorersDataObject: TopScorersData) {

            itemView.top_scorer_name.text = topScorersDataObject.player.name
            itemView.top_scorer_team.text = topScorersDataObject.team.name
            itemView.top_scorer_goals.text = topScorersDataObject.goals.toString()

            when(category){

                Category.MEN -> Picasso.get().load(topScorersDataObject.player.profile)
                        .placeholder(R.drawable.men_image).into(itemView.top_scorer_avatar)
                Category.WOMEN -> Picasso.get().load(topScorersDataObject.player.profile)
                        .placeholder(R.drawable.women_image).into(itemView.top_scorer_avatar)
            }
        }

    }

}