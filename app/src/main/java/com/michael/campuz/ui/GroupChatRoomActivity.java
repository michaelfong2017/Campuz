package com.michael.campuz.ui;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.TextView;

import com.michael.campuz.R;
import com.michael.campuz.data.group.Group;
import com.michael.campuz.ui.group.GroupViewModel;
import com.orhanobut.logger.Logger;

import dagger.hilt.android.AndroidEntryPoint;

import static com.michael.campuz.ui.GroupThreadActivity.EXTRA_GROUP_ID;

@AndroidEntryPoint
public class GroupChatRoomActivity extends AppCompatActivity {

    TextView textViewTitle;

    private GroupViewModel groupViewModel;

    private int groupId;
    private Group currentGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_chat_room);


        groupId = getIntent().getIntExtra(EXTRA_GROUP_ID, -1);
        Logger.d(groupId);


        textViewTitle = findViewById(R.id.page_title2);

        groupViewModel = new ViewModelProvider(this).get(GroupViewModel.class);
        groupViewModel.getGroupById(groupId).observe(this, new Observer<Group>() {
            @Override
            public void onChanged(@Nullable Group group) {
//                Logger.d(group.getTitle());
//                Logger.d(group.getDescription());
                currentGroup = group;
                textViewTitle.setText(currentGroup.getTitle());
            }
        });
    }
}