package com.jvt.devthread.employee.Feature;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Handler;
import android.os.Looper;
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
import com.jvt.devthread.employee.databinding.FragmentFeatureBinding;

import java.util.Calendar;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class featureFragment extends Fragment {
    private FragmentFeatureBinding binding;
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    Handler handler = new Handler(Looper.getMainLooper());
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;
    String uid, name, empId, status, profile, gitHub, education, address, email, phone;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFeatureBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        Calendar c = Calendar.getInstance();
        int timeOfDay = c.get(Calendar.HOUR_OF_DAY);

        if(timeOfDay >= 0 && timeOfDay < 12){
            binding.salutation.setText("Hi,Good Morning");
        }else if(timeOfDay >= 12 && timeOfDay < 16){
            binding.salutation.setText("Hi,Good Afternoon");
        }else if(timeOfDay >= 16 && timeOfDay < 21){
            binding.salutation.setText("Hi,Good Evening");
        }else if(timeOfDay >= 21 && timeOfDay < 24){
            binding.salutation.setText("Hi,Good Night");
        }
        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        uid = firebaseAuth.getCurrentUser().getUid();
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
                            Common.empAddress = address;
                            binding.empName.setText(name);
                            Glide.with(getContext()).load(profile).into(binding.profileImage);
                            binding.regId.setText(empId);
                            binding.status.setText(status);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
        binding.demo.setOnClickListener(view1 -> {
            Fragment demo = new DemoRequests();
            loadFragment(demo,"DemoRequests");
        });
        binding.ux.setOnClickListener(view1 -> {
            Fragment ux = new UX();
            loadFragment(ux,"UX");
        });
        binding.frontend.setOnClickListener(view1 -> {
            Fragment front = new Frontend();
            loadFragment(front,"Frontend");
        });
        binding.backend.setOnClickListener(view1 -> {
            Fragment back = new Backend();
            loadFragment(back,"Backend");
        });
        binding.testing.setOnClickListener(view1 -> {
            Fragment testing = new Testing();
            loadFragment(testing,"Testing");
        });
        binding.deployment.setOnClickListener(view1 -> {
            Fragment deployment = new Deployment();
            loadFragment(deployment,"Deployment");
        });
        databaseReference.child("CRMAssignedDemoRequest").child(uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    long count = snapshot.getChildrenCount();
                    //binding.demoCount.setText(count+"");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        databaseReference.child("UXAssignedProduct").child(uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    long count = snapshot.getChildrenCount();
                    //binding.uxCount.setText(count+"");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        databaseReference.child("TestingAssignedProduct").child(uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    long count = snapshot.getChildrenCount();
                    //binding.testCount.setText(count+"");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        databaseReference.child("FrontendAssignedProduct").child(uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    long count = snapshot.getChildrenCount();
                    //binding.frontCount.setText(count+"");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        databaseReference.child("DeploymentAssignedProduct").child(uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    long count = snapshot.getChildrenCount();
                    //binding.deployCount.setText(count+"");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        databaseReference.child("BackendAssignedProduct").child(uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    long count = snapshot.getChildrenCount();
                    //binding.backCount.setText(count+"");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        databaseReference.child("AdminEmail").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    String email = snapshot.child("email").getValue().toString();
                    Common.adminEmail = email;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        binding.workUpdate.setOnClickListener(view1 -> {
            Fragment fragment = new WorkUpdate();
            loadFragment(fragment,"WorkUpdate");
        });
        binding.attendance.setOnClickListener(view1 -> {
            Fragment fragment = new Attendance();
            loadFragment(fragment,"Attendance");
        });
        binding.leave.setOnClickListener(view1 -> {
            Fragment fragment = new Leave();
            loadFragment(fragment,"Leave");
        });
        binding.timesheet.setOnClickListener(v -> {
            Fragment fragment = new Timesheet();
            loadFragment(fragment,"Timesheet");
        });
        binding.calender.setOnClickListener(v -> {
            Fragment fragment = new Calender();
            loadFragment(fragment,"Calender");
        });
        binding.tickets.setOnClickListener(v -> {
            Fragment fragment = new Tickets();
            loadFragment(fragment,"Tickets");
        });
        binding.project.setOnClickListener(v -> {
            Fragment fragment = new Projects();
            loadFragment(fragment,"Projects");
        });
        binding.chat.setOnClickListener(v -> {
            Fragment fragment = new Chats();
            loadFragment(fragment,"Chats");
        });
        binding.schedule.setOnClickListener(v -> {
            Fragment fragment = new Schedule();
            loadFragment(fragment,"Schedule");
        });
        binding.support.setOnClickListener(v -> {
            Fragment fragment = new Support();
            loadFragment(fragment,"Support");
        });
        binding.pDetail.setOnClickListener(v -> {
            Fragment fragment = new Profile();
            loadFragment(fragment,"Profile");
        });
        binding.profile.setOnClickListener(v -> {
            Fragment fragment = new Profile();
            loadFragment(fragment,"Profile");
        });
        binding.notification.setOnClickListener(v -> {
            Fragment fragment = new Notification();
            loadFragment(fragment,"Notification");
        });
        binding.setting.setOnClickListener(v -> {
            Fragment fragment = new Settings();
            loadFragment(fragment,"Settings");
        });
        return view;
    }
    private void loadFragment(Fragment fragment, String tag) {
        executorService.execute(()->{
            if (fragment != null) {

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame_container, fragment, tag).addToBackStack(tag).commit();

            }
            handler.post(()->{
                Common.activeFragment =getActivity().getSupportFragmentManager().findFragmentById(R.id.frame_container);
            });
        });

    }
}