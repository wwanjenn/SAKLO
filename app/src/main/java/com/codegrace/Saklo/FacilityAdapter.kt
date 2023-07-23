package com.codegrace.Saklo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class FacilityAdapter(
    private val context: Context,
    private var healthFacilityDataList: List<HealthFacilityData>
) : RecyclerView.Adapter<FacilityAdapter.MyViewHolder>() {

    private var expandedPosition: Int = -1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.recyclerv_facility_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val isExpanded = position == expandedPosition

        // Handle the visibility of the lower_card layout
        holder.lowerCard.visibility = if (isExpanded) View.VISIBLE else View.GONE

        // Bind data to other views as usual
        holder.recyclerName.text = healthFacilityDataList[position].facilityName
        holder.recyclerType.text = healthFacilityDataList[position].healthFacilityType
        holder.recyclerClassif.text = healthFacilityDataList[position].ownershipMajorClassification
        holder.recyclerLocation.text = healthFacilityDataList[position].cityMunicipalityName
        holder.recyclerLocation2.text = healthFacilityDataList[position].provinceName

        // Set click listener on the card to toggle the expanded position
        holder.recyclerCard.setOnClickListener {
            expandedPosition = if (isExpanded) -1 else position
            notifyDataSetChanged()
        }
    }


    override fun getItemCount(): Int {
        return healthFacilityDataList.size + if (expandedPosition != -1) 1 else 0
    }

    fun searchDataList(searchList: ArrayList<HealthFacilityData>) {
        healthFacilityDataList = searchList
        notifyDataSetChanged()
    }


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val recyclerImage: ImageView = itemView.findViewById(R.id.recyclerImage)
        val recyclerName: TextView = itemView.findViewById(R.id.recyclerName)
        val recyclerType: TextView = itemView.findViewById(R.id.recyclerType)
        val recyclerLocation: TextView = itemView.findViewById(R.id.recyclerLocation)
        val recyclerLocation2: TextView = itemView.findViewById(R.id.recyclerLocation2)
        val recyclerCard: CardView = itemView.findViewById(R.id.recyclerCard)
        val recyclerClassif:TextView = itemView.findViewById(R.id.recyclerClassif)
        val lowerCard: RelativeLayout = itemView.findViewById(R.id.lower_card)
    }
}
