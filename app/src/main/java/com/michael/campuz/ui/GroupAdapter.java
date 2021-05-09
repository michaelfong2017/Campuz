package com.michael.campuz.ui;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.michael.campuz.R;
import com.michael.campuz.data.group.Group;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.GroupHolder> {
    private List<Group> groups = new ArrayList<>();
    @NonNull
    @Override
    public GroupHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.group_item, parent, false);
        return new GroupHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull GroupHolder holder, int position) {
        Group currentGroup = groups.get(position);
        holder.textViewStatus.setText(currentGroup.getStatus());
        holder.textViewPeople.setText(currentGroup.getNumberOfPeople() + "/" + currentGroup.getTo());
        holder.textViewTitle.setText(currentGroup.getTitle());
        holder.textViewComments.setText(String.valueOf(currentGroup.getNumberOfComments()));

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = holder.textViewTitle.getText().toString();
                Logger.d(currentGroup.getId());
                Logger.d(title);

                Intent intent = new Intent(view.getContext(), GroupThreadActivity.class);
                intent.putExtra(GroupThreadActivity.EXTRA_GROUP_ID, currentGroup.getId());
                view.getContext().startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return groups.size();
    }
    public void setGroups(List<Group> groups) {
        this.groups = groups;
        notifyDataSetChanged();
    }
    class GroupHolder extends RecyclerView.ViewHolder {
        private TextView textViewStatus;
        private TextView textViewPeople;
        private TextView textViewTitle;
        private TextView textViewComments;
        private Button button;
        public GroupHolder(View itemView) {
            super(itemView);
            textViewStatus = itemView.findViewById(R.id.thread_status);
            textViewPeople = itemView.findViewById(R.id.thread_people);
            textViewTitle = itemView.findViewById(R.id.thread_title);
            textViewComments = itemView.findViewById(R.id.thread_number_of_comments);

            button = itemView.findViewById(R.id.thread_button);
        }
    }

}