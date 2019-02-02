package com.example.samueladams.towerdefense;


import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.annotation.TargetApi;
import android.graphics.Path;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.LinearInterpolator;
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

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import static com.example.samueladams.towerdefense.R.drawable.anim;
import static com.example.samueladams.towerdefense.R.drawable.map;

class start extends AppCompatActivity
{
    Button b3;
    private Handler mHandler;
    private int mInterval = 10000;
    int i = 0;
    ArrayList<ImageView> anims = new ArrayList<>();
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_layout);
        mHandler = new Handler();
        startRepeatingTask();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stopRepeatingTask();
    }

    private Runnable mStatusChecker = new Runnable() {
        @Override
        public void run() {
            try {
                moveit();
            } finally {
                mHandler.postDelayed(mStatusChecker, mInterval);
            }
        }
    };

    private void startRepeatingTask() {
        mStatusChecker.run();
    }

    private void stopRepeatingTask() {
        mHandler.removeCallbacks(mStatusChecker);
    }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void moveit() {
        final ImageView animImageView = (ImageView) findViewById(R.id.iv_animation);
        anims.add(animImageView);
        System.out.println("test;"+anims.size());
        anims.get(i).setBackgroundResource(R.drawable.anim);
        anims.get(i).post(new Runnable() {
            @Override
            public void run() {
                AnimationDrawable frameAnimation =
                        (AnimationDrawable) animImageView.getBackground();
                System.out.println(i);
                frameAnimation.start();
            }
        });
        float x = 0;
        float y = 0;
        Path path = new Path();

        path.moveTo(x + 750, y + 160);
        path.lineTo(x + 200, y + 160);
        path.lineTo(x + 200, y + 465);
        path.lineTo(x + 410, y + 465);
        path.lineTo(x + 410, y + 785);
        path.lineTo(x + 120, y + 785);
        path.lineTo(x + 120, y + 1200);

        ObjectAnimator objectAnimator =
                ObjectAnimator.ofFloat(anims.get(i), View.X,
                        View.Y, path);
        objectAnimator.setDuration(10000);
        objectAnimator.start();
        i++;
    }
}

