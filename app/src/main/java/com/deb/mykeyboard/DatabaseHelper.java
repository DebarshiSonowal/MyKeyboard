package com.deb.mykeyboard;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.deb.mykeyboard.Contract;
import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
  private static final String DATABASE_NAME="NOTEPAD";
    private static final Integer DATABASE_VERSION=1;
    public DatabaseHelper(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        final  String SQL_CREATE_NOTEPAD_TABLE = "CREATE TABLE " +
                Contract.NOTEPAD.TABLE_NAME + " (" +
                Contract.NOTEPAD._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Contract.NOTEPAD.COLUMN_NAME + " TEXT NOT NULL, " +
                Contract.NOTEPAD.COLUMN_DATA + "  TEXT NOT NULL, "+
                Contract.NOTEPAD.COLUMN_TIME + " TEXT NOT NULL" +
                ");";
        db.execSQL(SQL_CREATE_NOTEPAD_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ Contract.NOTEPAD.TABLE_NAME);
        onCreate(db);
    }
}
