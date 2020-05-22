package com.deb.mykeyboard;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity  {
TextView mTextView;
    ProgressBar splashProgress;
    int SPLASH_TIME = 3000; //This is 3 seconds
    Boolean serv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mTextView=findViewById(R.id.textView4);
        loadData();
        getWindow().setStatusBarColor(Color.parseColor("#cc2b5e"));
        getWindow().setNavigationBarColor(Color.parseColor("#753a88"));
        splashProgress = findViewById(R.id.splashProgress);
        splashProgress.getIndeterminateDrawable().setColorFilter(Color.parseColor("#FFFFFF"), android.graphics.PorterDuff.Mode.MULTIPLY);
        playProgress();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if(serv)
                {
                    setPref();
                    Intent mySuperIntent = new Intent(Main2Activity.this, Main3Activity.class);
                    startActivity(mySuperIntent);
                }else {
//                    Intent mySuperIntent = new Intent(Main2Activity.this, MainActivity.class);
                    Intent mySuperIntent = new Intent(Main2Activity.this, MainActivity.class);
                    startActivity(mySuperIntent);
                }

                finish();
        }
    },SPLASH_TIME);
    }

    private void setPref() {
        SharedPreferences preferences = getSharedPreferences("prefs",MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("firstStart",false);
        editor.apply();
    }

    private void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences("prefs", Context.MODE_PRIVATE);
        serv = sharedPreferences.getBoolean("firstStart",true);
    }

    private void playProgress() {
        ObjectAnimator.ofInt(splashProgress, "progress", 100)
                .setDuration(5000)
                .start();
    }

}
