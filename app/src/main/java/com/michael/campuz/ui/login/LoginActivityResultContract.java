package com.michael.campuz.ui.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class LoginActivityResultContract extends ActivityResultContract<String, String> {
    @NonNull
    @Override
    public Intent createIntent(@NonNull Context context, String input) {
        Intent intent = new Intent(context, LoginActivity.class);
        intent.putExtra("name", input);
        return intent;
    }

    @Override
    public String parseResult(int resultCode, @Nullable Intent intent) {
        if (intent == null) {
            return null;
        }
        String data = intent.getStringExtra("result");
        if (resultCode == Activity.RESULT_OK && data != null) {
            return data;
        }
        return null;
    }
}
