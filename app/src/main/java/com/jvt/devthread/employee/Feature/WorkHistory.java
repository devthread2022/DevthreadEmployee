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
import com.jvt.devthread.employee.Activity.Adapters.WorkHistoryAdapter;
import com.jvt.devthread.employee.Activity.Model.DailyWorkUpdateModel;
import com.jvt.devthread.employee.R;
import com.jvt.devthread.employee.databinding.FragmentWorkHistoryBinding;

import java.util.ArrayList;
import java.util.List;

public class WorkHistory extends Fragment {
    private FragmentWorkHistoryBinding binding;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;
    String uid;
    private List<DailyWorkUpdateModel> dailyWorkUpdateModelList = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentWorkHistoryBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        firebaseAuth = FirebaseAuth.getInstance();
        uid = firebaseAuth.getCurrentUser().getUid();
        binding.workRecycler.setHasFixedSize(false);
        binding.workRecycler.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        databaseReference.child("Employees").child(uid).child("DailyWork").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    dailyWorkUpdateModelList.clear();
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                        DailyWorkUpdateModel dailyWorkUpdateModel = dataSnapshot.getValue(DailyWorkUpdateModel.class);
                        dailyWorkUpdateModelList.add(dailyWorkUpdateModel);
                    }
                    WorkHistoryAdapter workHistoryAdapter = new WorkHistoryAdapter(getContext(),dailyWorkUpdateModelList);
                    binding.workRecycler.setAdapter(workHistoryAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return view;
    }
}