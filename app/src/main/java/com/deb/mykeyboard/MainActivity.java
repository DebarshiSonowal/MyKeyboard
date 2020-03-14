package com.deb.mykeyboard;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    TextView mTextView;
    Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FontOverride mFontsOverride = null;
        mFontsOverride.setDefaultFont(this, "DEFAULT","Fonts/GARHGAYA_WORK.TTF");
    mTextView = findViewById(R.id.text2);
    mButton = findViewById(R.id.button2);
    mButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setContentView(R.layout.settings);
        }
    });
    }

}
