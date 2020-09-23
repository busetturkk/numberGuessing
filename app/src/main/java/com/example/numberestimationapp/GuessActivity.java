package com.example.numberestimationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class GuessActivity extends AppCompatActivity {

    private TextView textViewRemainingGuess,textViewHint;
    private Button buttonGuess;
    private EditText editTextInput;

    private int randomNumber;
    private int tmp=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess);

        textViewRemainingGuess=findViewById(R.id.textViewRemainingGuess);
        textViewHint=findViewById(R.id.textViewHint);
        editTextInput=findViewById(R.id.editTextTextInput);
        buttonGuess=findViewById(R.id.buttonGuess);

        Random random=new Random();
        randomNumber=random.nextInt(101);
        Log.e("Sonuç",String.valueOf(randomNumber));

        buttonGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tmp--;

                int guess = Integer.parseInt(editTextInput.getText().toString());

                if (Integer.parseInt(editTextInput.getText().toString()) < 0 || Integer.parseInt(editTextInput.getText().toString()) > 100) {
                    Toast.makeText(getApplicationContext(), "TAHMİNİNİZ 0 - 100 ARASINDA OLMALIDIR", Toast.LENGTH_SHORT).show();
                    editTextInput.setText("");
                }

               else if (editTextInput.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "LÜTFEN TAHMİNİNİZİ GİRİNİZ", Toast.LENGTH_SHORT).show();
                    editTextInput.setText("");
                }

                else{


                    if (guess == randomNumber) {
                        Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                        intent.putExtra("result", true);
                        startActivity(intent);
                        finish();
                        return;
                    }

                    else if (tmp == 0) {

                            textViewHint.setText("Hakkınız Kalmadı");
                            Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                            intent.putExtra("result", false);
                            startActivity(intent);
                            finish();
                            return;

                     }

                     else if (guess > randomNumber) {

                          textViewHint.setText("Azaltmanız Gerekli \n(Girilen sayı küçük)");
                          textViewRemainingGuess.setText("Kalan Hak : " + tmp);

                      }
                      else if (guess < randomNumber) {


                          textViewHint.setText("Arttırmanız Gerekli \n(Girilen sayı büyük)");
                          textViewRemainingGuess.setText("Kalan Hak : " + tmp);


                      }
                        editTextInput.setText("");
                    }
                }
            });
    }
}