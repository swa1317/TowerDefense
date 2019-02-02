package com.example.samueladams.towerdefense;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.content.Intent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class launch extends AppCompatActivity
{
    Button b3;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_layout);
        //set up full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        b3=(Button)findViewById(R.id.button);
        b3.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                start(view);
            }
        });
    }
    public void start(View view)
    {
        Intent intent = new Intent(this, start.class);
        startActivity(intent);
    }


}

