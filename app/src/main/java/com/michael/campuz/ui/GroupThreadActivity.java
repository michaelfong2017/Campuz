package com.michael.campuz.ui;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.michael.campuz.R;
import com.michael.campuz.data.group.Group;
import com.michael.campuz.data.group.GroupReply;
import com.michael.campuz.ui.group.GroupViewModel;
import com.michael.campuz.ui.view.GroupThreadDiscussionView;
import com.orhanobut.logger.Logger;

import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class GroupThreadActivity extends AppCompatActivity {
    public static final String EXTRA_GROUP_ID = "group_id";

    private int groupId;
    private Group currentGroup;

    private int currentNumberOfReplies;

    private GroupViewModel groupViewModel;

    private EditText editTextReply;
    private TextView textViewTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_thread);

        /** Find Views **/
        // your text box
        editTextReply = (EditText) findViewById(R.id.group_thread_edit_reply);
        editTextReply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String reply = editTextReply.getText().toString();

                GroupReply groupReply = new GroupReply(groupId, ++currentNumberOfReplies, "Michael Fong", reply);
                groupViewModel.insertReply(groupReply);


                currentGroup.setNumberOfComments(currentGroup.getNumberOfComments() + 1);
                groupViewModel.update(currentGroup);


                editTextReply.getText().clear();
            }
        });

        textViewTitle = (TextView) findViewById(R.id.page_title);

        /** RecyclerView **/
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final GroupReplyAdapter adapter = new GroupReplyAdapter();
        recyclerView.setAdapter(adapter);



        groupId = getIntent().getIntExtra(EXTRA_GROUP_ID, -1);
        Logger.d(groupId);

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

        groupViewModel.getAllGroupReplies().observe(this, new Observer<List<GroupReply>>() {
            @Override
            public void onChanged(List<GroupReply> groupReplies) {
                Logger.d(groupReplies.size());
                currentNumberOfReplies = groupReplies.size();
                adapter.setGroupReplies(groupReplies);
            }
        });

    }

    public void onJoinGroup(View view) {
        currentGroup.setNumberOfPeople(currentGroup.getNumberOfPeople() + 1);
        groupViewModel.update(currentGroup);

        Intent intent = new Intent(GroupThreadActivity.this, GroupChatRoomActivity.class);
        startActivity(intent);
    }
}