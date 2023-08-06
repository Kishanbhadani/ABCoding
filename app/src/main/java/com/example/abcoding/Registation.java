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

public class Registation extends AppCompatActivity {

    EditText Username,Password,ConfirmPass;
    Button RegBtn;
    TextView textlog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registation);
        Username = findViewById(R.id.Username);
        Password = findViewById(R.id.Password);
        ConfirmPass = findViewById(R.id.ConfirmPass);
        RegBtn = findViewById(R.id.RegBtn);
        textlog = findViewById(R.id.textlog);



        RegBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Pname = Username.getText().toString();
                String Ppass = Password.getText().toString();
                String Pconpass = ConfirmPass.getText().toString();

                SharedPreferences pref = getSharedPreferences("Register", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("UserName", Pname);
                editor.putString("UserPass", Ppass);
                editor.apply();

                if (Pname.equals("") || Ppass.equals("")){
                    Toast.makeText(Registation.this, "Please enter detail", Toast.LENGTH_SHORT).show();
                }else {

                    if (Ppass.equals(Pconpass)) {
                        Toast.makeText(Registation.this, "Succesfully Registered", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Registation.this, Login.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(Registation.this, "correct password not match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


        textlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inext = new Intent(Registation.this, Login.class);
                startActivity(inext);
            }
        });



    }
}