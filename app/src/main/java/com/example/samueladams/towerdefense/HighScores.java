package com.example.samueladams.towerdefense;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.content.Intent;
import android.widget.Button;


public class HighScores extends AppCompatActivity
{
    Button b2;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_scores);
        //set up full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}

