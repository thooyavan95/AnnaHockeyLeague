package com.ahl.annahockeyleague.kotlin.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ahl.annahockeyleague.R
import com.ahl.annahockeyleague.kotlin.data.PointsTable
import kotlinx.android.synthetic.main.points_table_row_template.view.*

class PointsTableAdapter : RecyclerView.Adapter<PointsTableAdapter.PointsTableViewHolder>() {

    private var pointsTableData : List<PointsTable>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PointsTableViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.points_table_row_template, parent, false)
        return PointsTableViewHolder(view)
    }

    override fun getItemCount(): Int {

        if(pointsTableData != null){
            return pointsTableData!!.size
        }

        return 0
    }

    override fun onBindViewHolder(holder: PointsTableViewHolder, position: Int) {
        holder.bindViews(pointsTableData!![position])
    }

    fun updatePointsTableData(pointsTableDataList : List<PointsTable>){
        pointsTableData = pointsTableDataList
        notifyDataSetChanged()
    }

    inner class PointsTableViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        fun bindViews(pointsTableData: PointsTable) {
            itemView.PT_row_team_name.text = pointsTableData.team.teamTag.shortTeamName
            itemView.PT_row_position.text = pointsTableData.position.toString()
            itemView.PT_row_win.text = pointsTableData.won.toString()
            itemView.PT_row_loss.text = pointsTableData.lost.toString()
            itemView.PT_row_draw.text = pointsTableData.draw.toString()
            itemView.PT_row_goalDiff.text = pointsTableData.goalDifference.toString()
            itemView.PT_row_position.text = pointsTableData.position.toString()
            itemView.PT_row_matches_played.text = pointsTableData.matchesPlayed.toString()
            itemView.PT_row_points.text = pointsTableData.points.toString()
        }

    }

}