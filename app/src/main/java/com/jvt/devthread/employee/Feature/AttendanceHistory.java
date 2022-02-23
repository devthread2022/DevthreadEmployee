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
import com.jvt.devthread.employee.Activity.Adapters.AttendanceHistoryAdapter;
import com.jvt.devthread.employee.Activity.Model.AttendanceModel;
import com.jvt.devthread.employee.R;
import com.jvt.devthread.employee.databinding.FragmentAttendanceHistoryBinding;

import java.util.ArrayList;
import java.util.List;

public class AttendanceHistory extends Fragment {
    private FragmentAttendanceHistoryBinding binding;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;
    String uid;
    private List<AttendanceModel> attendanceModelList = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAttendanceHistoryBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        firebaseAuth = FirebaseAuth.getInstance();
        uid = firebaseAuth.getCurrentUser().getUid();
        binding.attendanceRecycler.setHasFixedSize(false);
        binding.attendanceRecycler.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        databaseReference.child("Employees").child(uid).child("Attendance").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    attendanceModelList.clear();
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                        AttendanceModel attendanceModel = dataSnapshot.getValue(AttendanceModel.class);
                        attendanceModelList.add(attendanceModel);
                    }
                    AttendanceHistoryAdapter attendanceHistoryAdapter = new AttendanceHistoryAdapter(getContext(),attendanceModelList);
                    binding.attendanceRecycler.setAdapter(attendanceHistoryAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return view;
    }
}