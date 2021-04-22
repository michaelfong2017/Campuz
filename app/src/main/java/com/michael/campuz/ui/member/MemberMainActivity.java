package com.michael.campuz.ui.member;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.michael.campuz.R;
import com.orhanobut.logger.Logger;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MemberMainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration appBarConfiguration;

    /** Firebase google signin **/
    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onStart() {
        super.onStart();
//        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Logger.i("Logged-in");

        /** Sidebar with drawer **/
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView sideNavigationView = findViewById(R.id.side_nav_view);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(sideNavigationView, navController);

        /** Bottom navigation bar **/
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
//        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.option_login:
//                Intent intent = new Intent(MemberMainActivity.this, LoginActivity.class);
//                myActivityLauncher.launch("michael");
                break;
            default:
                return false;
        }
        return true;
    }
}