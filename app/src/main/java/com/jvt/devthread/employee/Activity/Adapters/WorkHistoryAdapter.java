package com.jvt.devthread.employee.Activity.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jvt.devthread.employee.Activity.Model.DailyWorkUpdateModel;
import com.jvt.devthread.employee.R;

import java.util.List;

public class WorkHistoryAdapter extends RecyclerView.Adapter<WorkHistoryAdapter.ViewHolder> {
    private Context context;
    public List<DailyWorkUpdateModel> dailyWorkUpdateModelList;

    public WorkHistoryAdapter(Context context, List<DailyWorkUpdateModel> dailyWorkUpdateModelList) {
        this.context = context;
        this.dailyWorkUpdateModelList = dailyWorkUpdateModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.work_update,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DailyWorkUpdateModel dailyWorkUpdateModel = dailyWorkUpdateModelList.get(position);
        holder.loc.setText(String.valueOf(dailyWorkUpdateModel.getLoc()));
        holder.workingHr.setText(dailyWorkUpdateModel.getTimeTaken());
        holder.id.setText(dailyWorkUpdateModel.getWorkId());
        holder.projectName.setText(dailyWorkUpdateModel.getProjectName());
        holder.workDone.setText(dailyWorkUpdateModel.getWorkDone());
        holder.date.setText(dailyWorkUpdateModel.getWorkDate());



    }

    @Override
    public int getItemCount() {
        return dailyWorkUpdateModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView loc, workingHr, id, projectName, workDone, date, details;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            loc = itemView.findViewById(R.id.loc);
            workingHr = itemView.findViewById(R.id.hr);
            id = itemView.findViewById(R.id.work_id);
            projectName = itemView.findViewById(R.id.project_name);
            workDone = itemView.findViewById(R.id.work_done);
            date = itemView.findViewById(R.id.date);
            details = itemView.findViewById(R.id.details);
        }
    }
}
