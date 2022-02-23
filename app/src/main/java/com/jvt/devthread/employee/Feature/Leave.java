package com.jvt.devthread.employee.Feature;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.jvt.devthread.employee.Activity.Common.Common;
import com.jvt.devthread.employee.Activity.Model.LeaveModel;
import com.jvt.devthread.employee.EmailNotification.JavaMailAPI;
import com.jvt.devthread.employee.R;
import com.jvt.devthread.employee.databinding.FragmentLeaveBinding;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Leave extends Fragment {
    private FragmentLeaveBinding binding;
    String empName, empId, applyDate, leaveId, approvedBy, leaveStatus, fromDate, toDate, totalDays, cause, leaveType;
    String uid;
    Date date1, date2;
    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference, databaseReference1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLeaveBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference1 = FirebaseDatabase.getInstance().getReference();
        uid = firebaseAuth.getCurrentUser().getUid();
        binding.fromCalender.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String d = dayOfMonth+" - "+(month+1)+" - "+year;
                binding.from.setText(d);
            }
        });
        binding.toCalender.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String d1 = dayOfMonth+" - "+(month+1)+" - "+year;
                binding.to.setText(d1);
            }
        });
        binding.submit.setOnClickListener(v -> {
            empId = Common.empId;
            empName =Common.name;
            approvedBy = Common.adminEmail;
            leaveStatus = "Submitted";
            Random random = new Random();
            int i = random.nextInt(999999999)+100000000;
            leaveId = String.valueOf(i);
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
            String currentDate = sdf.format(new Date());
            applyDate = currentDate;
            fromDate = binding.from.getText().toString();
            toDate = binding.to.getText().toString();
            leaveType = binding.lType.getSelectedItem().toString();
            cause = binding.cause.getText().toString();
            if (fromDate.isEmpty()){
                Toast.makeText(getContext(), "Select leave start date.", Toast.LENGTH_SHORT).show();
            }else if (toDate.isEmpty()){
                Toast.makeText(getContext(), "Select leave end date.", Toast.LENGTH_SHORT).show();
            }else if (cause.isEmpty()){
                Toast.makeText(getContext(), "Enter cause of leave.", Toast.LENGTH_SHORT).show();
            }else {
                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                try {
                    date1 = format.parse(fromDate);
                    date2 = format.parse(toDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                //int diff = date2.getDate() - date1.getDate();
                //totalDays = String.valueOf(diff);
                totalDays = "0";
                LeaveModel leaveModel = new LeaveModel(empName, empId, applyDate, leaveId, approvedBy, leaveStatus, fromDate, toDate, totalDays, cause, leaveType);
                databaseReference.child("Employees").child(uid).child("AppliedLeave").child(leaveId).setValue(leaveModel);
                databaseReference1.child("AppliedLeave").child(leaveId).setValue(leaveModel);
                String userEmail = approvedBy;
                String subject = "Leave Applied by "+Common.name;
                String message = "Hi, "+approvedBy+"\n"+Common.name+" having employee id "+Common.empId+" has applied "+leaveType
                        +".\n"+"The details are as follows: \n"+"No. of days: "+totalDays+"\nCause: "+cause
                        +"\nFrom: "+fromDate+"\nTo: "+toDate+"\nLeave Id: "+leaveId+"\nYou need to approve the leave by visiting to the admin application."
                        +"\nThanks & Regards,"+"\n\nDevThread";
                JavaMailAPI javaMailAPI = new JavaMailAPI(getContext(),userEmail,subject,message);
                javaMailAPI.execute();
                Toast.makeText(getContext(), "Leave applied successfully.", Toast.LENGTH_SHORT).show();
            }

        });
        return view;
    }
}