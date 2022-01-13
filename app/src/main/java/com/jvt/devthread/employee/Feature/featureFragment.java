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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jvt.devthread.employee.R;
import com.jvt.devthread.employee.databinding.FragmentFeatureBinding;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import static com.jvt.devthread.employee.Activity.Common.Common.activeFragment;

public class featureFragment extends Fragment {
    private FragmentFeatureBinding binding;
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    Handler handler = new Handler(Looper.getMainLooper());
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;
    String uid;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFeatureBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        uid = firebaseAuth.getCurrentUser().getUid();
        /*binding.demo.setOnClickListener(view1 -> {
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
                    binding.demoCount.setText(count+"");
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
                    binding.uxCount.setText(count+"");
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
                    binding.testCount.setText(count+"");
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
                    binding.frontCount.setText(count+"");
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
                    binding.deployCount.setText(count+"");
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
                    binding.backCount.setText(count+"");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });*/
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
                activeFragment=getActivity().getSupportFragmentManager().findFragmentById(R.id.frame_container);
            });
        });

    }
}