package com.michael.campuz.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.michael.campuz.R;

public class StudyGroupThreadView extends LinearLayout {
    public StudyGroupThreadView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.study_group_thread_layout,this);

    }
}
