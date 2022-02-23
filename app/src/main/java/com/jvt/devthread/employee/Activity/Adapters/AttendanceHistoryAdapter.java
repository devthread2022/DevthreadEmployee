package com.jvt.devthread.employee.Activity.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jvt.devthread.employee.Activity.Model.AttendanceModel;
import com.jvt.devthread.employee.R;

import java.util.List;

public class AttendanceHistoryAdapter extends RecyclerView.Adapter<AttendanceHistoryAdapter.ViewHolder> {
    private Context context;
    public List<AttendanceModel> attendanceModelList;

    public AttendanceHistoryAdapter(Context context, List<AttendanceModel> attendanceModelList) {
        this.context = context;
        this.attendanceModelList = attendanceModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.attendance_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AttendanceModel attendanceModel = attendanceModelList.get(position);
        holder.workingHr.setText(attendanceModel.getWorkingHr());
        holder.able.setText(attendanceModel.getAbleToWork());
        holder.aId.setText(attendanceModel.getAttendanceId());
        holder.location.setText(attendanceModel.getEmpLocation());
        holder.date.setText(attendanceModel.getDate());
        holder.approvedBy.setText(attendanceModel.getApprovedBy());
        holder.status.setText(attendanceModel.getAttendanceStatus());
        if (attendanceModel.getAttendanceStatus().equals("Approved")){
            holder.back.setBackgroundColor(Color.parseColor("#4CAF50"));
        }

    }

    @Override
    public int getItemCount() {
        return attendanceModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView workingHr, able, aId, location, date, approvedBy, status;
        LinearLayout back;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            workingHr = itemView.findViewById(R.id.hr);
            able = itemView.findViewById(R.id.able);
            aId = itemView.findViewById(R.id.attendance_id);
            location = itemView.findViewById(R.id.location);
            date = itemView.findViewById(R.id.date);
            approvedBy = itemView.findViewById(R.id.approved_by);
            status = itemView.findViewById(R.id.status);
            back = itemView.findViewById(R.id.status_back);
        }
    }
}
