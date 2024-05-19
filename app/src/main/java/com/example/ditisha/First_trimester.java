package com.example.ditisha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class First_trimester extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_trimester);

        Button btn1 = (Button) findViewById(R.id.second);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(First_trimester.this, Hydration.class);
                startActivity(intent);
            }
        });

        Button btn2 = (Button) findViewById(R.id.rest);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(First_trimester.this, Rest.class);
                startActivity(intent);
            }
        });

        Button btn3 = (Button) findViewById(R.id.Care);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(First_trimester.this, Care.class);
                startActivity(intent);
            }
        });

        Button btn4 = (Button) findViewById(R.id.avoidButton);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(First_trimester.this, Avoid.class);
                startActivity(intent);
            }
        });

        Button btn5 = (Button) findViewById(R.id.nutrition);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(First_trimester.this, Nutrition.class);
                startActivity(intent);
            }
        });

    }
}