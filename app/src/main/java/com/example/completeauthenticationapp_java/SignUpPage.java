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

public class SignUpPage extends AppCompatActivity {
    EditText emailField, passwordField;
    Button signUpButton, backButton;
    ProgressBar progressBar;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);
        emailField = findViewById(R.id.editText3);
        passwordField = findViewById(R.id.editText4);
        passwordField.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        signUpButton = findViewById(R.id.button5);
        backButton = findViewById(R.id.button6);
        progressBar = findViewById(R.id.progressBar2);
        firebaseAuth = FirebaseAuth.getInstance();

        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(SignUpPage.this, EmailLoginPage.class);
            startActivity(intent);
            finish();
        });

        signUpButton.setOnClickListener(v -> {
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
            firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    Toast.makeText(SignUpPage.this, "Database Updated! Please Log In To Continue.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignUpPage.this, EmailLoginPage.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(SignUpPage.this, "Error! Could not update the Database.", Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}