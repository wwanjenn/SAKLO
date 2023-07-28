package com.codegrace.Saklo

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton

class FacilityAdapter(
    private val context: Context,
    private var healthFacilityDataList: List<HealthFacilityData>
) : RecyclerView.Adapter<FacilityAdapter.MyViewHolder>() {

    private var expandedPosition: Int = -1
    private var onItemClickListener: ((Int) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.recyclerv_facility_item, parent, false)
        return MyViewHolder(view)
    }

    private fun formatString(str: String?): String {
        return if (str.isNullOrEmpty() || str.equals("None", ignoreCase = true) || str.equals(" ", ignoreCase = true)) {
            "N/A"
        } else {
            str
        }
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        if (healthFacilityDataList.isEmpty() || position < 0 || position >= healthFacilityDataList.size) {
            return
        }


        val isExpanded = position == expandedPosition
        val specificAddText = "${healthFacilityDataList[position].streetName}, ${healthFacilityDataList[position].barangayName}"

        // Handle the visibility of the lower_card layout
        holder.lowerCard.visibility = if (isExpanded) View.VISIBLE else View.GONE

        // Bind data to other views as usual
        holder.recyclerName.text = formatString(healthFacilityDataList[position].facilityName)
        holder.recyclerType.text = formatString(healthFacilityDataList[position].healthFacilityType)
        holder.recyclerClassif.text = formatString(healthFacilityDataList[position].ownershipMajorClassification)
        holder.recyclerLocation.text = formatString(healthFacilityDataList[position].cityMunicipalityName)
        holder.recyclerLocation2.text = formatString(healthFacilityDataList[position].provinceName)

        holder.bedCap.text = formatString(healthFacilityDataList[position].bedCapacity)
        holder.offWeb.text = formatString(healthFacilityDataList[position].officialWebsite)
        holder.serviceCap.text = formatString(healthFacilityDataList[position].serviceCapabilities)
        holder.hfCode.text = formatString(healthFacilityDataList[position].healthFacilityCode)
        holder.landlineNum.text = formatString(healthFacilityDataList[position].landlineNumber)
        holder.mailAdd.text = formatString(healthFacilityDataList[position].emailAddress)
        holder.specificAdd.text = formatString(specificAddText)


        // Disable the btn_contacthf based on landlineNumber
        holder.btnContact.isEnabled = !(healthFacilityDataList[position].landlineNumber.isNullOrEmpty() ||
                healthFacilityDataList[position].landlineNumber.equals("None", ignoreCase = true) ||
                healthFacilityDataList[position].landlineNumber.equals(" ", ignoreCase = true))

        // Disable the btn_emailhf based on emailAddress
        holder.btnEmail.isEnabled = !(healthFacilityDataList[position].emailAddress.isNullOrEmpty() ||
                healthFacilityDataList[position].emailAddress.equals("None", ignoreCase = true) ||
                healthFacilityDataList[position].emailAddress.equals(" ", ignoreCase = true))

        // Set click listener on the card to toggle the expanded position
        holder.recyclerCard.setOnClickListener {
            expandedPosition = if (isExpanded) -1 else holder.adapterPosition
            notifyDataSetChanged()
        }
    }


    override fun getItemCount(): Int {
        return healthFacilityDataList.size + if (expandedPosition != -1) 0 else 0
    }

    fun searchDataList(searchList: ArrayList<HealthFacilityData>) {
        healthFacilityDataList = searchList
        notifyDataSetChanged()
    }


    fun setOnItemClickListener(listener: (Int) -> Unit) {
        onItemClickListener = listener
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recyclerName: TextView = itemView.findViewById(R.id.recyclerName)
        val recyclerType: TextView = itemView.findViewById(R.id.recyclerType)
        val recyclerLocation: TextView = itemView.findViewById(R.id.recyclerLocation)
        val recyclerLocation2: TextView = itemView.findViewById(R.id.recyclerLocation2)
        val recyclerCard: CardView = itemView.findViewById(R.id.recyclerCard)
        val recyclerClassif:TextView = itemView.findViewById(R.id.recyclerClassif)
        val specificAdd:TextView = itemView.findViewById(R.id.desc_addspec)
        val bedCap:TextView = itemView.findViewById(R.id.desc_bedcap)
        val serviceCap:TextView = itemView.findViewById(R.id.desc_servcap)
        val offWeb:TextView = itemView.findViewById(R.id.desc_offweb)
        val hfCode:TextView = itemView.findViewById(R.id.desc_codesh)
        val landlineNum:TextView = itemView.findViewById(R.id.desc_landl)
        val mailAdd:TextView = itemView.findViewById(R.id.desc_email)
        val lowerCard: RelativeLayout = itemView.findViewById(R.id.lower_card)

        val btnContact: MaterialButton = itemView.findViewById(R.id.btn_contacthf)
        val btnEmail: MaterialButton = itemView.findViewById(R.id.btn_emailhf)
        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onItemClickListener?.invoke(position)
                }
            }

            // Add click listener for btn_contacthf
            btnContact.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val facility = healthFacilityDataList[position]

                    // Get the landline number from the Facility object
                    val landlineNumber = facility.landlineNumber

                    // Check if the landline number is not empty or "N/A" or "None"
                    if (landlineNumber != null) {
                        if (landlineNumber.isNotBlank() && landlineNumber != "N/A" && landlineNumber != "None") {
                            // Create an implicit intent to open the dialer with the number pre-filled
                            val dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$landlineNumber"))
                            itemView.context.startActivity(dialIntent)
                        } else {
                            // Landline number is empty, show a toast or handle accordingly
                            Toast.makeText(itemView.context, "Landline number is not available.", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }

            // Add click listener for btn_emailhf
            btnEmail.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val facility = healthFacilityDataList[position]

                    // Get the email address from the Facility object
                    val emailAddress = facility.emailAddress

                    // Check if the email address is not empty or "N/A" or "None"
                    if (emailAddress != null) {
                        if (emailAddress.isNotBlank() && emailAddress != "N/A" && emailAddress != "None") {
                            // Create an implicit intent to send an email
                            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                                data = Uri.parse("mailto:$emailAddress")
                            }
                            itemView.context.startActivity(emailIntent)
                        } else {
                            // Email address is empty, show a toast or handle accordingly
                            Toast.makeText(itemView.context, "Email address is not available.", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }
    }
}
