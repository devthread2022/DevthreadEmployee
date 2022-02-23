package com.jvt.devthread.employee.Feature;

import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.jvt.devthread.employee.Activity.Common.Common;
import com.jvt.devthread.employee.Activity.Model.AttendanceModel;
import com.jvt.devthread.employee.EmailNotification.JavaMailAPI;
import com.jvt.devthread.employee.R;
import com.jvt.devthread.employee.databinding.FragmentAttendanceBinding;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Attendance extends Fragment {
    private FragmentAttendanceBinding binding;
    private int mHour, mMinute;
    Date date1, date2;
    FirebaseAuth firebaseAuth;
    String uid;
    DatabaseReference databaseReference, databaseReference1;
    String location = "Not Checked";
    String date, workingHr, ableToWork="Not Checked", empLocation, attendanceId, approvedBy, empId, empName, attendanceStatus="Submitted";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAttendanceBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        String currentDate = sdf.format(new Date());
        binding.fromDate.setText(currentDate);
        binding.toDate.setText(currentDate);
        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference1 = FirebaseDatabase.getInstance().getReference();
        firebaseAuth = FirebaseAuth.getInstance();
        uid = firebaseAuth.getCurrentUser().getUid();
        binding.address.setText(Common.empAddress);
        binding.approvedBy.setText(Common.adminEmail);
        binding.fromTime.setOnClickListener(v -> {
            // Get Current Time
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);
            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(),
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {

                            binding.fromTime.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();
        });
        binding.toTime.setOnClickListener(v -> {
            // Get Current Time
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);
            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(),
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {

                            binding.toTime.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();
        });
        binding.ableYes.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                ableToWork = "Checked";
                ableToWork = "YES";
            }
        });
        binding.ableNo.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                ableToWork = "Checked";
                ableToWork = "NO";
            }
        });
        binding.resideYes.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                location = "Checked";
                empLocation = binding.address.getText().toString();
                binding.resideNo.setChecked(false);
                binding.loactionLayout.setVisibility(View.GONE);
            }
        });
        binding.resideNo.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                location = "Checked";
                binding.loactionLayout.setVisibility(View.VISIBLE);
                empLocation = binding.location.getText().toString();
                binding.resideYes.setChecked(false);
            }
        });
        binding.submit.setOnClickListener(v -> {
            date = binding.fromDate.getText().toString();
            empId = Common.empId;
            empName = Common.empName;
            approvedBy = binding.approvedBy.getText().toString();
            if (location.equals("Not Checked")){
                Toast.makeText(getContext(), "Select location status", Toast.LENGTH_SHORT).show();
            }else if (ableToWork.equals("Not Checked")){
                Toast.makeText(getContext(), "Select work done status", Toast.LENGTH_SHORT).show();
            }else {
                Random random = new Random();
                int id = random.nextInt(999999999)+100000000;
                attendanceId = String.valueOf(id);
                SimpleDateFormat format = new SimpleDateFormat("HH:mm");
                try {
                    date1 = format.parse(binding.fromTime.getText().toString());
                    date2 = format.parse(binding.toTime.getText().toString());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                long diff = date2.getTime() - date1.getTime();
                workingHr = String.valueOf(diff);
                AttendanceModel attendanceModel = new AttendanceModel(date, workingHr, ableToWork, empLocation, attendanceId, approvedBy, empId, empName, attendanceStatus);
                databaseReference.child("Employees").child(uid).child("Attendance").child(attendanceId).setValue(attendanceModel);
                databaseReference1.child("EmployeeAttendance").child(attendanceId).setValue(attendanceModel);
                String userEmail = approvedBy;
                String subject = "Attendance marked by "+Common.name;
                String message = "Hi, "+approvedBy+"\n"+Common.name+" having employee id "+Common.empId+" has marked his/her todays`s attendance. "
                        +".\n"+"The details are as follows: \n"+"No. of working hour: "+workingHr+"\nDate: "+date
                        +"\nEmployee location: "+empLocation+"\nAttendance Id: "+attendanceId+"\nYou need to approve the attendance by visiting to the admin application."
                        +"\nThanks & Regards,"+"\n\nDevThread";
                JavaMailAPI javaMailAPI = new JavaMailAPI(getContext(),userEmail,subject,message);
                javaMailAPI.execute();
                Toast.makeText(getContext(), "Attendance marked successfully.", Toast.LENGTH_SHORT).show();
            }

        });
        return view;
    }
}