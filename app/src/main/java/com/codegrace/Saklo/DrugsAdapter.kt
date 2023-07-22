package com.codegrace.Saklo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView.RecyclerListener
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView


class DrugsAdapter(
    private val context: Context,
    private var drugsList: List<DrugsModel>
    ): RecyclerView.Adapter<DrugsAdapter.DrugsViewHolder>() {


    fun addItems(items: ArrayList<DrugsModel>){
        this.drugsList = items
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrugsAdapter.DrugsViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.card_items_drugs, parent, false)

        return DrugsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return drugsList.size
    }

    override fun onBindViewHolder(holder: DrugsViewHolder, position: Int) {
//        Glide.with(context).load(healthFacilityDataList[position].faciImage).into(holder.recyclerImage)
        holder.id.text = drugsList[position].id.toString()
        holder.nameScientific.text = drugsList[position].nameScientific
        holder.nameBrand.text = drugsList[position].nameBrand
        holder.category.text = drugsList[position].category

    }

    class DrugsViewHolder(var view: View): RecyclerView.ViewHolder(view){
        var category = view.findViewById<TextView>(R.id.recyclerCategory)
        var id = view.findViewById<TextView>(R.id.recyclerId)
        var nameScientific = view.findViewById<TextView>(R.id.recyclerNameScientific)
        var nameBrand = view.findViewById<TextView>(R.id.recyclerNameBrand)
    }


}