package com.michael.campuz.ui.guest;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.michael.campuz.R;
import com.michael.campuz.ui.login.LoginActivity;
import com.orhanobut.logger.Logger;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class GuestDiscussionActivity extends AppCompatActivity {

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
                                break;
                            }
                            case R.id.navigation_group: {
                                break;
                            }
                            case R.id.navigation_resources: {
                                break;
                            }
                            case R.id.navigation_notifications: {
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
                        Intent intent = new Intent(GuestDiscussionActivity.this, LoginActivity.class);
                        startActivity(intent);
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
    }


}