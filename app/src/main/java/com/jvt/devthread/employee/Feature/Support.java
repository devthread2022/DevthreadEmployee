package com.jvt.devthread.employee.Feature;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jvt.devthread.employee.R;
import com.jvt.devthread.employee.databinding.FragmentSupportBinding;

public class Support extends Fragment {
    private FragmentSupportBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSupportBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        binding.call.setOnClickListener(view1 -> {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:1234567890"));
            if (ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(requireActivity(), new String[]{Manifest.permission.CALL_PHONE}, 10);
            }
            else {
                try{
                    startActivity(callIntent);  //call activity and make phone call
                }
                catch (android.content.ActivityNotFoundException ex){
                    Toast.makeText(getActivity(),"Your Activity is not found",Toast.LENGTH_SHORT).show();
                }
            }
        });
        binding.email.setOnClickListener(view1 -> {
            new AsyncTask<Void, Void, Void>() {
                @Override
                protected Void doInBackground(Void... params) {

                    if(savedInstanceState==null)
                    {
                        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                                "mailto","help.coderrange@gmail.com", null));
                        intent.putExtra(Intent.EXTRA_SUBJECT,"Report" );
                        intent.putExtra(Intent.EXTRA_TEXT, "your message");
                        startActivity(Intent.createChooser(intent, "Choose an Email client :"));
                    }
                    return null;
                }

                @Override
                protected void onPostExecute(Void aVoid) {
                    super.onPostExecute(aVoid);

                }
            }.execute();
        });
        return view;
    }
}