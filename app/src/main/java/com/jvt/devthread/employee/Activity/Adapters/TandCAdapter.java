package com.jvt.devthread.employee.Activity.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.jvt.devthread.employee.Activity.Model.TandCModel;
import com.jvt.devthread.employee.R;

import java.util.List;

public class TandCAdapter extends RecyclerView.Adapter<TandCAdapter.ViewHolder> {
    public Context context;
    private List<TandCModel> tandCModelList;

    public TandCAdapter(Context context, List<TandCModel> tandCModelList) {
        this.context = context;
        this.tandCModelList = tandCModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tandc_item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TandCModel tandCModel = tandCModelList.get(position);
        holder.heading.setText(tandCModel.getHeading());
        holder.subHeading.setText(tandCModel.getSubheading());
    }

    @Override
    public int getItemCount() {
        return tandCModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView heading, subHeading;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            heading = itemView.findViewById(R.id.heading);
            subHeading = itemView.findViewById(R.id.subHeading);
        }
    }
}
