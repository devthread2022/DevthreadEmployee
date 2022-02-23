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
import com.jvt.devthread.employee.Activity.Adapters.TandCAdapter;
import com.jvt.devthread.employee.Activity.Model.TandCModel;
import com.jvt.devthread.employee.R;
import com.jvt.devthread.employee.databinding.FragmentPrivacyBinding;

import java.util.ArrayList;
import java.util.List;

public class Privacy extends Fragment {
    private FragmentPrivacyBinding binding;
    private List<TandCModel> tandCModelList = new ArrayList<>();
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       binding = FragmentPrivacyBinding.inflate(inflater,container,false);
       View view = binding.getRoot();
       binding.recyclerview.setHasFixedSize(true);
       binding.recyclerview.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        databaseReference.child("Privacy").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    tandCModelList.clear();
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                        TandCModel tandCModel = dataSnapshot.getValue(TandCModel.class);
                        tandCModelList.add(tandCModel);
                    }
                    TandCAdapter tandCAdapter = new TandCAdapter(getContext(),tandCModelList);
                    binding.recyclerview.setAdapter(tandCAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
       return view;
    }
}