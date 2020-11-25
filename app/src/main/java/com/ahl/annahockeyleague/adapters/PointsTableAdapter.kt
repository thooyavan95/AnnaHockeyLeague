package com.ahl.annahockeyleague.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ahl.annahockeyleague.R
import com.ahl.annahockeyleague.ahlUtils.LogoUtility
import com.ahl.annahockeyleague.data.PointsTableData
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.points_table_row_template.view.*

class PointsTableAdapter : RecyclerView.Adapter<PointsTableAdapter.PointsTableViewHolder>() {

    private var pointsTableDataData : List<PointsTableData>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PointsTableViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.points_table_row_template, parent, false)
        return PointsTableViewHolder(view)
    }

    override fun getItemCount(): Int {

        if(pointsTableDataData != null){
            return pointsTableDataData!!.size + 1
        }

        return 0
    }

    override fun onBindViewHolder(holder: PointsTableViewHolder, position: Int) {
        if(position == 0){
            holder.bindHeader()
        }else{
            holder.bindViews(pointsTableDataData!![position - 1])
        }

    }

    fun updatePointsTableData(pointsTableDataDataList : List<PointsTableData>){
        pointsTableDataData = pointsTableDataDataList
        notifyDataSetChanged()
    }

    inner class PointsTableViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        fun bindViews(pointsTableDataData: PointsTableData) {
            itemView.PT_row_team_name.text = pointsTableDataData.team.teamTag.tag
            itemView.PT_row_position.text = pointsTableDataData.position.toString()
            itemView.PT_row_win.text = pointsTableDataData.won.toString()
            itemView.PT_row_loss.text = pointsTableDataData.lost.toString()
            itemView.PT_row_draw.text = pointsTableDataData.draw.toString()
            itemView.PT_row_goalDiff.text = pointsTableDataData.goalDifference.toString()
            itemView.PT_row_position.text = pointsTableDataData.position.toString()
            itemView.PT_row_matches_played.text = pointsTableDataData.matchesPlayed.toString()
            itemView.PT_row_points.text = pointsTableDataData.points.toString()

            val teamLogo = LogoUtility.getTeamLogo(pointsTableDataData.team.teamTag)
            Picasso.get().load(teamLogo).into(itemView.PT_row_team_logo)
        }

        fun bindHeader() {

            itemView.PT_row_win.text = "W"
            itemView.PT_row_loss.text = "L"
            itemView.PT_row_draw.text = "D"
            itemView.PT_row_goalDiff.text = "GD"
            itemView.PT_row_matches_played.text = "P"
            itemView.PT_row_points.text = "PT"

        }

    }

}