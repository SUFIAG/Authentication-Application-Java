package com.example.completeauthenticationapp_java;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button emailLoginButton, OTPLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailLoginButton = findViewById(R.id.button);
        OTPLoginButton = findViewById(R.id.button2);

        emailLoginButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, EmailLoginPage.class);
            startActivity(intent);
            finish();
        });

        OTPLoginButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, OTPLoginPage.class);
            startActivity(intent);
            finish();
        });
    }
}