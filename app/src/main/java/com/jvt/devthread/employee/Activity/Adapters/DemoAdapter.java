package com.jvt.devthread.employee.Activity.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.jvt.devthread.employee.Activity.Common.Common;
import com.jvt.devthread.employee.Activity.Model.AssignedDemoModel;
import com.jvt.devthread.employee.Feature.UpdateDemoRequest;
import com.jvt.devthread.employee.R;

import java.util.List;

public class DemoAdapter extends RecyclerView.Adapter<DemoAdapter.ViewHolder> {
    public Context context;
    private List<AssignedDemoModel> assignedDemoModelList;

    public DemoAdapter(Context context, List<AssignedDemoModel> assignedDemoModelList) {
        this.context = context;
        this.assignedDemoModelList = assignedDemoModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.demo_request_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AssignedDemoModel assignedDemoModel = assignedDemoModelList.get(position);
        holder.name.setText(assignedDemoModel.getCustomerName());
        holder.email.setText(assignedDemoModel.getCustomerEmail());
        holder.mobile.setText(assignedDemoModel.getCustomerMobile());
        holder.id.setText(assignedDemoModel.getRequestId());
        holder.mTime.setText(assignedDemoModel.getMeetingTime());
        holder.mDate.setText(assignedDemoModel.getMeetingDate());
        holder.iType.setText(assignedDemoModel.getIdeaType());
        holder.sProduct.setText(assignedDemoModel.getSelectedProduct());
        holder.reference.setText(assignedDemoModel.getReferenceApp());
        holder.dStatus.setText(assignedDemoModel.getDemoStatus());
        holder.address.setText(assignedDemoModel.getAddress());
        holder.type.setText(assignedDemoModel.getDemoType());
        if (assignedDemoModel.getDemoStatus().equals("OPEN")){
            holder.sBack.setCardBackgroundColor(Color.GREEN);
        }else if (assignedDemoModel.getDemoStatus().equals("CLOSED")){
            holder.sBack.setCardBackgroundColor(Color.RED);
        }
        holder.button.setOnClickListener(view -> {
            AppCompatActivity activity = (AppCompatActivity) view.getContext();
            Common.demoId = assignedDemoModelList.get(position).getRequestId();
            Common.userUid = assignedDemoModelList.get(position).getCustomerUid();
            Fragment orderDetails = new UpdateDemoRequest();
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,orderDetails)
                    .addToBackStack(null).commit();
        });

    }

    @Override
    public int getItemCount() {
        return assignedDemoModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, email,mobile, id, reference, mDate, mTime, iType, sProduct,dStatus,address,type;
        CardView sBack;
        LinearLayout button;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.txt_customer);
            email = itemView.findViewById(R.id.txt_email);
            mobile = itemView.findViewById(R.id.txt_mobile);
            id = itemView.findViewById(R.id.txt_request_id);
            reference = itemView.findViewById(R.id.txt_reference);
            mDate = itemView.findViewById(R.id.txt_date);
            mTime = itemView.findViewById(R.id.txt_time);
            iType = itemView.findViewById(R.id.txt_type);
            sProduct = itemView.findViewById(R.id.txt_product);
            dStatus = itemView.findViewById(R.id.dStatus);
            sBack = itemView.findViewById(R.id.sBack);
            button = itemView.findViewById(R.id.button);
            address = itemView.findViewById(R.id.txt_address);
            type = itemView.findViewById(R.id.txt_dType);
        }
    }
}
