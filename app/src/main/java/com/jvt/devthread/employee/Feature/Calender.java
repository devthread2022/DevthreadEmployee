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
import com.jvt.devthread.employee.Activity.Adapters.HolidayCalenderAdapter;
import com.jvt.devthread.employee.Activity.Model.HolidayCalenderModel;
import com.jvt.devthread.employee.R;
import com.jvt.devthread.employee.databinding.FragmentCalenderBinding;

import java.util.ArrayList;
import java.util.List;

public class Calender extends Fragment {
    private FragmentCalenderBinding binding;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
    private List<HolidayCalenderModel> holidayCalenderModelList = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCalenderBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        binding.holidayRecycler.setHasFixedSize(true);
        binding.holidayRecycler.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        databaseReference.child("HolidayList").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    holidayCalenderModelList.clear();
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                        HolidayCalenderModel holidayCalenderModel = dataSnapshot.getValue(HolidayCalenderModel.class);
                        holidayCalenderModelList.add(holidayCalenderModel);
                    }
                    HolidayCalenderAdapter holidayCalenderAdapter = new HolidayCalenderAdapter(getContext(),holidayCalenderModelList);
                    binding.holidayRecycler.setAdapter(holidayCalenderAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return view;
    }
}