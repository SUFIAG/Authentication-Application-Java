package com.example.completeauthenticationapp_java;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class EmailLoginPage extends AppCompatActivity {
    EditText emailField, passwordField;
    Button loginButton, signUpButton;
    ProgressBar progressBar;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_login_page);
        emailField = findViewById(R.id.editText);
        passwordField = findViewById(R.id.editText2);
        passwordField.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        loginButton = findViewById(R.id.button3);
        signUpButton = findViewById(R.id.button4);
        progressBar = findViewById(R.id.progressBar);
        firebaseAuth = FirebaseAuth.getInstance();

        signUpButton.setOnClickListener(v -> {
            Intent intent = new Intent(EmailLoginPage.this, SignUpPage.class);
            startActivity(intent);
            finish();
        });

        loginButton.setOnClickListener(v -> {
            String email = emailField.getText().toString();
            String password = passwordField.getText().toString();

            if (email.isEmpty()) {
                emailField.setError("Please Enter Your Email!");
            } else {
                if (password.isEmpty()) {
                    passwordField.setError("Please Enter Your Password!");
                }
            }
            progressBar.setVisibility(View.VISIBLE);
            firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    Toast.makeText(EmailLoginPage.this, "Logged In Successfully.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(EmailLoginPage.this, WelcomePage.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(EmailLoginPage.this, "Error! Please Check Your Email & Password.", Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}