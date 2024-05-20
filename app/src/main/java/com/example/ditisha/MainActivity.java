package com.example.ditisha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FirebaseApp.initializeApp(this);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        //mDatabase.setValue("Hello");
       // writeNewUser("1", "Jhinuk", "1234", 5, "jhinuk");

       // writeNewUser("2", "Abir", "12345", 5, "abir");
        ImageView sohoj = (ImageView) findViewById(R.id.sohoj);
        sohoj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Signin_Signup.class);
                startActivity(intent);

            }
        });

    }
    private void writeNewUser(String userId, String name, String phone, int age, String password ) {
        User user = new User(name, phone, age, password);
        mDatabase.child("users").child(userId).setValue(user);
    }
}