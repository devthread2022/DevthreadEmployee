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
import com.jvt.devthread.employee.Activity.Adapters.SelectedFeaturesAdapter;
import com.jvt.devthread.employee.Activity.Adapters.SelectedImagesAdapter;
import com.jvt.devthread.employee.Activity.Common.Common;
import com.jvt.devthread.employee.Activity.Model.SelectedFeatureModel;
import com.jvt.devthread.employee.Activity.Model.SelectedImageModel;
import com.jvt.devthread.employee.databinding.FragmentAssignedWorkDetailBinding;

import java.util.ArrayList;
import java.util.List;

public class AssignedWorkDetail extends Fragment {
    private FragmentAssignedWorkDetailBinding binding;
    DatabaseReference databaseReference,databaseReference2,databaseReference3;
    String frontend,product,delivery,backend,design,database,platform,service;
    private List<SelectedImageModel> selectedImageModelList = new ArrayList<>();
    private List<SelectedFeatureModel> selectedFeatureModelList = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAssignedWorkDetailBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference2 = FirebaseDatabase.getInstance().getReference();
        databaseReference3 = FirebaseDatabase.getInstance().getReference();
        binding.ordId.setText(Common.orderId);
        binding.unselectedFeatures.setText(Common.uFeateures);
        databaseReference.child(Common.pPlatform).child(Common.dTag).child("productList").child(Common.pId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    frontend = snapshot.child("frontend").getValue().toString();
                    platform = snapshot.child("platform").getValue().toString();
                    product = snapshot.child("name").getValue().toString();
                    backend = snapshot.child("backend").getValue().toString();
                    design = snapshot.child("design").getValue().toString();
                    database = snapshot.child("database").getValue().toString();
                    delivery = snapshot.child("productDeliveryTime").getValue().toString();
                    service = snapshot.child("productServiceValidity").getValue().toString();
                    binding.frontend.setText(frontend);
                    binding.plaform.setText(platform);
                    binding.productName.setText(product);
                    binding.backend.setText(backend);
                    binding.design.setText(design);
                    binding.database.setText(database);
                    binding.deliveryTime.setText(delivery+" Days");
                    binding.serviceTime.setText(service+" Months");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        binding.imagesRecycler.setHasFixedSize(true);
        binding.imagesRecycler.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        databaseReference2.child(Common.pPlatform).child(Common.dTag).child("productList").child(Common.pId).child("productImageList")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()){
                            selectedImageModelList.clear();
                            for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                                SelectedImageModel selectedImageModel = dataSnapshot.getValue(SelectedImageModel.class);
                                selectedImageModelList.add(selectedImageModel);
                            }
                            SelectedImagesAdapter selectedImagesAdapter = new SelectedImagesAdapter(getContext(),selectedImageModelList);
                            binding.imagesRecycler.setAdapter(selectedImagesAdapter);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
        binding.featuresRecycler.setHasFixedSize(true);
        binding.featuresRecycler.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        switch (Common.pType){
            case "Start":
                databaseReference3.child(Common.pPlatform).child(Common.dTag).child("productList").child(Common.pId).child("features")
                        .addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                if (snapshot.exists()){
                                    selectedFeatureModelList.clear();
                                    for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                                        SelectedFeatureModel selectedFeatureModel = dataSnapshot.getValue(SelectedFeatureModel.class);
                                        selectedFeatureModelList.add(selectedFeatureModel);
                                    }
                                    SelectedFeaturesAdapter selectedFeaturesAdapter = new SelectedFeaturesAdapter(getContext(),selectedFeatureModelList);
                                    binding.featuresRecycler.setAdapter(selectedFeaturesAdapter);
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
                break;
            case "Pro":
                databaseReference3.child(Common.pPlatform).child(Common.dTag).child("productList").child(Common.pId).child("proFeatures")
                        .addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                if (snapshot.exists()){
                                    selectedFeatureModelList.clear();
                                    for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                                        SelectedFeatureModel selectedFeatureModel = dataSnapshot.getValue(SelectedFeatureModel.class);
                                        selectedFeatureModelList.add(selectedFeatureModel);
                                    }
                                    SelectedFeaturesAdapter selectedFeaturesAdapter = new SelectedFeaturesAdapter(getContext(),selectedFeatureModelList);
                                    binding.featuresRecycler.setAdapter(selectedFeaturesAdapter);
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
                break;
            case "Ultimate":
                databaseReference3.child(Common.pPlatform).child(Common.dTag).child("productList").child(Common.pId).child("ultimateFeatures")
                        .addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                if (snapshot.exists()){
                                    selectedFeatureModelList.clear();
                                    for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                                        SelectedFeatureModel selectedFeatureModel = dataSnapshot.getValue(SelectedFeatureModel.class);
                                        selectedFeatureModelList.add(selectedFeatureModel);
                                    }
                                    SelectedFeaturesAdapter selectedFeaturesAdapter = new SelectedFeaturesAdapter(getContext(),selectedFeatureModelList);
                                    binding.featuresRecycler.setAdapter(selectedFeaturesAdapter);
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
                break;
        }
        return view;
    }
}