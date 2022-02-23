package com.jvt.devthread.employee.Feature;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jvt.devthread.employee.Activity.Adapters.DeploymentAdapter;
import com.jvt.devthread.employee.Activity.Model.OrderModel;
import com.jvt.devthread.employee.databinding.FragmentDeploymentBinding;

import java.util.ArrayList;
import java.util.List;

public class Deployment extends Fragment {
    private FragmentDeploymentBinding binding;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;
    String uid;
    private List<OrderModel> orderModelList = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDeploymentBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        databaseReference= FirebaseDatabase.getInstance().getReference();
        firebaseAuth = FirebaseAuth.getInstance();
        uid = firebaseAuth.getCurrentUser().getUid();
        binding.deployRecycler.setHasFixedSize(true);
        binding.deployRecycler.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        databaseReference.child("DeploymentAssignedProduct").child(uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    orderModelList.clear();
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                        OrderModel orderModel = dataSnapshot.getValue(OrderModel.class);
                        orderModelList.add(orderModel);
                    }
                    DeploymentAdapter deploymentAdapter = new DeploymentAdapter(getContext(),orderModelList);
                    binding.deployRecycler.setAdapter(deploymentAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return view;
    }
}