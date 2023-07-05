package com.codegrace.Saklo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class FacilityAdapter(
    private val context: Context,
    private val healthFacilityDataList: List<HealthFacilityData>
) : RecyclerView.Adapter<FacilityAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.recyclerv_facility_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Glide.with(context).load(healthFacilityDataList[position].faciImage).into(holder.recyclerImage)
        holder.recyclerName.text = healthFacilityDataList[position].faciName
        holder.recyclerType.text = healthFacilityDataList[position].faciType
        holder.recyclerLocation.text = healthFacilityDataList[position].faciAddress
    }

    override fun getItemCount(): Int {
        return healthFacilityDataList.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recyclerImage: ImageView = itemView.findViewById(R.id.recyclerImage)
        val recyclerName: TextView = itemView.findViewById(R.id.recyclerName)
        val recyclerType: TextView = itemView.findViewById(R.id.recyclerType)
        val recyclerLocation: TextView = itemView.findViewById(R.id.recyclerLocation)
        val recyclerCard: CardView = itemView.findViewById(R.id.recyclerCard)
    }
}
