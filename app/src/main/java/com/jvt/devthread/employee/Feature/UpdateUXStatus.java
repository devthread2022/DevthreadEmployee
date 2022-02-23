package com.jvt.devthread.employee.Feature;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jvt.devthread.employee.Activity.Common.Common;
import com.jvt.devthread.employee.Activity.Model.WorkUpdateModel;
import com.jvt.devthread.employee.R;
import com.jvt.devthread.employee.databinding.FragmentUpdateUXStatusBinding;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class UpdateUXStatus extends Fragment {
    private FragmentUpdateUXStatusBinding binding;
    DatabaseReference databaseReference,databaseReferenceUpdate;
    String task, noOfHour, noOfPeople, updateTime, updatedBy;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentUpdateUXStatusBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReferenceUpdate = FirebaseDatabase.getInstance().getReference();
        binding.submit.setOnClickListener(view1 -> {
            String work = binding.work.getText().toString();
            String hour = binding.hour.getText().toString();
            String people = binding.people.getText().toString();
            String time = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
            String updatedEmp = Common.empName;
            if (work.isEmpty()){
                binding.work.requestFocus();
            }else if (hour.isEmpty()){
                binding.hour.requestFocus();
            }else if (people.isEmpty()){
                binding.people.requestFocus();
            }else {
                task = work;
                noOfHour = hour;
                noOfPeople = people;
                updateTime = time;
                updatedBy = updatedEmp;
                WorkUpdateModel workUpdateModel = new WorkUpdateModel(task, noOfHour, noOfPeople, updateTime, updatedBy);
                databaseReference.child("AssignedProductDevelopers").child(Common.orderId).child("UXWorkUpdate").push().setValue(workUpdateModel);
                Toast.makeText(getContext(), "Updated successfully..", Toast.LENGTH_SHORT).show();
            }

        });
        binding.upDatedWork.setOnClickListener(view1 -> {
            Common.workType = "UX";
            Fragment fragment = new UpdatedWork();
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,fragment)
                    .addToBackStack(null).commit();
        });

        databaseReferenceUpdate.child("AssignedProductDevelopers").child(Common.orderId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    String status = snapshot.child("uxStatus").getValue().toString();
                    if (status.equals("Ongoing")){
                        binding.completed.setChecked(false);
                    }else if (status.equals("Completed")){
                        binding.completed.setChecked(true);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        binding.completed.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    databaseReferenceUpdate.child("AssignedProductDevelopers").child(Common.orderId).child("uxStatus")
                            .setValue("Completed");
                }else {
                    databaseReferenceUpdate.child("AssignedProductDevelopers").child(Common.orderId).child("uxStatus")
                            .setValue("Ongoing");
                }
            }
        });
        return view;
    }
}