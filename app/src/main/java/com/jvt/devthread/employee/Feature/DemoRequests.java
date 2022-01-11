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
import com.jvt.devthread.employee.Activity.Adapters.DemoAdapter;
import com.jvt.devthread.employee.Activity.Model.AssignedDemoModel;
import com.jvt.devthread.employee.R;
import com.jvt.devthread.employee.databinding.FragmentDemoRequestsBinding;

import java.util.ArrayList;
import java.util.List;

public class DemoRequests extends Fragment {
    private FragmentDemoRequestsBinding binding;
    String uid;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;
    private List<AssignedDemoModel> assignedDemoModelList = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDemoRequestsBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        binding.demoRecycler.setHasFixedSize(true);
        binding.demoRecycler.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        uid = firebaseAuth.getCurrentUser().getUid();
        loadDemoRequest();
        return view;
    }

    private void loadDemoRequest() {
        databaseReference.child("CRMAssignedDemoRequest").child(uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    assignedDemoModelList.clear();
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                        AssignedDemoModel assignedDemoModel = dataSnapshot.getValue(AssignedDemoModel.class);
                        assignedDemoModelList.add(assignedDemoModel);
                    }
                    DemoAdapter demoAdapter = new DemoAdapter(getContext(),assignedDemoModelList);
                    binding.demoRecycler.setAdapter(demoAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}