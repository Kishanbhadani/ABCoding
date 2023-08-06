package com.example.abcoding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class splash_screen_app extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen_app);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPreferences = getSharedPreferences("Register", MODE_PRIVATE);
                sharedPreferences.getString("UserName", null);
                sharedPreferences.getString("UserPass", null);
                Boolean check = sharedPreferences.getBoolean("flag", false);

                Intent inext;
                if(check){
                    inext = new Intent(splash_screen_app.this,MainActivity.class);
                }else{
                    inext = new Intent(splash_screen_app.this, Registation.class);
                }
                startActivity(inext);
                finish();
            }
        }, 2000);
    }
}