package com.espressif.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.espressif.ui.models.Space;
import com.espressif.ui.models.SpaceGroup;
import com.espressif.wifi_provisioning.R;

import java.util.List;

public class ProjectSpaceNameAdapter extends RecyclerView.Adapter<ProjectSpaceNameAdapter.ViewHolder> {

    private static List<Space> arraylist;

    public ProjectSpaceNameAdapter(List<Space> arraylist) {
        this.arraylist = arraylist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.project_space_name_recycleview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Space space = arraylist.get(position);
        holder.spaceNameTextView.setText(space.getGAAProjectSpaceName());
        // You can also bind other data related to the space group here if needed
    }

    @Override
    public int getItemCount() {
        return arraylist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView spaceNameTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            spaceNameTextView = itemView.findViewById(R.id.ProjectSpaceName);
        }
    }
}