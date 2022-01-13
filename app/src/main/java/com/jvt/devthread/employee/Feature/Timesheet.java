package com.jvt.devthread.employee.Feature;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jvt.devthread.employee.R;
import com.jvt.devthread.employee.databinding.FragmentTimesheetBinding;

public class Timesheet extends Fragment {
    private FragmentTimesheetBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTimesheetBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        return view;
    }
}