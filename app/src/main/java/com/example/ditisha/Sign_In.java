package com.example.ditisha;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Sign_In extends AppCompatActivity {
    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button signInButton;
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        // Initialize Database Reference
        mDatabase = FirebaseDatabase.getInstance().getReference();

        // Get references to the views
        usernameEditText = findViewById(R.id.name);
        passwordEditText = findViewById(R.id.pass_signin);
        signInButton = findViewById(R.id.OK);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signInUser();
            }
        });
    }
    private void signInUser() {
        String username = usernameEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        // Validate input
        if (TextUtils.isEmpty(username)) {
            usernameEditText.setError("Username is required");
            return;
        }

        if (TextUtils.isEmpty(password)) {
            passwordEditText.setError("Password is required");
            return;
        }

        // Query the database to find the user by username
        mDatabase.child("users").orderByChild("username").equalTo(username)
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            // User found
                            for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                                User user = userSnapshot.getValue(User.class);
                                if (user != null) {
                                    // Validate password
                                    if (user.password.equals(password)) {
                                        // Sign-in successful
                                        updateUI(user);
                                    } else {
                                        // Password is incorrect
                                        Toast.makeText(Sign_In.this, "Invalid password", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        } else {
                            // User not found
                            Toast.makeText(Sign_In.this, "User not found", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(Sign_In.this, "Database error: " + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void updateUI(User user) {
        // Example: Display user information or navigate to another activity
        Toast.makeText(this, "Welcome, " + user.username, Toast.LENGTH_SHORT).show();
        // Navigate to another activity, e.g., MainActivity
        Intent intent = new Intent(Sign_In.this, Home.class);
        intent.putExtra("username", user.username);
        intent.putExtra("age", user.age);
        startActivity(intent);
        finish();
    }
}