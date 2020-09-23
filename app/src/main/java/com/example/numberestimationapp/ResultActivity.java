package com.example.numberestimationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.TestLooperManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private ImageView imageViewResult;
    private TextView textViewResult;
    private Button buttonAgain;

    private boolean result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        imageViewResult=findViewById(R.id.imageViewResult);
        textViewResult=findViewById(R.id.textViewResult);
        buttonAgain=findViewById(R.id.buttonAgain);

        result=getIntent().getBooleanExtra("result",true);
        if (result){
            imageViewResult.setImageResource(R.drawable.happy_image);
            textViewResult.setText("Tebrikler Kazandınız!");

        }
        else{
            imageViewResult.setImageResource(R.drawable.sad_image);
            textViewResult.setText("Maalesef Kaybettiniz!");

        }

        buttonAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),GuessActivity.class));
                finish();
            }
        });
    }
}