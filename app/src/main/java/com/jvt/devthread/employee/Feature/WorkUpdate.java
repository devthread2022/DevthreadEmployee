package com.jvt.devthread.employee.Feature;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.jvt.devthread.employee.Activity.Common.Common;
import com.jvt.devthread.employee.Activity.Model.DailyWorkUpdateModel;
import com.jvt.devthread.employee.R;
import com.jvt.devthread.employee.databinding.FragmentWorkUpdateBinding;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class WorkUpdate extends Fragment {
    private FragmentWorkUpdateBinding binding;
    String projectName, workDone, timeTaken, feedback, empId, empName, workId, workDate,lines;
    Integer loc;
    FirebaseAuth firebaseAuth;
    String uid;
    DatabaseReference databaseReference, databaseReference1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentWorkUpdateBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference1 = FirebaseDatabase.getInstance().getReference();
        firebaseAuth = FirebaseAuth.getInstance();
        uid = firebaseAuth.getCurrentUser().getUid();
        binding.submit.setOnClickListener(v -> {
            lines = binding.loc.getText().toString();
            projectName = binding.project.getText().toString();
            workDone = binding.work.getText().toString();
            timeTaken = binding.time.getText().toString();
            feedback = binding.feed.getText().toString();
            if (lines.isEmpty()){
                Toast.makeText(getContext(), "Lines of codes", Toast.LENGTH_SHORT).show();
            }else if (projectName.isEmpty()){
                Toast.makeText(getContext(), "Project name", Toast.LENGTH_SHORT).show();
            }else if (workDone.isEmpty()){
                Toast.makeText(getContext(), "Work done", Toast.LENGTH_SHORT).show();
            }else if (timeTaken.isEmpty()){
                Toast.makeText(getContext(), "Time taken to complete the work", Toast.LENGTH_SHORT).show();
            }else {
                if (feedback.isEmpty()){
                    feedback = "NA";
                }else {
                    feedback = binding.feed.getText().toString();
                }
                empId = Common.empId;
                empName = Common.name;
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
                String currentDate = sdf.format(new Date());
                workDate = currentDate;
                Random random = new Random();
                int id = random.nextInt(999999999)+100000000;
                workId = String.valueOf(id);
                loc = Integer.valueOf(lines);
                DailyWorkUpdateModel dailyWorkUpdateModel = new DailyWorkUpdateModel(projectName, workDone, timeTaken, feedback,
                        empId, empName, workId, workDate, loc);
                databaseReference.child("Employees").child(uid).child("DailyWork").child(workId).setValue(dailyWorkUpdateModel);
                Toast.makeText(getContext(), "Submitted successfully.", Toast.LENGTH_SHORT).show();
                databaseReference1.child("DailyEmployeeWork").child(workId).setValue(dailyWorkUpdateModel);
            }
        });
        return view;
    }
}