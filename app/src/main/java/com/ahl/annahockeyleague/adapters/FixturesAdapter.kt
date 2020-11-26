package com.ahl.annahockeyleague.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ahl.annahockeyleague.R
import com.ahl.annahockeyleague.utils.DateUtility
import com.ahl.annahockeyleague.utils.AhlUtils
import com.ahl.annahockeyleague.data.FixturesData
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fixture_template.view.*

class FixturesAdapter : RecyclerView.Adapter<FixturesAdapter.FixturesViewHolder>() {

    private var fixturesDataList : List<FixturesData>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FixturesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fixture_layout, parent ,false)
        return FixturesViewHolder(view)
    }

    override fun getItemCount(): Int {

        if(fixturesDataList == null || fixturesDataList!!.isEmpty()){
            return 0
        }

        return fixturesDataList!!.size
    }

    override fun onBindViewHolder(holder: FixturesViewHolder, position: Int) {
        holder.onBindViews(fixturesDataList!![position])
    }

    fun updateFixturesData(fixturesDataListData : List<FixturesData>){
        fixturesDataList = fixturesDataListData
        notifyDataSetChanged()
    }

    class FixturesViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        fun onBindViews(fixturesDataData : FixturesData) {

            itemView.next_match_fixture_date.text = DateUtility.formattedDate(fixturesDataData.matchDateTime)
            itemView.next_match_team1_name.text = fixturesDataData.team1.name
            itemView.next_match_team2_name.text = fixturesDataData.team2.name
            itemView.next_match_team1_score.text = AhlUtils.getScore(fixturesDataData.team1Scorers)
            itemView.next_match_team2_score.text = AhlUtils.getScore(fixturesDataData.team2Scorers)

            val team1Logo = AhlUtils.getTeamLogo(fixturesDataData.team1.teamTag)
            val team2Logo = AhlUtils.getTeamLogo(fixturesDataData.team2.teamTag)
            Picasso.get().load(team1Logo).into(itemView.next_match_team1_image)
            Picasso.get().load(team2Logo).into(itemView.next_match_team2_image)
        }


    }



}