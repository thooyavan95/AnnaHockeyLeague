package com.ahl.annahockeyleague.kotlin.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ahl.annahockeyleague.R
import com.ahl.annahockeyleague.kotlin.data.Team
import kotlinx.android.synthetic.main.team_template.view.*

class TeamsAdapter(private val teamListener: TeamListener) : RecyclerView.Adapter<TeamsAdapter.TeamsViewHolder>() {

    private var teamsList : List<Team>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.team_template, parent, false)
        return TeamsViewHolder(view)
    }

    override fun getItemCount(): Int {

        if(teamsList == null || teamsList!!.isEmpty()){
            return 0
        }

        return teamsList!!.size
    }

    override fun onBindViewHolder(holder: TeamsViewHolder, position: Int) {

        holder.onBindViews(teamsList!![position])
    }

    fun updateItems(teams : List<Team>){
        teamsList = teams
        notifyDataSetChanged()
    }

    inner class TeamsViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        fun onBindViews(team : Team){
            itemView.team_name.text = team.name
            itemView.setOnClickListener {
                if(adapterPosition != RecyclerView.NO_POSITION){
                    teamListener.onTeamSelected(adapterPosition)
                }
            }
        }

    }

    interface TeamListener{
        fun onTeamSelected(position: Int)
    }
}