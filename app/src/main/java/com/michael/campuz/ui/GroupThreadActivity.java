package com.michael.campuz.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.michael.campuz.R;
import com.michael.campuz.ui.view.GroupThreadDiscussionView;
import com.orhanobut.logger.Logger;

public class GroupThreadActivity extends AppCompatActivity {
    private int currentNumber = 1;
    public static final String EXTRA_GROUP_ID = "group_id";

    private String content="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fake_group_thread);

        int groupId = getIntent().getIntExtra(EXTRA_GROUP_ID, -1);
        Logger.d(groupId);

        // your text box
        final EditText edit_txt = (EditText) findViewById(R.id.group_thread_edit_reply);

        edit_txt.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                Logger.d(textView.getText());

                content= ""+ textView.getText();

                addDiscussion();
                return false;
            }
        });

    }

    private void addDiscussion() {
        LinearLayout linearLayout = findViewById(R.id.thread_discussion_linear);
        GroupThreadDiscussionView view = new GroupThreadDiscussionView(this);
        view.setNumber("#" + String.valueOf(++currentNumber));
        view.setName("Michael Fong");
        view.setContent(content);
        linearLayout.addView(view);
    }

    public void onJoinGroup(View view) {
        Intent intent = new Intent(GroupThreadActivity.this, GroupChatRoomActivity.class);
        startActivity(intent);
    }
}