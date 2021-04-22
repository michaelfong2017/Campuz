package com.michael.campuz.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.michael.campuz.R;
import com.orhanobut.logger.Logger;

public class GroupThreadView extends LinearLayout {
    private String threadTitle;
    private String threadStatus;
    private String threadNumberOfComment;

    public GroupThreadView(Context context) {
        super(context);
        init(context);
    }

    public GroupThreadView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public GroupThreadView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    public GroupThreadView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.GroupThreadView);
        try {
            threadTitle = ta.getString(R.styleable.GroupThreadView_threadTitle);
            threadStatus = ta.getString(R.styleable.GroupThreadView_threadStatus);
            threadNumberOfComment = String.valueOf(ta.getInt(R.styleable.GroupThreadView_threadNumberOfComment, 0));
        } finally {
            ta.recycle();
        }
        init(context);
    }

    private void init(Context context) {
        inflate(getContext(), R.layout.group_thread_layout,this);

        TextView title = findViewById(R.id.thread_title);
        title.setText(threadTitle);

        TextView status = findViewById(R.id.thread_status);
        status.setText(threadStatus);

        TextView numberOfComment = findViewById(R.id.thread_number_of_comment);
        numberOfComment.setText(threadNumberOfComment);
    }
}
