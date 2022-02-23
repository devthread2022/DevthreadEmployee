package com.jvt.devthread.employee.Feature;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jvt.devthread.employee.Activity.Adapters.WorkUpdateAdapter;
import com.jvt.devthread.employee.Activity.Common.Common;
import com.jvt.devthread.employee.Activity.Model.WorkUpdateModel;
import com.jvt.devthread.employee.databinding.FragmentUpdatedWorkBinding;

import java.util.ArrayList;
import java.util.List;

public class UpdatedWork extends Fragment {
    private FragmentUpdatedWorkBinding binding;
    DatabaseReference databaseReference;
    private List<WorkUpdateModel> workUpdateModelList = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentUpdatedWorkBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        binding.workRecycler.setHasFixedSize(true);
        binding.workRecycler.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        switch (Common.workType){
            case "UX":
                databaseReference.child("AssignedProductDevelopers").child(Common.orderId).child("UXWorkUpdate").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()){
                            workUpdateModelList.clear();
                            for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                                WorkUpdateModel workUpdateModel = dataSnapshot.getValue(WorkUpdateModel.class);
                                workUpdateModelList.add(workUpdateModel);
                            }
                            WorkUpdateAdapter workUpdateAdapter = new WorkUpdateAdapter(getContext(),workUpdateModelList);
                            binding.workRecycler.setAdapter(workUpdateAdapter);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                break;
            case "Testing":
                databaseReference.child("AssignedProductDevelopers").child(Common.orderId).child("TestingWorkUpdate").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()){
                            workUpdateModelList.clear();
                            for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                                WorkUpdateModel workUpdateModel = dataSnapshot.getValue(WorkUpdateModel.class);
                                workUpdateModelList.add(workUpdateModel);
                            }
                            WorkUpdateAdapter workUpdateAdapter = new WorkUpdateAdapter(getContext(),workUpdateModelList);
                            binding.workRecycler.setAdapter(workUpdateAdapter);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                break;
            case "Frontend":
                databaseReference.child("AssignedProductDevelopers").child(Common.orderId).child("FrontendWorkUpdate").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()){
                            workUpdateModelList.clear();
                            for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                                WorkUpdateModel workUpdateModel = dataSnapshot.getValue(WorkUpdateModel.class);
                                workUpdateModelList.add(workUpdateModel);
                            }
                            WorkUpdateAdapter workUpdateAdapter = new WorkUpdateAdapter(getContext(),workUpdateModelList);
                            binding.workRecycler.setAdapter(workUpdateAdapter);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                break;
            case "Backend":
                databaseReference.child("AssignedProductDevelopers").child(Common.orderId).child("BackendWorkUpdate").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()){
                            workUpdateModelList.clear();
                            for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                                WorkUpdateModel workUpdateModel = dataSnapshot.getValue(WorkUpdateModel.class);
                                workUpdateModelList.add(workUpdateModel);
                            }
                            WorkUpdateAdapter workUpdateAdapter = new WorkUpdateAdapter(getContext(),workUpdateModelList);
                            binding.workRecycler.setAdapter(workUpdateAdapter);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                break;
            case "Deployment":
                databaseReference.child("AssignedProductDevelopers").child(Common.orderId).child("DeploymentWorkUpdate").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()){
                            workUpdateModelList.clear();
                            for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                                WorkUpdateModel workUpdateModel = dataSnapshot.getValue(WorkUpdateModel.class);
                                workUpdateModelList.add(workUpdateModel);
                            }
                            WorkUpdateAdapter workUpdateAdapter = new WorkUpdateAdapter(getContext(),workUpdateModelList);
                            binding.workRecycler.setAdapter(workUpdateAdapter);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                break;
        }
        return view;
    }
}