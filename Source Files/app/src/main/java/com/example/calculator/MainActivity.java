package com.example.calculator;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

//External Library and Functions
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import net.objecthunter.exp4j.operator.Operator;

//Implement Boolean True and False
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //TextViews on MainScreen
    TextView txtCalculations;
    TextView txtResults;

    boolean number = FALSE;

    //History Page Database
    public static String h1_equation;
    public static String h2_equation;
    public static String h3_equation;
    public static String h4_equation;
    public static String h5_equation;

    //Equation Initiator
    private String equation="";

    //History Counter
    int count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Control the TextViews
        txtCalculations = findViewById(R.id.txtCalculations);
        txtResults = findViewById(R.id.txtResults);

        //TextView Initiators
        txtResults.setText("");
        txtCalculations.setText("");

        //To Allow the User to click the Buttons
        findViewById(R.id.btnequal).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn0).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn1).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn2).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn3).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn4).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn5).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn6).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn7).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn8).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn9).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnadd).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnsub).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnmul).setOnClickListener(MainActivity.this);
        findViewById(R.id.btndiv).setOnClickListener(MainActivity.this);
        findViewById(R.id.btndot).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnClear).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnpercentage).setOnClickListener(MainActivity.this);
        findViewById(R.id.btndelete).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnHistory).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnbracket).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnsin).setOnClickListener(MainActivity.this);
        findViewById(R.id.btncos).setOnClickListener(MainActivity.this);
        findViewById(R.id.btntan).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnpower).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnsqrt).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnlog).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnln).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnpi).setOnClickListener(MainActivity.this);
        findViewById(R.id.btne).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnexp).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnphi).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnfactorial).setOnClickListener(MainActivity.this);
    }

    //Tells what effect the Buttons have
        @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn7:
                equation+= '7';
                break;
            case R.id.btn8:
                equation+= '8';
                break;
            case R.id.btn9:
                equation+= '9';
                break;
            case R.id.btndiv:
                if (equation.equals("")) {
                    equation="";
                } else
                equation+= '/';
                break;
            case R.id.btn4:
                equation+= '4';
                break;
            case R.id.btn5:
                equation+= '5';
                break;
            case R.id.btn6:
                equation+= '6';
                break;
            case R.id.btnmul:
                if (equation.equals("")) {
                    equation="";
                }
                else
                equation+= '*';
                break;
            case R.id.btn1:
                equation+= '1';
                break;
            case R.id.btn2:
                equation+= '2';
                break;
            case R.id.btn3:
                equation+= '3';
                break;
            case R.id.btnsub:
                equation+= '-';
                break;
            case R.id.btn0:
                equation+= '0';
                break;
            case R.id.btnClear:
                clearTapped();
                break;
            case R.id.btnequal:
                equalIsTapped();
                break;
            case R.id.btnadd:

                equation+= '+';
                break;
            case R.id.btndot:
                equation+= '.';
                break;
            case R.id.btnpercentage:
                if (equation.equals("")) {
                    equation="";
                } else
                equation+= '%';
                break;
            case R.id.btndelete:
                if(equation.length()>1){
                    equation= equation.substring(0,equation.length()-1);
                }
                else{
                    equation="";
                }
                break;
            case R.id.btnHistory:
                startActivity(new Intent(MainActivity.this,History.class));
                break;
            case R.id.btnbracket:
                if(number == FALSE){
                    equation+="(";
                    number= TRUE;
                }
                else
                {
                    equation+=")";
                    number= FALSE;
                }
                break;
            case R.id.btnsin:
                equation+= "sin(";
                number= TRUE;
                break;
            case R.id.btncos:
                equation+= "cos(";
                number= TRUE;
                break;
            case R.id.btntan:
                equation+= "tan(";
                number= TRUE;
                break;
            case R.id.btnpower:
                equation+= '^';
                break;
            case R.id.btnlog:
                equation+= "log10(";
                number=TRUE;
                break;
            case R.id.btnln:
                equation+= "log(";
                number=TRUE;
                break;
            case R.id.btnsqrt:
                equation+= "sqrt(";
                number=TRUE;
                break;
            case R.id.btnpi:
                equation+= 'π';
                break;
            case R.id.btne:
                equation+='e';
                break;
            case R.id.btnexp:
                equation+= "exp(";
                number=TRUE;
                break;
            case R.id.btnphi:
                equation+='φ';
                break;
            case R.id.btnfactorial:
                equation+='!';
                break;
        }
        txtCalculations.setText(equation);
    }


    //Function to give answer to the equation
    @SuppressLint("SetTextI18n")
    private void equalIsTapped(){
        try {
            //External Library Function
            Expression e = new ExpressionBuilder(equation)
                    .operator(factorial)
                    .build();

            float result = (float) e.evaluate();
            //Remove Very Small Numbers
            if(result < 1E-14 && result >0){
                result=0;
            }
            //To give answer in Integers if possible
            String Result = String.valueOf(result);
            String last = Result.substring(Result.length()-2);
            if(last.equals(".0"))
            {
                Result= Result.substring(0,Result.length()-2);
            }

            //Set the Answers to the Screen
            txtResults.setText(Result);
            txtCalculations.setTextSize(14);

            //Adding to History
            switch (count){
                case 1:
                    h1_equation=equation + " = " + Result;
                    break;
                case 2:
                    h2_equation=equation + " = " + Result;
                    break;
                case 3:
                    h3_equation=equation + " = " + Result;
                    break;
                case 4:
                    h4_equation=equation + " = " + Result;
                    break;
                case 5:
                    h5_equation=equation + " = " + Result;
                    break;
            }
            count++;
            if(count == 6){
                count =1;
            }
        }
        //To prevent app from Crashing
        catch (Exception e){
            txtResults.setText("Invalid Equation");
            txtCalculations.setTextSize(14);
        }
    }


    //To get clear screen
    private void clearTapped(){
        txtResults.setText("");
        txtCalculations.setText("");
        equation="";
        txtCalculations.setTextSize(50);
        number = FALSE;
    }

    //Implementing our own Function in the External Library
    Operator factorial = new Operator("!", 1, true, Operator.PRECEDENCE_POWER + 1) {

        @Override
        public double apply(double... args) {
            final int arg = (int) args[0];
            if (arg < 0) {
                throw new IllegalArgumentException("The operand of the factorial can not be less than zero");
            }
            double result = 1;
            for (int i = 1; i <= arg; i++) {
                result *= i;
            }
            return result;
        }
    };
}
