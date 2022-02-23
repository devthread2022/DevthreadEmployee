package com.jvt.devthread.employee.Activity.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jvt.devthread.employee.Activity.Model.HolidayCalenderModel;
import com.jvt.devthread.employee.R;

import java.util.List;

public class HolidayCalenderAdapter extends RecyclerView.Adapter<HolidayCalenderAdapter.ViewHolder> {
    private Context context;
    public List<HolidayCalenderModel> holidayCalenderModelList;

    public HolidayCalenderAdapter(Context context, List<HolidayCalenderModel> holidayCalenderModelList) {
        this.context = context;
        this.holidayCalenderModelList = holidayCalenderModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.holiday_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HolidayCalenderModel holidayCalenderModel = holidayCalenderModelList.get(position);
        holder.holidayName.setText(holidayCalenderModel.getHolidayName());
        holder.holidayDate.setText(holidayCalenderModel.getHolidayDate());
    }

    @Override
    public int getItemCount() {
        return holidayCalenderModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView holidayName, holidayDate;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            holidayName = itemView.findViewById(R.id.holidayName);
            holidayDate = itemView.findViewById(R.id.holidayDate);
        }

    }
}
