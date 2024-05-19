package com.example.ditisha;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BMI extends AppCompatActivity {
    EditText editTextWeight, editTextHeight;
    Button btnCalculate;
    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        editTextWeight = findViewById(R.id.Weight);
        editTextHeight = findViewById(R.id.Height);
        btnCalculate = findViewById(R.id.Calculate);
        textViewResult = findViewById(R.id.textViewResult);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        String weightStr = editTextWeight.getText().toString();
        String heightStr = editTextHeight.getText().toString();

        if (!weightStr.isEmpty() && !heightStr.isEmpty()) {
            float weight = Float.parseFloat(weightStr);
            float heightInFeet = Float.parseFloat(heightStr);

            // Convert height from feet to meters
            float heightInMeters = heightInFeet * 0.3048f;

            float bmi = weight / (heightInMeters * heightInMeters);

            String result = "Your BMI is: " + bmi;

            if (bmi < 18.5) {
                result += "\nUnderweight";
            } else if (bmi >= 18.5 && bmi < 25) {
                result += "\nNormal weight";
            } else if (bmi >= 25 && bmi < 30) {
                result += "\nOverweight";
            } else {
                result += "\nObese";
            }

            textViewResult.setText(result);
        } else {
            textViewResult.setText("Please enter both weight and height.");
        }
    }
}