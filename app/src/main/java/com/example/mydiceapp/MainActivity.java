package com.example.mydiceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView diceImage1 = findViewById(R.id.imgdice1);           //creating reference of first ImageView
        final ImageView diceImage2 = findViewById(R.id.imgdice2);           //creating reference of second ImageView

        final int [] diceImages = {R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4, R.drawable.dice5, R.drawable.dice6};


        Button myButton = (Button)findViewById(R.id.myButton);              //creating reference of the ButtonView

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.dice_sound);      //for adding audio

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random rndObj = new Random();
                int rndImage = rndObj.nextInt(6);

                diceImage1.setImageResource(diceImages[rndImage]);          //for changing first ImageView randomly

                rndImage = rndObj.nextInt(6);

                diceImage2.setImageResource(diceImages[rndImage]);          //for changing second ImageView randomly

                YoYo.with(Techniques.Shake)                                 //for adding shake animation to first ImageView
                        .duration(500)
                        .repeat(0)
                        .playOn(findViewById(R.id.imgdice1));

                YoYo.with(Techniques.Shake)                                 //for adding shake animation to second ImageView
                        .duration(500)
                        .repeat(0)
                        .playOn(findViewById(R.id.imgdice2));

                mp.start();                                                 //for playing audio file

            }
        });
    }
}
