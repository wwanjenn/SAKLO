package com.codegrace.Saklo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView.RecyclerListener
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView


class remediesAdapter(
    private val context: Context,
    private var remediesList: List<RemediesModel>
    ): RecyclerView.Adapter<remediesAdapter.remediesViewHolder>() {


    fun addItems(items: ArrayList<RemediesModel>){
        this.remediesList = items
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
        holder.id.text = remediesList[position].id.toString()
        holder.nameCommon.text = remediesList[position].nameCommon
        holder.nameScientific.text = remediesList[position].nameScientific
    }


    fun searchDataList(searchList: ArrayList<RemediesModel>) {
        remediesList = searchList
        notifyDataSetChanged()
    }

    class remediesViewHolder(var view: View): RecyclerView.ViewHolder(view){
        var id = view.findViewById<TextView>(R.id.recyclerId)
        var nameCommon = view.findViewById<TextView>(R.id.recyclerNameCommon)
        var nameScientific = view.findViewById<TextView>(R.id.recyclerNameScientific)
    }


}