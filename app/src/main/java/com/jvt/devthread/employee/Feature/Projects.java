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
import com.jvt.devthread.employee.Activity.Adapters.AssignedProjectAdapter;
import com.jvt.devthread.employee.Activity.Model.AssignedProjectModel;
import com.jvt.devthread.employee.R;
import com.jvt.devthread.employee.databinding.FragmentProjectsBinding;

import java.util.ArrayList;
import java.util.List;

public class Projects extends Fragment {
    private FragmentProjectsBinding binding;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;
    String uid;
    private List<AssignedProjectModel> assignedProjectModelList = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProjectsBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        firebaseAuth = FirebaseAuth.getInstance();
        uid = firebaseAuth.getCurrentUser().getUid();
        binding.projectRecycler.setHasFixedSize(false);
        binding.projectRecycler.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        databaseReference.child("Employees").child(uid).child("AssignedProjects").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    assignedProjectModelList.clear();
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                        AssignedProjectModel assignedProjectModel = dataSnapshot.getValue(AssignedProjectModel.class);
                        assignedProjectModelList.add(assignedProjectModel);
                    }
                    AssignedProjectAdapter assignedProjectAdapter = new AssignedProjectAdapter(getContext(),assignedProjectModelList);
                    binding.projectRecycler.setAdapter(assignedProjectAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return view;
    }
}