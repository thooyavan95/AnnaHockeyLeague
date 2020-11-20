package com.ahl.annahockeyleague.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ahl.annahockeyleague.R
import com.ahl.annahockeyleague.data.FixturesData
import kotlinx.android.synthetic.main.fixture_template.view.*
import java.text.SimpleDateFormat
import java.util.*

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

            itemView.next_match_fixture_date.text = formattedDate(fixturesDataData.matchDateTime)
            itemView.next_match_team1_name.text = fixturesDataData.team1.name
            itemView.next_match_team2_name.text = fixturesDataData.team2.name
            itemView.next_match_team1_score.text = getScore(fixturesDataData.team1Scorers)
            itemView.next_match_team2_score.text = getScore(fixturesDataData.team2Scorers)
        }


        private fun getScore(scorers : Map<String, Int>?): String {
            if(scorers == null){
                return "0"
            }
            return scorers.values.sum().toString()

        }

        private fun formattedDate(timeInMillis : Long): String {

            val pattern = "dd/MMM/yyyy - hh:mm a"
            val date = Date(timeInMillis)
            val sdf = SimpleDateFormat(pattern, Locale.getDefault())
            return sdf.format(date)
        }


    }



}