package com.jvt.devthread.employee.Feature;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.service.controls.actions.CommandAction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jvt.devthread.employee.Activity.Common.Common;
import com.jvt.devthread.employee.R;
import com.jvt.devthread.employee.databinding.FragmentUpdateDemoRequestBinding;

public class UpdateDemoRequest extends Fragment {
    private FragmentUpdateDemoRequestBinding binding;
    String designNote,customerExpNote,clientExpNote,featuresNote,design1,cstExp1,cltExp1,feature1,design,cstExp,cltExp,feature,uid;
    DatabaseReference databaseReference,databaseReferenceDesign,databaseReferenceCstExp,databaseReferenceCltExp,databaseReferenceFeature;
    FirebaseAuth firebaseAuth;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentUpdateDemoRequestBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReferenceDesign = FirebaseDatabase.getInstance().getReference();
        databaseReferenceFeature = FirebaseDatabase.getInstance().getReference();
        databaseReferenceCstExp = FirebaseDatabase.getInstance().getReference();
        databaseReferenceCltExp = FirebaseDatabase.getInstance().getReference();
        firebaseAuth = FirebaseAuth.getInstance();
        uid = firebaseAuth.getCurrentUser().getUid();
        binding.demoId.setText(Common.demoId);
        designNote ="No design change required.";
        customerExpNote ="No customer experience change required.";
        clientExpNote = "No client experience change required.";
        featuresNote = "No features change required.";
        binding.designNeedChange.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b){
                binding.requiredDesignBox.setVisibility(View.VISIBLE);
            }else {
                binding.requiredDesignBox.setVisibility(View.GONE);
            }
        });
        binding.customerExpChange.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b){
                binding.customerExpChangeBox.setVisibility(View.VISIBLE);
            }else {
                binding.customerExpChangeBox.setVisibility(View.GONE);
            }
        });
        binding.clientExpChange.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b){
                binding.clientExpChangeBox.setVisibility(View.VISIBLE);
            }else {
                binding.clientExpChangeBox.setVisibility(View.GONE);
            }
        });
        binding.featuresChange.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b){
                binding.featuresChangeBox.setVisibility(View.VISIBLE);
            }else {
                binding.featuresChangeBox.setVisibility(View.GONE);
            }
        });

        binding.needYes.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b){
                databaseReference.child("DemoRequestFeedback").child(Common.demoId).child("needSatisfied")
                        .setValue("YES");
            }
        });
        binding.needNo.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b){
                databaseReference.child("DemoRequestFeedback").child(Common.demoId).child("needSatisfied")
                        .setValue("NO");
            }
        });
        binding.priceNegoYes.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b){
                databaseReference.child("DemoRequestFeedback").child(Common.demoId).child("priceNegotiation")
                        .setValue("YES");
            }
        });
        binding.priceNegoNo.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b){
                databaseReference.child("DemoRequestFeedback").child(Common.demoId).child("priceNegotiation")
                        .setValue("NO");
            }
        });
        binding.designLikeYes.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b){
                databaseReference.child("DemoRequestFeedback").child(Common.demoId).child("likesDesign")
                        .setValue("YES");
            }
        });
        binding.designNeedChange.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b){
                databaseReference.child("DemoRequestFeedback").child(Common.demoId).child("likesDesign")
                        .setValue("Need Change");
            }
        });
        binding.refAppYes.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b){
                databaseReference.child("DemoRequestFeedback").child(Common.demoId).child("referenceApp")
                        .setValue("YES");
            }
        });
        binding.refAppNo.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b){
                databaseReference.child("DemoRequestFeedback").child(Common.demoId).child("referenceApp")
                        .setValue("NO");
            }
        });
        binding.deliveryGood.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b){
                databaseReference.child("DemoRequestFeedback").child(Common.demoId).child("deliveryTime")
                        .setValue("Good");
            }
        });
        binding.deliveryLate.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b){
                databaseReference.child("DemoRequestFeedback").child(Common.demoId).child("deliveryTime")
                        .setValue("Late");
            }
        });
        binding.discountOk.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b){
                databaseReference.child("DemoRequestFeedback").child(Common.demoId).child("discount")
                        .setValue("OK");
            }
        });
        binding.discountMore.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b){
                databaseReference.child("DemoRequestFeedback").child(Common.demoId).child("discount")
                        .setValue("Want More");
            }
        });
        binding.customerExpYes.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b){
                databaseReference.child("DemoRequestFeedback").child(Common.demoId).child("customerExpMeets")
                        .setValue("YES");
            }
        });
        binding.customerExpChange.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b){
                databaseReference.child("DemoRequestFeedback").child(Common.demoId).child("customerExpMeets")
                        .setValue("Need Change");
            }
        });
        binding.clientExpYes.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b){
                databaseReference.child("DemoRequestFeedback").child(Common.demoId).child("clientExpMeets")
                        .setValue("YES");
            }
        });
        binding.clientExpChange.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b){
                databaseReference.child("DemoRequestFeedback").child(Common.demoId).child("clientExpMeets")
                        .setValue("Need Change");
            }
        });
        binding.featuresYes.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b){
                databaseReference.child("DemoRequestFeedback").child(Common.demoId).child("featureNeedMeets")
                        .setValue("YES");
            }
        });
        binding.featuresChange.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b){
                databaseReference.child("DemoRequestFeedback").child(Common.demoId).child("featureNeedMeets")
                        .setValue("Need More");
            }
        });

        binding.submitBtn.setOnClickListener(view1 -> {
            databaseReferenceDesign.child("DemoRequestFeedback").child(Common.demoId).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.exists()){
                        design = snapshot.child("likesDesign").getValue().toString();
                        cstExp = snapshot.child("customerExpMeets").getValue().toString();
                        cltExp = snapshot.child("clientExpMeets").getValue().toString();
                        feature = snapshot.child("featureNeedMeets").getValue().toString();
                        if (design.equals("Need Change")){
                            binding.requiredDesignBox.setVisibility(View.VISIBLE);
                            design1 = binding.requiredDesignBox.getText().toString();
                            if (design1.isEmpty()){
                                binding.requiredDesignBox.setError("Required Change");
                                binding.requiredDesignBox.requestFocus();
                            }else {
                                databaseReference.child("DemoRequestFeedback").child(Common.demoId).child("designChangeNote")
                                        .setValue(design1);
                            }

                        }else {
                            binding.requiredDesignBox.setVisibility(View.GONE);
                            databaseReference.child("DemoRequestFeedback").child(Common.demoId).child("designChangeNote")
                                    .setValue(designNote);
                        }
                        if (cstExp.equals("Need Change")){
                            binding.customerExpChangeBox.setVisibility(View.VISIBLE);
                            cstExp1 = binding.customerExpChangeBox.getText().toString();
                            if (cstExp1.isEmpty()){
                                binding.customerExpChangeBox.setError("Required Change");
                                binding.customerExpChangeBox.requestFocus();
                            }else {
                                databaseReference.child("DemoRequestFeedback").child(Common.demoId).child("customerExpNote")
                                        .setValue(cstExp1);
                            }
                        }else {
                            binding.customerExpChangeBox.setVisibility(View.GONE);
                            databaseReference.child("DemoRequestFeedback").child(Common.demoId).child("customerExpNote")
                                    .setValue(customerExpNote);
                        }
                        if (cltExp.equals("Need Change")){
                            binding.clientExpChangeBox.setVisibility(View.VISIBLE);
                            cltExp1 = binding.clientExpChangeBox.getText().toString();
                            if (cstExp1.isEmpty()){
                                binding.clientExpChangeBox.setError("Required Change");
                                binding.clientExpChangeBox.requestFocus();
                            }else {
                                databaseReference.child("DemoRequestFeedback").child(Common.demoId).child("clientExpNote")
                                        .setValue(cltExp1);
                            }
                        }else {
                            binding.clientExpChangeBox.setVisibility(View.GONE);
                            databaseReference.child("DemoRequestFeedback").child(Common.demoId).child("clientExpNote")
                                    .setValue(clientExpNote);
                        }
                        if (feature.equals("Need More")){
                            binding.featuresChangeBox.setVisibility(View.VISIBLE);
                            feature1 = binding.featuresChangeBox.getText().toString();
                            if (feature1.isEmpty()){
                                binding.featuresChangeBox.setError("Required Change");
                                binding.featuresChangeBox.requestFocus();
                            }else {
                                databaseReference.child("DemoRequestFeedback").child(Common.demoId).child("featureChangeNote")
                                        .setValue(feature1);
                            }
                        }else {
                            binding.featuresChangeBox.setVisibility(View.GONE);
                            databaseReference.child("DemoRequestFeedback").child(Common.demoId).child("featureChangeNote")
                                    .setValue(featuresNote);
                        }
                        databaseReferenceDesign.child("DemoRequests").child(Common.userUid).child(Common.demoId).child("status")
                                .setValue("Completed");
                        databaseReferenceCltExp.child("CRMAssignedDemoRequest").child(uid).child(Common.demoId).child("demoStatus")
                                .setValue("CLOSED");
                        Toast.makeText(getContext(), "Updated successfully..", Toast.LENGTH_SHORT).show();

                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        });


        return view;
    }
}