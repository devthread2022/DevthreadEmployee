package com.jvt.devthread.employee.Feature;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jvt.devthread.employee.R;
import com.jvt.devthread.employee.databinding.FragmentLeaveBinding;

public class Leave extends Fragment {
    private FragmentLeaveBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLeaveBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        return view;
    }
}