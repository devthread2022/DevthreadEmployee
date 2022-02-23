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

import com.jvt.devthread.employee.Activity.Model.LeaveModel;
import com.jvt.devthread.employee.R;

import java.util.List;

public class LeaveHistoryAdapter extends RecyclerView.Adapter<LeaveHistoryAdapter.ViewHolder> {
    private Context context;
    public List<LeaveModel> leaveModelList;

    public LeaveHistoryAdapter(Context context, List<LeaveModel> leaveModelList) {
        this.context = context;
        this.leaveModelList = leaveModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.leave_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LeaveModel leaveModel = leaveModelList.get(position);
        holder.days.setText(leaveModel.getTotalDays());
        holder.type.setText(leaveModel.getLeaveType());
        holder.lid.setText(leaveModel.getLeaveId());
        holder.from.setText(leaveModel.getFromDate());
        holder.to.setText(leaveModel.getToDate());
        holder.date.setText(leaveModel.getApplyDate());
        holder.status.setText(leaveModel.getLeaveStatus());
        if (leaveModel.getLeaveStatus().equals("Approved")){
            holder.back.setBackgroundColor(Color.parseColor("#4CAF50"));
        }

    }

    @Override
    public int getItemCount() {
        return leaveModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView days, type, lid, from, to, date, status;
        LinearLayout back;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            days = itemView.findViewById(R.id.days);
            type = itemView.findViewById(R.id.l_type);
            lid = itemView.findViewById(R.id.leave_id);
            from = itemView.findViewById(R.id.from);
            to = itemView.findViewById(R.id.to);
            date = itemView.findViewById(R.id.date);
            status = itemView.findViewById(R.id.status);
            back = itemView.findViewById(R.id.status_back);

        }
    }
}
