package com.michael.campuz.ui.member;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;

import com.michael.campuz.R;
import com.orhanobut.logger.Logger;

public class FakeGroupThreadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fake_group_thread);

        // your text box
        final EditText edit_txt = (EditText) findViewById(R.id.group_thread_edit_reply);

        edit_txt.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                Logger.d(textView.getText());
                edit_txt.clearFocus();
                return false;
            }
        });
    }
}