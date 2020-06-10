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

        addSlide(AppIntroFragment.newInstance("Welcome to গড়গঞা অসমীয়া Typing app","This is a typing app with a custom Assamese font keyboard that enables you to write in Assamese in android phones",R.mipmap.intro, Color.parseColor("#252525")));
        addSlide(AppIntroFragment.newInstance("Permission","To use this keyboard click on the permission button on the home screen",R.drawable.ic_document, Color.parseColor("#252525")));
        addSlide(AppIntroFragment.newInstance("Select the keyboard","To use this keyboard click on the keyboard icon on lower right corner and select this keyboard or long press on spacebar and select this keyboard",R.drawable.screenshot1, Color.parseColor("#252525")));
        addSlide(AppIntroFragment.newInstance("Switch the keyboard","At this moment we only support assamese. To change keyboard longpress ্ and then select the settings icon",R.drawable.screenshot3, Color.parseColor("#252525")));
        addSlide(AppIntroFragment.newInstance("To write conjuction letters","To write conjuction letter use ্ between letters",R.drawable.instruction, Color.parseColor("#252525")));
        addSlide(AppIntroFragment.newInstance("Shortcut conjuction letter","To use pre defined conjuction letters long press on letters",R.drawable.screenshot, Color.parseColor("#252525")));
        setColorTransitionsEnabled(true);
    }

    @Override
    protected void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
