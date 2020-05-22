package com.deb.mykeyboard;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import com.wooplr.spotlight.utils.SpotlightSequence;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class MainActivity extends AppCompatActivity implements dialogpopup.DialogListener{
    EditText mEditText;

    ImageButton mButton,Setting,savebtn,copy,list;
    private static final String FIRST = "permission";
    private static final String SECOND = "settings";
    private static final String THIRD = "try";
    private static final String FOURTH = "tradad";
    private static final String FIFTH = "tragagaga";
    private static final String SIXTH = "tr14314adad";
    TextView mTextView;
    String title;
    SQLiteDatabase mDatabase;

    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy h:mm a", Locale.getDefault());
    Boolean start;
    int i1;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onStart() {
        super.onStart();
//        spotlight.start();
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadData();
        getWindow().setStatusBarColor(Color.parseColor("#DBDFEA"));
        getWindow().setNavigationBarColor(Color.parseColor("#DBDFEA"));
        DatabaseHelper mDatabaseHelper = new DatabaseHelper(this);
        mDatabase = mDatabaseHelper.getWritableDatabase();
    mEditText = findViewById(R.id.text2);
    mTextView = findViewById(R.id.textView2);
    Setting = findViewById(R.id.Setting);
    copy = findViewById(R.id.cpybtn);
    savebtn = findViewById(R.id.savebtn);
    list = findViewById(R.id.listbtn);
    list.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this,Noteactivity.class);
            startActivity(intent);
        }
    });
    copy.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ClipboardManager manager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
            ClipData clipData = ClipData.newPlainText("practice",mEditText.getText());
            manager.setPrimaryClip(clipData);
        }
    });
    Setting.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, Main4.class);
            startActivity(intent);
        }
    });
    savebtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            openDialog();

        }
    });
        Typeface typeface = ResourcesCompat.getFont(this,R.font.font1);
        mEditText.setTypeface(typeface);
        mTextView.setTypeface(typeface);
    mButton = findViewById(R.id.button2);
        if (start) {
            SpotlightSequence.getInstance(this,null)
                    .addSpotlight(findViewById(R.id.button2),"Enable Permission","Click here and select this keyboard",FIRST)
                    .addSpotlight(findViewById(R.id.Setting),"Settings","Click here to check settings",SECOND)
                    .addSpotlight(findViewById(R.id.text2),"Try","You can try our font here",THIRD)
                    .addSpotlight(findViewById(R.id.cpybtn),"Copy","Click here to copy the text",FOURTH)
                    .addSpotlight(findViewById(R.id.listbtn),"List of notes","Go to the list of previously saved notes",FIFTH)
                    .startSequence();
            save();
        }
        mButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Settings.ACTION_INPUT_METHOD_SETTINGS);
            startActivity(intent);
        }
    });


//    if(checkSelfPermission(Manifest.permission.BIND_INPUT_METHOD) == PackageManager.PERMISSION_GRANTED){
//
//    }else{
//        Intent intent = new Intent(Settings.ACTION_INPUT_METHOD_SETTINGS);
//        startActivityForResult(intent,0);
//    }
//
//    }

}

    private void openDialog() {
        dialogpopup dialogpopup = new dialogpopup();
        dialogpopup.show(getSupportFragmentManager(),"Example Dialog");
    }

    private void save() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.putBoolean("first",false);
        editor.commit();
    }

    private void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared", Context.MODE_PRIVATE);
        start = sharedPreferences.getBoolean("first",true);
    }

    @Override
    public void applyText(String name) {
        title = name;
        ContentValues cv = new ContentValues();
        cv.put(Contract.NOTEPAD.COLUMN_NAME,title);
        cv.put(Contract.NOTEPAD.COLUMN_DATA,mEditText.getText().toString());
        cv.put(Contract.NOTEPAD.COLUMN_TIME,sdf.format(new Date()));
        mDatabase.insert(Contract.NOTEPAD.TABLE_NAME,null,cv);
        mEditText.setText("");
    }
}

