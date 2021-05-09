package com.michael.campuz.ui.member;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.michael.campuz.R;
import com.michael.campuz.data.group.Group;
import com.michael.campuz.ui.GroupAdapter;
import com.michael.campuz.ui.member.group.GroupThread;
import com.michael.campuz.ui.member.group.GroupViewModel;
import com.michael.campuz.ui.view.GroupThreadView;
import com.orhanobut.logger.Logger;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class GroupActivity extends AppCompatActivity {

    private GroupViewModel groupViewModel;

    private LinearLayout scrollLinear;

    private int currentThreadId = 3;

    private static final int OPEN_GROUP_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group_activity_main);

        Logger.i("Logged-in");

        /** Initialize UI elements **/

        /** RecyclerView **/
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final GroupAdapter adapter = new GroupAdapter();
        recyclerView.setAdapter(adapter);

        /** ViewModel **/
        groupViewModel = new ViewModelProvider(this).get(GroupViewModel.class);
        groupViewModel.getAllGroups().observe(this, new Observer<List<Group>>() {
            @Override
            public void onChanged(@Nullable List<Group> groups) {
                adapter.setGroups(groups);
            }
        });

        /** Drawer **/
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /** Sidebar **/
        NavigationView sideNavigationView = findViewById(R.id.side_nav_view);
        sideNavigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        Logger.d(menuItem);
                        switch (menuItem.getItemId()) {
                            case R.id.navigation_discussion: {
                                Intent intent = new Intent(GroupActivity.this, MemberDiscussionActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);
                                break;
                            }
                            case R.id.navigation_group: {
                                break;
                            }
                            case R.id.navigation_resources: {
                                Intent intent = new Intent(GroupActivity.this, MemberResourcesActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);
                                break;
                            }
                            case R.id.navigation_notifications: {
                                Intent intent = new Intent(GroupActivity.this, MemberNotificationsActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);
                                break;
                            }
                            default:
                                return false;
                        }

                        return true;
                    }
                });

        /** Bottom navigation bar **/
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Logger.d(item);
                switch (item.getItemId()) {
                    case R.id.option_user:
//                Intent intent = new Intent(MemberMainActivity.this, LoginActivity.class);
//                myActivityLauncher.launch("michael");
                        break;
                    case R.id.option_add:
//                        groupViewModel.createThread("hi", "open", 5);
                        Intent intent = new Intent(GroupActivity.this, OpenGroupActivity.class);
                        startActivityForResult(intent, OPEN_GROUP_REQUEST_CODE);

                        break;
                    default:
                        return false;
                }
                return true;
            }
        });


        /** Title **/
        TextView textView = findViewById(R.id.page_title);
        textView.setText(R.string.title_group);
    }

    @Override
    protected void onStop() {
        super.onStop();
//        groupViewModel.saveGroupThreads();
//        Logger.d(groupViewModel.getGroupThreads());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == OPEN_GROUP_REQUEST_CODE && resultCode == RESULT_OK) {
            String title = data.getStringExtra(OpenGroupActivity.EXTRA_TITLE);
            String description = data.getStringExtra(OpenGroupActivity.EXTRA_DESCRIPTION);
            String from = data.getStringExtra(OpenGroupActivity.EXTRA_FROM);
            String to = data.getStringExtra(OpenGroupActivity.EXTRA_TO);
            String joinMode = data.getStringExtra(OpenGroupActivity.EXTRA_JOIN_MODE);
            String kickMode = data.getStringExtra(OpenGroupActivity.EXTRA_KICK_MODE);

            Logger.d(title);
            Logger.d(description);
            Logger.d(from);
            Logger.d(to);
            Logger.d(joinMode);
            Logger.d(kickMode);

        }
    }

    public GroupThreadView createThread(String title, String status, String numberOfComments) {
        GroupThreadView view = new GroupThreadView(this);
        view.setId(currentThreadId + 1);
        currentThreadId++;
        view.setThreadTitle(title);
        view.setThreadStatus(status);
        view.setThreadNumberOfComment(numberOfComments);
        return view;
    }

    public void updateThreadWithId(int id, String title, String status, String numberOfComments) {
        String prefix = "group_thread_id_";

        int raw_id = getResources().getIdentifier(prefix + id, "id", getPackageName());
        GroupThreadView view = findViewById(raw_id);
        if (title != null)
            view.setThreadTitle(title);
        if (status != null)
            view.setThreadStatus(status);
        if (numberOfComments != null)
            view.setThreadNumberOfComment(numberOfComments);
    }

}