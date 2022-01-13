package com.jvt.devthread.employee.Feature;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jvt.devthread.employee.R;
import com.jvt.devthread.employee.databinding.FragmentWorkUpdateBinding;

public class WorkUpdate extends Fragment {
    private FragmentWorkUpdateBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentWorkUpdateBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        return view;
    }
}