package com.jvt.devthread.employee.Activity.Adapters;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.jvt.devthread.employee.Activity.Common.Common;
import com.jvt.devthread.employee.Activity.Model.OrderModel;
import com.jvt.devthread.employee.Feature.AssignedWorkDetail;
import com.jvt.devthread.employee.Feature.UpdateDemoRequest;
import com.jvt.devthread.employee.Feature.UpdateUXStatus;
import com.jvt.devthread.employee.R;

import java.util.List;

public class UXAdapter extends RecyclerView.Adapter<UXAdapter.ViewHolder> {
    public Context context;
    private List<OrderModel> orderModelList;

    public UXAdapter(Context context, List<OrderModel> orderModelList) {
        this.context = context;
        this.orderModelList = orderModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.assigned_order_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        OrderModel orderModel = orderModelList.get(position);
        holder.orderId.setText(orderModel.getOrderId());
        holder.status.setText(orderModel.getOrderStatus());
        holder.work.setText("UX");
        holder.priority.setText(orderModel.getPriority());
        holder.pName.setText(orderModel.getProductName());
        holder.pDomain.setText(orderModel.getProductDomain());
        holder.aName.setText(orderModel.getAssignedBy());
        holder.deadline.setText(orderModel.getDueDate());
        holder.itemView.setOnClickListener(view -> {
            AppCompatActivity activity = (AppCompatActivity) view.getContext();
            Common.orderId = orderModelList.get(position).getOrderId();
            Common.empName = orderModelList.get(position).getAssignedTo();
            Common.pType = orderModelList.get(position).getProductType();
            Common.pId = orderModelList.get(position).getProductId();
            Common.pPlatform = orderModelList.get(position).getProductPlatform();
            Common.dTag = orderModelList.get(position).getDomainTag();
            Common.uFeateures = orderModelList.get(position).getUnselectedFeatures();
            Fragment orderDetails = new AssignedWorkDetail();
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,orderDetails)
                    .addToBackStack(null).commit();
        });
        holder.update.setOnClickListener(view -> {
            AppCompatActivity activity = (AppCompatActivity) view.getContext();
            Common.orderId = orderModelList.get(position).getOrderId();
            Common.empName = orderModelList.get(position).getAssignedTo();
            Fragment update = new UpdateUXStatus();
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,update)
                    .addToBackStack(null).commit();
        });
        holder.phone.setOnClickListener(view -> {
            String contact = orderModelList.get(position).getAssigneeContact();
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:"+contact));
            view.getContext().startActivity(callIntent);
        });
    }

    @Override
    public int getItemCount() {
        return orderModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView orderId, status,work,priority,pName,pDomain,aName,update,deadline;
        ImageView phone;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            orderId = itemView.findViewById(R.id.ord_id);
            status = itemView.findViewById(R.id.status);
            work = itemView.findViewById(R.id.work_type);
            priority = itemView.findViewById(R.id.priority);
            pName = itemView.findViewById(R.id.product_name);
            pDomain = itemView.findViewById(R.id.product_domain);
            aName = itemView.findViewById(R.id.assignee);
            update = itemView.findViewById(R.id.update);
            phone = itemView.findViewById(R.id.phone);
            deadline = itemView.findViewById(R.id.deadline);
        }
    }
}
