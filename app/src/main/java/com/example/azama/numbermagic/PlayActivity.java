package com.example.azama.numbermagic;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class PlayActivity extends AppCompatActivity {

    TextView textView1;
    TextView textView2;
    TextView result;
    Button lessButton;
    Button equalButton;
    Button biggerButton;
    int score = 0;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        initView();
        changeNumber();
        result.setText("Result: " + score);
        lessButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                int firstNumber = Integer.parseInt((String) textView1.getText());
                int secondNumber = Integer.parseInt((String) textView2.getText());
                if(firstNumber < secondNumber){
                    score++;

                }else{
                    if(score != 0) score--; else score = 0;
                }
                result.setText("Result: " + score);
                changeNumber();
            }
        });
        equalButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                int firstNumber = Integer.parseInt((String) textView1.getText());
                int secondNumber = Integer.parseInt((String) textView2.getText());
                if(firstNumber == secondNumber){
                    score++;
                }else{
                    if(score != 0) score--; else score = 0;
                }
                result.setText("Result: " + score);
                changeNumber();
            }
        });
        biggerButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                int firstNumber = Integer.parseInt((String) textView1.getText());
                int secondNumber = Integer.parseInt((String) textView2.getText());
                if(firstNumber > secondNumber){
                    score++;
                }else{
                    if(score != 0) score--; else score = 0;
                }
                result.setText("Result: " + score);
                changeNumber();
            }
        });

    }
    public void initView(){
        this.textView1 = findViewById(R.id.firstNumber);
        this.textView2 = findViewById(R.id.secondNumber);
        this.lessButton = findViewById(R.id.less);
        this.equalButton = findViewById(R.id.equal);
        this.biggerButton = findViewById(R.id.bigger);
        this.result = findViewById(R.id.result);
    }
    @SuppressLint("SetTextI18n")
    public void changeNumber(){
        Random random = new Random();
        int a = random.nextInt(10) + 1;
        int b = random.nextInt(10) + 1;
        System.out.println("Numbers are -> " + a + " " + b);
        textView1.setText(a + "");
        textView2.setText(b + "");
    }
}
