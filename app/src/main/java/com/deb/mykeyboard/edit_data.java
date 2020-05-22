package com.deb.mykeyboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

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
        getWindow().setStatusBarColor(Color.parseColor("#E3E3E1"));
        getWindow().setNavigationBarColor(Color.parseColor("#E3E3E1"));
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
        data.setText(dat);
        saveeditbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues cv =new ContentValues();
                cv.put(Contract.NOTEPAD.COLUMN_NAME,title.getText().toString());
                cv.put(Contract.NOTEPAD.COLUMN_DATA,data.getText().toString());
                cv.put(Contract.NOTEPAD.COLUMN_TIME,sdf.format(new Date()));
                mDatabase.update(Contract.NOTEPAD.TABLE_NAME,cv,Contract.NOTEPAD._ID+" =?", new String [] {String.valueOf(id)});
            }
        });
    }
    private Cursor getAllitems() {
//        return mDatabase.query(
//                Contract.NOTEPAD.TABLE_NAME,
//                null,
//                Contract.NOTEPAD._ID+" =?",
//                new String [] {String.valueOf(id)},
//                null,
//                null,
//                null,
//                null
//        );
        return mDatabase.rawQuery("SELECT * FROM "+Contract.NOTEPAD.TABLE_NAME+" WHERE "+id+" = "+Contract.NOTEPAD._ID+";",null);

    }
}
