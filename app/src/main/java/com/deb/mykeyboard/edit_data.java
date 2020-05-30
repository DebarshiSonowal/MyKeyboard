package com.deb.mykeyboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.shashank.sony.fancytoastlib.FancyToast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class edit_data extends AppCompatActivity {
EditText title,data;
ImageButton saveeditbtn;
Integer id;
String tite,dat;
Cursor mCursor;
    SQLiteDatabase mDatabase;
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy h:mm a", Locale.getDefault());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_data);
        getWindow().setStatusBarColor(Color.parseColor("#7678A5"));
        getWindow().setNavigationBarColor(Color.parseColor("#7678A5"));
        id = Integer.parseInt(getIntent().getStringExtra("id"));
        DatabaseHelper mDatabaseHelper = new DatabaseHelper(this);
        mDatabase = mDatabaseHelper.getWritableDatabase();
        mCursor = getAllitems();
        title = findViewById(R.id.titleedittext);
        data = findViewById(R.id.dataedittext);
        saveeditbtn = findViewById(R.id.saveeditbtn);
        if (mCursor != null && mCursor.moveToFirst() ) {
            tite =  mCursor.getString(mCursor.getColumnIndex(Contract.NOTEPAD.COLUMN_NAME));
            dat =  mCursor.getString(mCursor.getColumnIndex(Contract.NOTEPAD.COLUMN_DATA));
        }
        title.setText(tite);
        title.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_DONE){
                    // Your action on done
                    return true;
                }
                return false;
            }
        });
        data.setText(dat);
        saveeditbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues cv =new ContentValues();
                cv.put(Contract.NOTEPAD.COLUMN_NAME,title.getText().toString());
                cv.put(Contract.NOTEPAD.COLUMN_DATA,data.getText().toString());
                cv.put(Contract.NOTEPAD.COLUMN_TIME,sdf.format(new Date()));
                mDatabase.update(Contract.NOTEPAD.TABLE_NAME,cv,Contract.NOTEPAD._ID+" =?", new String [] {String.valueOf(id)});
                FancyToast.makeText(edit_data.this,"Saved",FancyToast.LENGTH_SHORT,FancyToast.SUCCESS,R.drawable.ic_save,false).show();
                startActivity(new Intent(edit_data.this,MainActivity.class));
            }
        });
    }
    private Cursor getAllitems() {
        return mDatabase.rawQuery("SELECT * FROM "+Contract.NOTEPAD.TABLE_NAME+" WHERE "+id+" = "+Contract.NOTEPAD._ID+";",null);

    }
}
