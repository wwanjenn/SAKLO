package com.codegrace.Saklo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView.RecyclerListener
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.codegrace.Saklo.activities.RemediesActivity


class remediesAdapter(
    private val context: Context,
    private var remediesList: List<RemediesModel>,
    private val listener: OnItemClickListener
    ): RecyclerView.Adapter<remediesAdapter.remediesViewHolder>() {


    fun addItems(items: ArrayList<RemediesModel>){
        this.remediesList = items
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): remediesAdapter.remediesViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.card_items_remedies, parent, false)

        return remediesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return remediesList.size
    }

    override fun onBindViewHolder(holder: remediesViewHolder, position: Int) {
//        Glide.with(context).load(healthFacilityDataList[position].faciImage).into(holder.recyclerImage)
        holder.nameCommon.text = remediesList[position].nameCommon
        holder.nameScientific.text = remediesList[position].nameScientific
    }

    inner class remediesViewHolder(var view: View): RecyclerView.ViewHolder(view), View.OnClickListener {
        var nameCommon= view.findViewById<TextView>(R.id.recyclerNameCommon)
        var nameScientific = view.findViewById<TextView>(R.id.recyclerNameScientific)

        init{
            view.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position: Int = adapterPosition
            if(position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }

}