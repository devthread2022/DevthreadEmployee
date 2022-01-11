package com.jvt.devthread.employee.Activity.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jvt.devthread.employee.Activity.Model.SelectedFeatureModel;
import com.jvt.devthread.employee.R;


import java.util.List;


public class SelectedFeaturesAdapter extends RecyclerView.Adapter<SelectedFeaturesAdapter.ViewHolder> {
    public Context context;
    private List<SelectedFeatureModel> selectedFeatureModelList;

    public SelectedFeaturesAdapter(Context context, List<SelectedFeatureModel> selectedFeatureModelList) {
        this.context = context;
        this.selectedFeatureModelList = selectedFeatureModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_product_added_feature_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(selectedFeatureModelList.get(position).getFeatureName());
        Glide.with(context).load(selectedFeatureModelList.get(position).getFeatureIcon()).into(holder.icon);
    }

    @Override
    public int getItemCount() {
        return selectedFeatureModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView icon;
        TextView name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.product_added_feature_image);
            name = itemView.findViewById(R.id.product_added_feature_name);
        }
    }
}
