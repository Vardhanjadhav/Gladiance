package com.espressif.ui.adapters;

import static android.content.ContentValues.TAG;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.service.controls.Control;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.espressif.ui.activities.AddDeviceActivity;
import com.espressif.ui.activities.EspMainActivity;
import com.espressif.ui.activities.FanActivity;
import com.espressif.ui.login.AreaLandingActivity;
import com.espressif.ui.login.LoginActivity;
import com.espressif.ui.login.OTPVerificationActivity;
import com.espressif.ui.models.lnstallerlandingpage.Controls;
import com.espressif.ui.models.lnstallerlandingpage.InstallerControl;
import com.espressif.wifi_provisioning.R;

import java.util.List;


public class ControlAdapter extends RecyclerView.Adapter<ControlAdapter.ViewHolder> {
    private List<Controls> controls;
    private Context context;


    public ControlAdapter(List<Controls> controls,Context context) {
        this.controls = controls;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType ) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_control_card, parent, false);
        return new ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Controls control = controls.get(position);
        holder.deviceNameTextView.setText(control.getGaaProjectSpaceTypePlannedDeviceName());

        holder.deviceNameTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean provisionStatus = control.isProvisioned();
                SharedPreferences sharedPreferences13 = view.getContext().getSharedPreferences("my_shared_prefty", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor2 = sharedPreferences13.edit();
                Log.e(TAG, "GaaProjectSpaceTypePlannedDeviceName11: "+sharedPreferences13 );
                editor2.putBoolean("KEY_USERNAMEw", provisionStatus);
                editor2.apply();

                    if (!control.isProvisioned()) {
                        LayoutInflater inflater = LayoutInflater.from(holder.itemView.getContext());
                        Long GaaProjectSpaceTypePlannedDeviceRef = control.getGaaProjectSpaceTypePlannedDeviceRef();
                        SharedPreferences sharedPreferences = inflater.getContext().getSharedPreferences("my_shared_pref", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        Log.e(TAG, "GaaProjectSpaceTypePlannedDeviceName11: "+GaaProjectSpaceTypePlannedDeviceRef );
                        editor.putLong("KEY_USERNAME", GaaProjectSpaceTypePlannedDeviceRef);
                        editor.apply();

                     //   boolean provisionStatus = control.isProvisioned();

//                        boolean provisionStatus = control.isProvisioned();
//                        SharedPreferences sharedPreferences13 = inflater.getContext().getSharedPreferences("my_shared_prefty", Context.MODE_PRIVATE);
//                        SharedPreferences.Editor editor2 = sharedPreferences13.edit();
//                        Log.e(TAG, "GaaProjectSpaceTypePlannedDeviceName11: "+sharedPreferences13 );
//                        editor2.putBoolean("KEY_USERNAMEw", provisionStatus);
//                        editor2.apply();





                        Toast.makeText(inflater.getContext(), "This is a toast message"+control.getGaaProjectSpaceTypePlannedDeviceName(), Toast.LENGTH_SHORT).show();
                        holder.itemView.getContext().startActivity(new Intent(holder.itemView.getContext(), AddDeviceActivity.class));
                    } else {
                        LayoutInflater inflater = LayoutInflater.from(holder.itemView.getContext());

                        String nodeId = control.getNodeId();
                        SharedPreferences sharedPreferences2 = inflater.getContext().getSharedPreferences("my_shared_prefe", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences2.edit();
                        Log.e(TAG, "GaaProjectSpaceTypePlannedDeviceName11: "+nodeId );
                        editor.putString("KEY_USERNAMEs", nodeId);
                        editor.apply();

                        holder.itemView.getContext().startActivity(new Intent(holder.itemView.getContext(), EspMainActivity.class));
                    }
                }

        });

    }



    @Override
    public int getItemCount() {
        return controls.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView deviceNameTextView;

        public ViewHolder(@NonNull View itemView ) {
            super(itemView);
            deviceNameTextView = itemView.findViewById(R.id.tv_device_name);

            deviceNameTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {



                }
            });

        }
    }
}