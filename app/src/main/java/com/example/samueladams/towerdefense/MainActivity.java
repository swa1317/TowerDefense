package com.example.samueladams.towerdefense;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.*;
import android.content.Intent;



import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity
{
    Button b1;
    Button b2;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        //set up full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.button1);
        b2=(Button)findViewById(R.id.button2);
        b1.setOnClickListener(new OnClickListener()
        {
            public void onClick(View view)
            {
                launch(view);
            }
        });
        b2.setOnClickListener(new OnClickListener()
        {
            public void onClick(View view)
            {
                HighScores(view);
            }
        });
    }

    public void launch(View view)
    {
        Intent intent = new Intent(this, launch.class);
        startActivity(intent);
    }
    public void HighScores(View view)
    {
        Intent intent = new Intent(this, HighScores.class);
        startActivity(intent);
    }
}
