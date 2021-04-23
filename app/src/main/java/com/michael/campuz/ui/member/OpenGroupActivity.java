package com.michael.campuz.ui.member;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.michael.campuz.R;
import com.orhanobut.logger.Logger;

public class OpenGroupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_group);
    }

    public void onFreeToJoin(View view) {
        Logger.d("onFreeToJoin");
    }
    public void onRequestOrInvitation(View view) {
        Logger.d("onRequestOrInvitation");

    }
    public void onInvitationOnly(View view) {
        Logger.d("onInvitationOnly");

    }
    public void onKickByAuthor(View view) {
        Logger.d("onKickByAuthor");

    }
    public void onVoteKick(View view) {
        Logger.d("onVoteKick");

    }

    public void onSubmit(View view) {
        Logger.d("onSubmit");
        Intent intent = new Intent(OpenGroupActivity.this, FakeGroupActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}