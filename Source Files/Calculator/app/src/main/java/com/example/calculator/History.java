package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import static com.example.calculator.MainActivity.h1_equation;
import static com.example.calculator.MainActivity.h2_equation;
import static com.example.calculator.MainActivity.h3_equation;
import static com.example.calculator.MainActivity.h4_equation;
import static com.example.calculator.MainActivity.h5_equation;

public class History extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        TextView txt1 = findViewById(R.id.txthistory1);
        TextView txt2 = findViewById(R.id.txthistory2);
        TextView txt3 = findViewById(R.id.txthistory3);
        TextView txt4 = findViewById(R.id.txthistory4);
        TextView txt5 = findViewById(R.id.txthistory5);
        
        txt1.setText(h1_equation);
        txt2.setText(h2_equation);
        txt3.setText(h3_equation);
        txt4.setText(h4_equation);
        txt5.setText(h5_equation);
    }
}


