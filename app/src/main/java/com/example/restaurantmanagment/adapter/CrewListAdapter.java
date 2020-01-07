package com.example.restaurantmanagment.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurantmanagment.R;
import com.example.restaurantmanagment.model.CrewMember;

import java.util.List;

public class CrewListAdapter extends RecyclerView.Adapter<CrewListAdapter.CrewListViewHolder> {
    private List<CrewMember> crewMemberList;

    public CrewListAdapter(List<CrewMember> crewMemberList) {
        this.crewMemberList = crewMemberList;
    }

    @NonNull
    @Override
    public CrewListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.crew_member_item_layout, parent, false);

        return new CrewListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CrewListViewHolder holder, int position) {
        holder.crewMemberName.setText(crewMemberList.get(position).getName());
        holder.crewMemberLoadTime.setProgress(crewMemberList.get(position).getSeconds());
    }

    @Override
    public int getItemCount() {
        return crewMemberList.size();
    }

    class CrewListViewHolder extends RecyclerView.ViewHolder{
        TextView crewMemberName;
        ProgressBar crewMemberLoadTime;

        public CrewListViewHolder(@NonNull View itemView) {
            super(itemView);
            crewMemberName = itemView.findViewById(R.id.crew_member_item_name_text_view);
            crewMemberLoadTime = itemView.findViewById(R.id.progress_bar);
        }
    }

}
