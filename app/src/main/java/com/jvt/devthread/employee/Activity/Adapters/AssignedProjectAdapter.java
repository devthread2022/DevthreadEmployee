package com.jvt.devthread.employee.Activity.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jvt.devthread.employee.Activity.Model.AssignedProjectModel;
import com.jvt.devthread.employee.R;

import java.util.List;

public class AssignedProjectAdapter extends RecyclerView.Adapter<AssignedProjectAdapter.ViewHolder> {
    private Context context;
    public List<AssignedProjectModel> assignedProjectModelList;

    public AssignedProjectAdapter(Context context, List<AssignedProjectModel> assignedProjectModelList) {
        this.context = context;
        this.assignedProjectModelList = assignedProjectModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.assigned_project_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AssignedProjectModel assignedProjectModel = assignedProjectModelList.get(position);
        holder.projectId.setText(assignedProjectModel.getProjectId());
        holder.projectName.setText(assignedProjectModel.getProjectName());
        holder.projectDomain.setText(assignedProjectModel.getProjectDomain());
        holder.assignedBy.setText(assignedProjectModel.getAssignedBy());
        holder.projectStatus.setText(assignedProjectModel.getProjectStatus());
        holder.deadline.setText(assignedProjectModel.getDeadline());
        holder.priority.setText(assignedProjectModel.getPriority());
    }

    @Override
    public int getItemCount() {
        return assignedProjectModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView projectId, projectName, projectDomain, assignedBy, projectStatus, deadline, priority, details;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            projectId = itemView.findViewById(R.id.project_id);
            projectName = itemView.findViewById(R.id.project_name);
            projectDomain = itemView.findViewById(R.id.project_domain);
            assignedBy = itemView.findViewById(R.id.assignee);
            projectStatus = itemView.findViewById(R.id.status);
            deadline = itemView.findViewById(R.id.deadline);
            priority = itemView.findViewById(R.id.priority);
            details = itemView.findViewById(R.id.details);
        }
    }
}
