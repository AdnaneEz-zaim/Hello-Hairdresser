package com.example.hellohairdresser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Login extends AppCompatActivity {
    Button loginBtn;
    TextView newAcompteBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginBtn = findViewById(R.id.loginBtn);
        newAcompteBtn = findViewById(R.id.newAcompteBtn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent switchToArView = new Intent(Login.this, HomeClient.class);
                startActivity(switchToArView);
                finish();
            }
        });
        newAcompteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent switchToArView = new Intent(Login.this, Registration.class);
                startActivity(switchToArView);
            }
        });

    }
}