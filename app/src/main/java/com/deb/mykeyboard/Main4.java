package com.deb.mykeyboard;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bitvale.switcher.Switcher;
import com.bitvale.switcher.SwitcherC;
import com.shashank.sony.fancytoastlib.FancyToast;
import com.wooplr.spotlight.utils.SpotlightSequence;

public class Main4 extends AppCompatActivity {
    Switch sound;
    Switcher mSwitcher;
    TextView dev,own;
    Boolean volume;
    ImageButton info;
    private static final String INTRO_CARD = "fab_intro";
    private static final String INTRO_CARD1 = "fab";
    private static final String INTRO_CARD2 = "fintro";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
//    sound = findViewById(R.id.soundswitch);
        getWindow().setStatusBarColor(Color.parseColor("#7678A5"));
        getWindow().setNavigationBarColor(Color.parseColor("#7678A5"));
    dev = findViewById(R.id.dev);
    own = findViewById(R.id.own);
    mSwitcher = findViewById(R.id.switcher);
    info = findViewById(R.id.imageButton);
    info.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("market://details?id=" + getPackageName()));
            startActivity(i);
        }
    });
    dev.setOnClickListener(new View.OnClickListener() {
        @SuppressLint("IntentReset")
        @Override
        public void onClick(View v) {
            Intent send = new Intent(Intent.ACTION_SENDTO);
            String uriText = "mailto:" + Uri.encode("debarkhisonowal@gmail.com") +
                    "?subject=" + Uri.encode(" ") +
                    "&body=" + Uri.encode("");
            Uri uri = Uri.parse(uriText);
            send.setData(uri);
            startActivity(Intent.createChooser(send, "Send mail..."));
        }
    });
    own.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent send = new Intent(Intent.ACTION_SENDTO);
            String uriText = "mailto:" + Uri.encode("abhijitpadun@gmail.com") +
                    "?subject=" + Uri.encode(" ") +
                    "&body=" + Uri.encode("");
            Uri uri = Uri.parse(uriText);
            send.setData(uri);
            startActivity(Intent.createChooser(send, "Send mail..."));
        }
    });
    mSwitcher.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(mSwitcher.isChecked())
            {
                mSwitcher.setChecked(false,true);
//                Toast.makeText(Main4.this,"True",Toast.LENGTH_SHORT).show();
                SharedPreferences preferences = getSharedPreferences("prefs",MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.clear();
                editor.putBoolean("switch",mSwitcher.isChecked());
                Toast.makeText(Main4.this,mSwitcher.isChecked()+"1",Toast.LENGTH_SHORT).show();
                editor.commit();
                FancyToast.makeText(Main4.this,"Sound on",FancyToast.LENGTH_SHORT,FancyToast.SUCCESS,R.drawable.on,false).show();

            }else{
                mSwitcher.setChecked(true,true);
//                Toast.makeText(Main4.this,"False",Toast.LENGTH_SHORT).show();
                SharedPreferences preferences = getSharedPreferences("prefs",MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.clear();
                editor.putBoolean("switch",mSwitcher.isChecked());
                Toast.makeText(Main4.this,mSwitcher.isChecked()+"",Toast.LENGTH_SHORT).show();
                editor.commit();
                FancyToast.makeText(Main4.this,"Sound off",FancyToast.LENGTH_SHORT,FancyToast.WARNING,R.drawable.off,false).show();
            }
        }
    });
//    sound.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            saveSound();
//        }
//    });
        loadData();
        if (volume) {
            SpotlightSequence.getInstance(this,null)
                    .addSpotlight(findViewById(R.id.switcher),"Sound","This button changes the sound of keyboard",INTRO_CARD)
                    .addSpotlight(findViewById(R.id.dev),"Contact the developer","You can click here to and send mail to the developer",INTRO_CARD1)
                    .addSpotlight(findViewById(R.id.own),"Contact the owner","You can contact the owner by clicking here",INTRO_CARD2)
                    .startSequence();
            save();
        }


    }

    private void save() {
        SharedPreferences preferences1 = getSharedPreferences("share",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences1.edit();
        editor.putBoolean("first1",false);
        editor.commit();
    }

    private void saveSound() {
            SharedPreferences preferences = getSharedPreferences("prefs",MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.clear();
            editor.putBoolean("switch",sound.isChecked());
            Toast.makeText(this,sound.isChecked()+"",Toast.LENGTH_SHORT).show();
            editor.commit();

    }

    private void loadData() {
        SharedPreferences preferences =getSharedPreferences("prefs", Context.MODE_PRIVATE);
//        sound.setChecked(preferences.getBoolean("switch",true));
        mSwitcher.setChecked(preferences.getBoolean("switch",true),true);
        SharedPreferences preferences1 = getSharedPreferences("share",Context.MODE_PRIVATE);
        volume = preferences1.getBoolean("first1",true);

    }

}
