package com.michael.campuz.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.michael.campuz.R;

public class GroupThreadView extends LinearLayout {
    public GroupThreadView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.group_thread_layout,this);

    }
}
