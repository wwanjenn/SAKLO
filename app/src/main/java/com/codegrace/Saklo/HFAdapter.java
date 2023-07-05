package com.codegrace.Saklo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class HFAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private Context context;
    private List<HealthFacilityData> healthFacilityDataList;

    public HFAdapter(Context context, List<HealthFacilityData> healthFacilityDataList) {
        this.context = context;
        this.healthFacilityDataList = healthFacilityDataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerv_facility_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(context).load(healthFacilityDataList.get(position).getFaciImage()).into(holder.recyclerImage);
        holder.recyclerName.setText(healthFacilityDataList.get(position).getFaciName());
        holder.recyclerType.setText(healthFacilityDataList.get(position).getFaciType());
        holder.recyclerLocation.setText(healthFacilityDataList.get(position).getFaciAddress());
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}

class MyViewHolder extends RecyclerView.ViewHolder {

    ImageView recyclerImage;
    TextView recyclerName, recyclerType, recyclerLocation;
    CardView recyclerCard;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        recyclerImage = itemView.findViewById(R.id.recyclerImage);
        recyclerName = itemView.findViewById(R.id.recyclerName);
        recyclerType = itemView.findViewById(R.id.recyclerType);
        recyclerLocation = itemView.findViewById(R.id.recyclerLocation);
        recyclerCard = itemView.findViewById(R.id.recyclerCard);
    }
}