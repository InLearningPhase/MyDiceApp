package com.example.mydiceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView diceImage1 = findViewById(R.id.imgdice1);
        final ImageView diceImage2 = findViewById(R.id.imgdice2);

        final int [] diceImages = {R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4, R.drawable.dice5, R.drawable.dice6};


        Button myButton = (Button)findViewById(R.id.myButton);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random rndObj = new Random();
                int rndImage1 = rndObj.nextInt(6);
                int rndImage2 = rndObj.nextInt(6);

                diceImage1.setImageResource(diceImages[rndImage1]);
                diceImage2.setImageResource(diceImages[rndImage2]);

            }
        });
    }
}
