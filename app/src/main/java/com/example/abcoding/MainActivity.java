package com.example.abcoding;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.ActionMenuItem;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private static final int ROOT_FRAGMENT_TAG = 1;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    BottomNavigationView bottomNavigation;
    FrameLayout Container;
    Button logoutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this, "Welcome To ABCoding", Toast.LENGTH_SHORT).show();

        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);

        //seting a toggle
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_Drawer, R.string.close_Drawer);
        drawerLayout.addDrawerListener(toggle);

        toggle.syncState();


        bottomNavigation = findViewById(R.id.bottomNavigation);
        Container = findViewById(R.id.Contanier);

        //by default load fragment
        loadFragment(new FragmentHome(), 0);

        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if(itemId == R.id.nav_Home){
                    loadFragment(new FragmentHome(), 1);
                }
                else if (itemId == R.id.nav_MyCourse){
                    loadFragment(new FragmentMyCourse(), 1);
                }
                else if (itemId == R.id.nav_HelpCenter){
                    loadFragment(new FragmentHelpCenter(), 1);
                }
                else if (itemId == R.id.nav_Account){
                    loadFragment(new FragmentAccount(), 1);
                }
                return true;
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if(itemId == R.id.nav_Home){
                    loadFragment(new FragmentHome(), 1);
                }
                else if (itemId == R.id.nav_MyCourse){
                    loadFragment(new FragmentMyCourse(), 1);
                }
                else if (itemId == R.id.nav_HelpCenter){
                    loadFragment(new FragmentHelpCenter(), 1);
                }
                else if(itemId == R.id.nav_AboutUs){
                    loadFragment(new FragmentAboutUs(), 1);
                }
                else if (itemId == R.id.nav_TermsCondition){
                    loadFragment(new FragmentTermsCondition(), 1);
                }
                else if (itemId == R.id.nav_ContactMe){
                    loadFragment(new FragmentContactMe(), 1);
                }

                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        logoutBtn = findViewById(R.id.logoutBtn);
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getSharedPreferences("Register", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putBoolean("flag", false);
                editor.apply();

                Intent inext = new Intent(MainActivity.this,Login.class);
                startActivity(inext);
            }
        });

    }


    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            AlertDialog ad = new AlertDialog.Builder(this).create();
            ad.setTitle("Alert");
            ad.setMessage("You want to exit app");
            ad.setIcon(R.drawable.ic_baseline_exit_to_app_24);
            ad.setButton(DialogInterface.BUTTON_POSITIVE, "Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    MainActivity.super.onBackPressed();
                    Toast.makeText(MainActivity.this, "Exit app", Toast.LENGTH_SHORT).show();
                }
            });
            ad.setButton(DialogInterface.BUTTON_NEGATIVE, "No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this, "Welcome ABCoding", Toast.LENGTH_SHORT).show();
                }
            });
            ad.setButton(DialogInterface.BUTTON_NEUTRAL, "Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            ad.show();
        }
    }

    public void loadFragment(Fragment fragment,int flag){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if(flag==0){
            ft.add(R.id.Contanier, fragment);
//            fm.popBackStack(FragmentManager.POP_BACK_STACK_INCLUSIVE, ROOT_FRAGMENT_TAG);
//            ft.addToBackStack(String.valueOf(ROOT_FRAGMENT_TAG));
        }
        else{
            ft.replace(R.id.Contanier, fragment);
//            ft.addToBackStack(null);
        }
        ft.commit();
    }

}
