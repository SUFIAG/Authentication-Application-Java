package com.example.completeauthenticationapp_java;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.hbb20.CountryCodePicker;

public class OTPLoginPage extends AppCompatActivity {
    CountryCodePicker countryCodePicker;
    Button sendOTPButton, backButton;
    EditText mobileNumberField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otplogin_page);
        mobileNumberField = findViewById(R.id.editText50);
        countryCodePicker = findViewById(R.id.ccp);
        countryCodePicker.registerCarrierNumberEditText(mobileNumberField);
        sendOTPButton = findViewById(R.id.button7);
        backButton = findViewById(R.id.button8);

        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(OTPLoginPage.this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        sendOTPButton.setOnClickListener(v -> {
            Intent intent = new Intent(OTPLoginPage.this, NextPage.class);
            intent.putExtra("mobileNumber", countryCodePicker.getFullNumberWithPlus().trim());
            startActivity(intent);
        });
    }
}