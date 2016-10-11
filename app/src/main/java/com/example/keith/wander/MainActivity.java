package com.example.keith.wander;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button theRabbit;
    Random randInt; // Random position
    Random randRot; // Random rotation
    int originalTop,originalLeft,originalBottom,originalRight;
    float x, y;
    Boolean firstTimeThrough;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        theRabbit = (Button) findViewById(R.id.theButton);
        theRabbit.setOnClickListener(this);
        x = theRabbit.getX();
        y = theRabbit.getY();
        firstTimeThrough = true;
        Log.i("info","onCreate: initial X:"+x);
        Log.i("info","onCreate: initial Y:"+y);

        randInt = new Random();
        randRot = new Random();
    } // End onCreate

    @Override
    public void onClick(View view) {
        float newRotation;
        int newVertical, newHorizontal;
        int top, left, bottom, right;

        if(firstTimeThrough){
            x = theRabbit.getX();
            y = theRabbit.getY();
            firstTimeThrough = false;
            Log.i("info","onClick: initial X:"+x);
            Log.i("info","onClick: initial Y:"+y);
        }

        newRotation = randRot.nextFloat()*(float)(360*4);
        newVertical =   ( randInt.nextInt(100) -50 ) * 4;
        newHorizontal = ( randInt.nextInt(100) -50 ) * 4;

        theRabbit.setRotation(newRotation);
        theRabbit.setX(x+(float) newHorizontal);
        theRabbit.setY(y+(float) newVertical);

    } // End onClick
} // End MainActivity
