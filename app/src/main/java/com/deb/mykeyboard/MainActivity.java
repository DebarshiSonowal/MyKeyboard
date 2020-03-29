package com.deb.mykeyboard;

import android.graphics.Typeface;
import android.inputmethodservice.Keyboard;
import android.os.Bundle;
import android.util.Log;
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
        FontOverride.setDefaultFont(this, "DEFAULT","Fonts/nirmala.ttf");
    mTextView = findViewById(R.id.text2);
    mButton = findViewById(R.id.button2);
    mButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d("Text",mTextView.getText().toString());
        }
    });
        Typeface typeface = getResources().getFont(R.font.nirmala);
        mTextView.setTypeface(typeface);


    }

}
