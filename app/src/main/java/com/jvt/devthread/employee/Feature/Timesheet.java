package com.jvt.devthread.employee.Feature;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jvt.devthread.employee.Activity.Adapters.ContestsPagerAdapter;
import com.jvt.devthread.employee.R;
import com.jvt.devthread.employee.databinding.FragmentTimesheetBinding;

public class Timesheet extends Fragment {
    private FragmentTimesheetBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTimesheetBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        initViews();
        return view;
    }

    private void initViews() {
        setupViewPager(binding.viewPager);
        binding.tabLayout.setupWithViewPager(binding.viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ContestsPagerAdapter contestsPagerAdapter = new ContestsPagerAdapter(getChildFragmentManager());
        contestsPagerAdapter.addFragment(new WorkHistory(),"Work");
        contestsPagerAdapter.addFragment(new AttendanceHistory(),"Attendance");
        contestsPagerAdapter.addFragment(new LeaveHistory(),"Leave");
        viewPager.setAdapter(contestsPagerAdapter);
    }
}