package com.michael.campuz.ui.member;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.michael.campuz.R;
import com.orhanobut.logger.Logger;


public class MemberResourcesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Logger.i("Logged-in");

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
                                Intent intent = new Intent(MemberResourcesActivity.this, MemberDiscussionActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);
                                break;
                            }
                            case R.id.navigation_group: {
                                Intent intent = new Intent(MemberResourcesActivity.this, GroupActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);
                                break;
                            }
                            case R.id.navigation_resources: {
                                break;
                            }
                            case R.id.navigation_notifications: {
                                Intent intent = new Intent(MemberResourcesActivity.this, MemberNotificationsActivity.class);
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
//                Intent intent = new Intent(MemberMainActivity.this, LoginActivity.class);
//                myActivityLauncher.launch("michael");

                        break;
                    default:
                        return false;
                }
                return true;
            }
        });


        /** Title **/
        TextView textView = findViewById(R.id.page_title);
        textView.setText(R.string.title_resources);
    }

}