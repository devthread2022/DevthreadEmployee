package com.jvt.devthread.employee.Feature;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.jvt.devthread.employee.Activity.Common.Common;
import com.jvt.devthread.employee.Activity.login;
import com.jvt.devthread.employee.R;
import com.jvt.devthread.employee.databinding.FragmentSettingsBinding;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Settings extends Fragment {
    private FragmentSettingsBinding binding;
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    Handler handler = new Handler(Looper.getMainLooper());
    public static Fragment activeFragment;
    FirebaseAuth firebaseAuth;
    String uid;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSettingsBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        firebaseAuth = FirebaseAuth.getInstance();
        uid = firebaseAuth.getCurrentUser().getUid();
        binding.logout.setOnClickListener(view1 -> {
            if (FirebaseAuth.getInstance() != null) {
                firebaseAuth.signOut();
                startActivity(new Intent(getActivity(), login.class));
                getActivity().finish();
            }
        });
        binding.terms.setOnClickListener(v -> {
            Fragment fragment = new Terms();
            loadFragment(fragment,"Terms");
        });
        binding.privacy.setOnClickListener(v -> {
            Fragment fragment = new Privacy();
            loadFragment(fragment,"Privacy");
        });
        return view;
    }
    private void loadFragment(Fragment fragment, String tag) {
        executorService.execute(()->{
            if (fragment != null) {

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame_container, fragment, tag).addToBackStack(tag).commit();

            }
            handler.post(()->{
                Common.activeFragment =getActivity().getSupportFragmentManager().findFragmentById(R.id.frame_container);
            });
        });

    }
}