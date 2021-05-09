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
import com.michael.campuz.data.group.GroupReply;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

public class GroupReplyAdapter extends RecyclerView.Adapter<GroupReplyAdapter.GroupReplyHolder> {
    private List<GroupReply> groupReplies = new ArrayList<>();
    @NonNull
    @Override
    public GroupReplyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.group_reply_item, parent, false);
        return new GroupReplyHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull GroupReplyHolder holder, int position) {
        GroupReply currentGroupReply = groupReplies.get(position);
        holder.textViewNumber.setText("#" + currentGroupReply.getNumber());
        holder.textViewName.setText(currentGroupReply.getName());
        holder.textViewContent.setText(currentGroupReply.getContent());
    }
    @Override
    public int getItemCount() {
        return groupReplies.size();
    }
    public void setGroupReplies(List<GroupReply> groupReplies) {
        this.groupReplies = groupReplies;
        notifyDataSetChanged();
    }
    class GroupReplyHolder extends RecyclerView.ViewHolder {
        private TextView textViewNumber;
        private TextView textViewName;
        private TextView textViewContent;
        public GroupReplyHolder(View itemView) {
            super(itemView);
            textViewNumber = itemView.findViewById(R.id.thread_discussion_number);
            textViewName = itemView.findViewById(R.id.thread_discussion_name);
            textViewContent = itemView.findViewById(R.id.thread_discussion_content);
        }
    }

}