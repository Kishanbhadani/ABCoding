package com.example.abcoding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText fianlPass, fianlUsername;
    Button logBtn;
    TextView textReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        fianlUsername = findViewById(R.id.fianlUsername);
        fianlPass = findViewById(R.id.finalPass);
        logBtn = findViewById(R.id.logBtn);
        textReg = findViewById(R.id.textReg);

        logBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String PUname = fianlUsername.getText().toString();
                String PUpass = fianlPass.getText().toString();

                SharedPreferences pref = getSharedPreferences("Register", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();

                String name = pref.getString("UserName",null);
                String pass =  pref.getString("UserPass", null);

                if (fianlUsername.equals("") || fianlPass.equals((""))){
                    Toast.makeText(Login.this, "Please enter details", Toast.LENGTH_SHORT).show();
                } else {
                    if ((PUname.equals(name)) && (PUpass.equals(pass))) {
                        editor.putBoolean("flag", true);
                        editor.apply();

                        Toast.makeText(Login.this, "Succesfully Login", Toast.LENGTH_SHORT).show();

                        Intent inext = new Intent(Login.this, MainActivity.class);
                        startActivity(inext);
                    } else {
                        Toast.makeText(Login.this, "Wrong details", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        textReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inext = new Intent(Login.this,Registation.class);
                startActivity(inext);
            }
        });

    }
}