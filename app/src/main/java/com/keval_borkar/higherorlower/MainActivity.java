package com.keval_borkar.higherorlower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int randomNumber;
    public void makeToast(String string){
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }
    public void guess(View view){

        EditText guessedNumberText = (EditText) findViewById(R.id.numberEditText);
        String number = guessedNumberText.getText().toString();
        if(TextUtils.isEmpty(number)) {
            guessedNumberText.setError("You Should Enter a Number!!");
            return;
        }
        else {
            int guessNumber = Integer.parseInt(number);

            if (guessNumber > randomNumber) {

                makeToast("Its Lower!");
            } else if (guessNumber < randomNumber) {

                makeToast("Its Higher!");
            } else {
                makeToast("Thats Right! Try Again..");

                Random rand = new Random();
                randomNumber = rand.nextInt(50) + 1;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random rand = new Random();
        randomNumber = rand.nextInt(20) + 1;
    }
}
