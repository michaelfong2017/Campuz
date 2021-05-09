package com.michael.campuz.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.michael.campuz.R;
import com.orhanobut.logger.Logger;

public class OpenGroupActivity extends AppCompatActivity {

    public static final String EXTRA_TITLE = "title";
    public static final String EXTRA_DESCRIPTION = "description";
    public static final String EXTRA_FROM = "from";
    public static final String EXTRA_TO = "to";
    public static final String EXTRA_JOIN_MODE = "join_mode";
    public static final String EXTRA_KICK_MODE = "kick_mode";


    private EditText editTextTitle;
    private EditText editTextDescription;
    private EditText editTextFrom;
    private EditText editTextTo;

    private String joinMode = "";
    private String kickMode = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_group);

        editTextTitle = findViewById(R.id.group_thread_edit_title);
        editTextDescription = findViewById(R.id.group_thread_edit_description);
        editTextFrom = findViewById(R.id.group_thread_edit_from);
        editTextTo = findViewById(R.id.group_thread_edit_to);
    }

    private void saveThread() {
        String title = editTextTitle.getText().toString();
        String description = editTextDescription.getText().toString();

        int from, to;
        try {
            from = Integer.parseInt(editTextFrom.getText().toString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return;
        }
        try {
            to = Integer.parseInt(editTextTo.getText().toString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return;
        }

        if (title.trim().isEmpty() || description.trim().isEmpty()
                || joinMode.isEmpty() || kickMode.isEmpty()) {
            return;
        }

        Intent data = new Intent();
        data.putExtra(EXTRA_TITLE, title);
        data.putExtra(EXTRA_DESCRIPTION, description);
        data.putExtra(EXTRA_FROM, from);
        data.putExtra(EXTRA_TO, to);
        data.putExtra(EXTRA_JOIN_MODE, joinMode);
        data.putExtra(EXTRA_KICK_MODE, kickMode);
        setResult(RESULT_OK, data);
        finish();
    }

    public void onFreeToJoin(View view) {
        Logger.d("onFreeToJoin");
        joinMode = "free";
    }
    public void onRequestOrInvitation(View view) {
        Logger.d("onRequestOrInvitation");
        joinMode = "request_or_invitation";
    }
    public void onInvitationOnly(View view) {
        Logger.d("onInvitationOnly");
        joinMode = "invitation";
    }
    public void onKickByAuthor(View view) {
        Logger.d("onKickByAuthor");
        kickMode = "author";
    }
    public void onVoteKick(View view) {
        Logger.d("onVoteKick");
        kickMode = "vote";
    }

    public void onSubmit(View view) {
        Logger.d("onSubmit");
        saveThread();
    }
}