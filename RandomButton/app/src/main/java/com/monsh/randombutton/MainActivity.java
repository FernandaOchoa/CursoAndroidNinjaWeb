package com.monsh.randombutton;

import android.graphics.Color;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button change;
    ConstraintLayout back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        change = (Button) findViewById(R.id.change);
        back = (ConstraintLayout)findViewById(R.id.back);
    }

    public void changeColor(View view){
        Random rand = new Random();

        //  back.setBackgroundColor(Color.CYAN);
        back.setBackgroundColor(Color.argb(255,rand.nextInt(256),rand.nextInt(256),rand.nextInt(256)));

    }
}
