package com.example.ditisha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUp extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText phoneEditText;
    private EditText ageEditText;
    private EditText passwordEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        usernameEditText = findViewById(R.id.username);
        phoneEditText = findViewById(R.id.phone);
        ageEditText = findViewById(R.id.age);
        passwordEditText = findViewById(R.id.password);

        Button btn1 = (Button) findViewById(R.id.OK2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               createUser();
                //Intent intent = new Intent(SignUp.this, Home.class);
                //startActivity(intent);
            }
        });
    }

    private void createUser() {
        String username = usernameEditText.getText().toString().trim();
        String phone = phoneEditText.getText().toString().trim();
        String age_str = ageEditText.getText().toString().trim();
        int age = 0;
        String password = passwordEditText.getText().toString().trim();

        // Validate input
        if (TextUtils.isEmpty(username)) {
            usernameEditText.setError("Username is required");
            return;
        }

        if (TextUtils.isEmpty(phone)) {
            phoneEditText.setError("Phone Number is required");
            return;
        }

        if (TextUtils.isEmpty(age_str)) {
            ageEditText.setError("Age is required");
            return;
        }
        else {
            age = Integer.parseInt(age_str);
        }
        if (TextUtils.isEmpty(password)) {
            passwordEditText.setError("Password is required");
            return;
        }

    }
}
