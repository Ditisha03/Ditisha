package com.example.ditisha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HealthTips extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_tips);

        Button btn1 = (Button) findViewById(R.id.one);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HealthTips.this, Tips1.class);
                startActivity(intent);
            }
        });

        Button btn2 = (Button) findViewById(R.id.two);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HealthTips.this, Tips2.class);
                startActivity(intent);
            }
        });
        Button btn3 = (Button) findViewById(R.id.three);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HealthTips.this, Tips3.class);
                startActivity(intent);
            }
        });

        Button btn4 = (Button) findViewById(R.id.four);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HealthTips.this, Tips4.class);
                startActivity(intent);
            }
        });

        Button btn5 = (Button) findViewById(R.id.five);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HealthTips.this, Tips5.class);
                startActivity(intent);
            }
        });
    }
}