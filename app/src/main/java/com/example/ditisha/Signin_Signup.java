package com.example.ditisha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Signin_Signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin_signup);

        Button btn1 = (Button) findViewById(R.id.signin);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Signin_Signup.this, Sign_In.class);
                startActivity(intent);
            }
        });
        Button btn2 = (Button) findViewById(R.id.signup);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Signin_Signup.this, SignUp.class);
                startActivity(intent);
            }
        });

    }
}