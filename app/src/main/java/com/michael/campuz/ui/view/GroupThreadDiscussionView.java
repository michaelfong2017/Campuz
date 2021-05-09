package com.michael.campuz.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.michael.campuz.R;

public class GroupThreadDiscussionView extends LinearLayout {

    public GroupThreadDiscussionView(Context context) {
        super(context);
        init(context);
    }

    public GroupThreadDiscussionView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public GroupThreadDiscussionView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    public GroupThreadDiscussionView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }


    private void init(Context context, AttributeSet attrs) {
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.group_reply_item,this);
    }

    public void setNumber(String number) {
        TextView v = findViewById(R.id.thread_discussion_number);
        v.setText(number);
    }
    public void setName(String name) {
        TextView v = findViewById(R.id.thread_discussion_name);
        v.setText(name);
    }public void setContent(String content) {
        TextView v = findViewById(R.id.thread_discussion_content);
        v.setText(content);
    }


}
