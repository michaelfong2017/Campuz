package com.michael.campuz.ui.member;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.michael.campuz.R;
import com.michael.campuz.ui.member.group.GroupThread;
import com.michael.campuz.ui.member.group.GroupViewModel;
import com.michael.campuz.ui.view.GroupThreadView;
import com.orhanobut.logger.Logger;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;


public class FakeGroupActivity extends AppCompatActivity {

    private GroupViewModel groupViewModel;

    private LinearLayout scrollLinear;

    private int currentThreadId = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group_activity_main);

        Logger.i("Logged-in");

        /** Initialize UI elements **/
        scrollLinear = findViewById(R.id.group_scroll_linear);

        /** ViewModel **/
        groupViewModel = new ViewModelProvider(this).get(GroupViewModel.class);
        groupViewModel.getGroupThreads().observe(this, new Observer<List<GroupThread>>() {
            @Override
            public void onChanged(List<GroupThread> groupThreads) {
                Logger.d(groupThreads);
                if (groupThreads == null || groupThreads.size() == 0) {
                    return;
                }
                scrollLinear.addView(createThread(groupThreads.get(groupThreads.size()-1).getTitle(), groupThreads.get(groupThreads.size()-1).getStatus(), String.valueOf(groupThreads.get(groupThreads.size()-1).getNumberOfComments())));


            }
        });

        groupViewModel.createThread("COMP7506", "Open", 1);


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
//                                Intent intent = new Intent(MemberGroupActivity.this, MemberDiscussionActivity.class);
//                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                                startActivity(intent);
                                break;
                            }
                            case R.id.navigation_group: {
                                Intent intent = new Intent(FakeGroupActivity.this, MemberGroupActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);
                                break;
                            }
                            case R.id.navigation_resources: {
//                                Intent intent = new Intent(MemberGroupActivity.this, MemberResourcesActivity.class);
//                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                                startActivity(intent);
                                break;
                            }
                            case R.id.navigation_notifications: {
//                                Intent intent = new Intent(MemberGroupActivity.this, MemberNotificationsActivity.class);
//                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                                startActivity(intent);
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
                        Intent intent = new Intent(FakeGroupActivity.this, OpenGroupActivity.class);
                        startActivity(intent);

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

    public void onThreadSubmit(View view) {
        Logger.d("onThreadSubmit");
        Intent intent = new Intent(FakeGroupActivity.this, FakeGroupThreadActivity.class);
        startActivity(intent);
    }

}