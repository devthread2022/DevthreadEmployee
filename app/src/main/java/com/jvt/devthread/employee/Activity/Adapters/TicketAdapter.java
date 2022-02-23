package com.jvt.devthread.employee.Activity.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jvt.devthread.employee.Activity.Model.TicketModel;
import com.jvt.devthread.employee.R;

import java.util.List;

public class TicketAdapter extends RecyclerView.Adapter<TicketAdapter.ViewHolder> {
    private Context context;
    public List<TicketModel> ticketModelList;

    public TicketAdapter(Context context, List<TicketModel> ticketModelList) {
        this.context = context;
        this.ticketModelList = ticketModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ticket_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TicketModel ticketModel = ticketModelList.get(position);
        holder.time.setText(ticketModel.getTicketTime());
        holder.severity.setText(ticketModel.getSeverity());
        holder.tid.setText(ticketModel.getTicketId());
        holder.name.setText(ticketModel.getUserName());
        holder.email.setText(ticketModel.getUserEmail());
        holder.description.setText(ticketModel.getDescription());
        holder.status.setText(ticketModel.getTicketStatus());

    }

    @Override
    public int getItemCount() {
        return ticketModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView time, severity, tid, name, email, description, status;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            time = itemView.findViewById(R.id.raised_time);
            severity = itemView.findViewById(R.id.severity);
            tid = itemView.findViewById(R.id.ticket_id);
            name = itemView.findViewById(R.id.user_name);
            email = itemView.findViewById(R.id.user_email);
            description = itemView.findViewById(R.id.description);
            status = itemView.findViewById(R.id.txt_status);

        }
    }
}
