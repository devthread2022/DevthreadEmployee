package com.jvt.devthread.employee.Feature;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jvt.devthread.employee.Activity.Common.Common;
import com.jvt.devthread.employee.R;
import com.jvt.devthread.employee.databinding.FragmentProfileBinding;

public class Profile extends Fragment {
    private FragmentProfileBinding binding;
    String uid, name, empId, status, profile, gitHub, education, address, email, phone;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        firebaseAuth = FirebaseAuth.getInstance();
        uid = firebaseAuth.getCurrentUser().getUid();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.child("Employees").child(uid).child("Info")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()){
                            name = snapshot.child("name").getValue().toString();
                            empId = snapshot.child("empId").getValue().toString();
                            status = snapshot.child("status").getValue().toString();
                            profile = snapshot.child("profile").getValue().toString();
                            gitHub = snapshot.child("gitHub").getValue().toString();
                            education = snapshot.child("education").getValue().toString();
                            address = snapshot.child("address").getValue().toString();
                            email = snapshot.child("email").getValue().toString();
                            phone = snapshot.child("phone").getValue().toString();
                            Common.name = name;
                            Common.empId = empId;
                            Common.empEmail = email;
                            Common.empPhone = phone;
                            binding.name.setText(name);
                            Glide.with(getContext()).load(profile).into(binding.profileImage);
                            binding.email.setText(email);
                            binding.regId.setText(empId);
                            binding.status.setText(status);
                            binding.git.setText(gitHub);
                            binding.university.setText(education);
                            binding.address.setText(address);
                            binding.phone.setText(phone);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
        return view;
    }
}