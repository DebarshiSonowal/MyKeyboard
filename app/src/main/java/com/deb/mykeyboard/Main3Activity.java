package com.deb.mykeyboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.github.appintro.AppIntro2;
import com.github.appintro.AppIntroFragment;

public class Main3Activity extends AppIntro2 {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addSlide(AppIntroFragment.newInstance("Welcome","This is a keyboard that enables you to write in Assamese in android phones",R.drawable.document, Color.parseColor("#252525")));
        setColorTransitionsEnabled(true);
    }

    @Override
    protected void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
