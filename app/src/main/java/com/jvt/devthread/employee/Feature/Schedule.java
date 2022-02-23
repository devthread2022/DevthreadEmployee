package com.jvt.devthread.employee.Feature;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jvt.devthread.employee.Activity.Common.Common;
import com.jvt.devthread.employee.R;
import com.jvt.devthread.employee.databinding.FragmentScheduleBinding;

public class Schedule extends Fragment {
    private FragmentScheduleBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentScheduleBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        binding.empId.setText("Your employee id is: "+ Common.empId);
        binding.dear.setText("Dear "+Common.name+",");
        return view;
    }
}