package com.espressif.ui.navigation.ControlBouquet;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.espressif.wifi_provisioning.R;


public class HousekeepingFragment extends Fragment {


    public HousekeepingFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_housekeeping, container, false);
    }
}