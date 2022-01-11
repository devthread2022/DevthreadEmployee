package com.jvt.devthread.employee.Activity.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jvt.devthread.employee.Activity.Model.WorkUpdateModel;
import com.jvt.devthread.employee.R;

import java.util.List;

public class WorkUpdateAdapter extends RecyclerView.Adapter<WorkUpdateAdapter.ViewHolder> {
    public Context context;
    private List<WorkUpdateModel> workUpdateModelList;

    public WorkUpdateAdapter(Context context, List<WorkUpdateModel> workUpdateModelList) {
        this.context = context;
        this.workUpdateModelList = workUpdateModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.work_update_layout,parent,false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        WorkUpdateModel workUpdateModel = workUpdateModelList.get(position);
        holder.work.setText(workUpdateModel.getTask());
        holder.date.setText(workUpdateModel.getUpdateTime());
        holder.by.setText("Updated by: "+workUpdateModel.getUpdatedBy());
        holder.hour.setText("Total hour: "+workUpdateModel.getNoOfHour());
        holder.empCount.setText("No of employee worked: "+workUpdateModel.getNoOfPeople());

    }

    @Override
    public int getItemCount() {
        return workUpdateModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView work, empCount, hour, by, date;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            work = itemView.findViewById(R.id.work);
            empCount = itemView.findViewById(R.id.count);
            hour = itemView.findViewById(R.id.hour);
            by = itemView.findViewById(R.id.by);
            date = itemView.findViewById(R.id.time);
        }
    }
}
