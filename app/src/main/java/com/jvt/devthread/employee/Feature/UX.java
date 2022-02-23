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
import com.jvt.devthread.employee.Activity.Adapters.UXAdapter;
import com.jvt.devthread.employee.Activity.Model.OrderModel;
import com.jvt.devthread.employee.databinding.FragmentUXBinding;

import java.util.ArrayList;
import java.util.List;

public class UX extends Fragment {
    private FragmentUXBinding binding;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;
    String uid;
    private List<OrderModel> orderModelList = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentUXBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        databaseReference= FirebaseDatabase.getInstance().getReference();
        firebaseAuth = FirebaseAuth.getInstance();
        uid = firebaseAuth.getCurrentUser().getUid();
        binding.uxRecycler.setHasFixedSize(true);
        binding.uxRecycler.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        databaseReference.child("UXAssignedProduct").child(uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    orderModelList.clear();
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                        OrderModel orderModel = dataSnapshot.getValue(OrderModel.class);
                        orderModelList.add(orderModel);
                    }
                    UXAdapter uxAdapter = new UXAdapter(getContext(),orderModelList);
                    binding.uxRecycler.setAdapter(uxAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return view;
    }
}