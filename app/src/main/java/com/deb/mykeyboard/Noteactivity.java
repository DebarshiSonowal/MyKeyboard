package com.deb.mykeyboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;

public class Noteactivity extends AppCompatActivity {
SQLiteDatabase mDatabase;
RecyclerView mRecyclerView;
Adapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noteactivity);
        getWindow().setStatusBarColor(Color.parseColor("#E3E3E1"));
        getWindow().setNavigationBarColor(Color.parseColor("#ECECE1"));
DatabaseHelper databaseHelper = new DatabaseHelper(this);
mDatabase = databaseHelper.getWritableDatabase();
mRecyclerView = findViewById(R.id.recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
       mAdapter = new Adapter(this,getAllitems());
       mAdapter.notifyDataSetChanged();
       mRecyclerView.setAdapter(mAdapter);
       new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT) {
           @Override
           public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
               return false;
           }

           @Override
           public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                removeItem((long) viewHolder.itemView.getTag());
           }
       }).attachToRecyclerView(mRecyclerView);
    }

    private void removeItem(long tag) {
        mDatabase.delete(Contract.NOTEPAD.TABLE_NAME,
                Contract.NOTEPAD._ID+ "=" + tag,null);
        mAdapter.swapCursor(getAllitems());
        mAdapter.notifyDataSetChanged();
    }

    private Cursor getAllitems() {
        return mDatabase.query(
                Contract.NOTEPAD.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null);


    }
}
