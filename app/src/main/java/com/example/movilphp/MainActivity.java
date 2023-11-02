package com.example.movilphp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText usernameEditText;
    EditText passwordEditText;
    Button loginButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateFields();
            }
        });
    }

    public void validateFields(){

        //Empty fields
        String username = usernameEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        if (username.isEmpty()) {
            usernameEditText.setError("Username cannot be empty!");
            return;
        }

        if (password.isEmpty()) {
            passwordEditText.setError("Password cannot be empty!");
            return;
        }

        //user format validation
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (!username.matches(emailPattern)) {
            usernameEditText.setError("Invalid email format!");
            return;
        }

        //password validation
        if (password.length() < 8) {
            passwordEditText.setError("Password should be at least 8 characters long!");
            return;
        }

        String passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$";
        if (!password.matches(passwordPattern)) {
            passwordEditText.setError("Password must contain an uppercase letter, lowercase letter, a number, and a special character!");
            return;
        }
    }
}