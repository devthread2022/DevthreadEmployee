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
import com.jvt.devthread.employee.Activity.Adapters.TicketAdapter;
import com.jvt.devthread.employee.Activity.Model.TicketModel;
import com.jvt.devthread.employee.R;
import com.jvt.devthread.employee.databinding.FragmentTicketsBinding;

import java.util.ArrayList;
import java.util.List;

public class Tickets extends Fragment {
    private FragmentTicketsBinding binding;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;
    String uid;
    private List<TicketModel> ticketModelList = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTicketsBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        firebaseAuth = FirebaseAuth.getInstance();
        uid = firebaseAuth.getCurrentUser().getUid();
        binding.ticketRecycler.setHasFixedSize(true);
        binding.ticketRecycler.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        databaseReference.child("Employees").child(uid).child("AssignedTickets")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()){
                            ticketModelList.clear();
                            for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                                TicketModel ticketModel = dataSnapshot.getValue(TicketModel.class);
                                ticketModelList.add(ticketModel);
                            }
                            TicketAdapter ticketAdapter = new TicketAdapter(getContext(),ticketModelList);
                            binding.ticketRecycler.setAdapter(ticketAdapter);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
        return view;
    }
}