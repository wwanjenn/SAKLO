package com.codegrace.Saklo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView.RecyclerListener
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class remediesAdapter: RecyclerView.Adapter<remediesAdapter.remediesViewHolder>() {
    private var remediesList: ArrayList<RemediesModel> = ArrayList()

    fun addItems(items: ArrayList<RemediesModel>){
        this.remediesList = items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = remediesViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.card_items_remedies, parent, false)
    )

    override fun getItemCount(): Int {
        return remediesList.size
    }

    override fun onBindViewHolder(holder: remediesViewHolder, position: Int) {
        val remedies = remediesList[position]
        holder.bindView(remedies)
    }

    class remediesViewHolder(var view: View): RecyclerView.ViewHolder(view){
        private var id = view.findViewById<TextView>(R.id.tvId)
        private var nameCommon = view.findViewById<TextView>(R.id.tvNameCommon)
        private var nameScientific = view.findViewById<TextView>(R.id.tvNameScientific)


        fun bindView(remedies: RemediesModel){
            id.text = remedies.id.toString()
            nameCommon.text = remedies.nameCommon
            nameScientific.text = remedies.nameScientific
        }
    }


}