package com.deb.mykeyboard;

import android.content.Context;

import android.content.Intent;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private  LayoutInflater mLayoutInflater;
private String name,date;
    private Cursor mCursor;
    long id;
    private Context mContext;

    public Adapter(Context context,Cursor cursor) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        mCursor = cursor;
    }
    public static class  ViewHolder extends RecyclerView.ViewHolder{
        TextView title,date;
        androidx.constraintlayout.widget.ConstraintLayout mConstraintLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titleview);
            date = itemView.findViewById(R.id.dateview);
            mConstraintLayout = itemView.findViewById(R.id.constr);
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = mLayoutInflater.inflate(R.layout.custom_view,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        if(!mCursor.moveToPosition(position)){
            return;
        }
        name = mCursor.getString(mCursor.getColumnIndex(Contract.NOTEPAD.COLUMN_NAME));
        date = mCursor.getString(mCursor.getColumnIndex(Contract.NOTEPAD.COLUMN_TIME));
       id = mCursor.getLong(mCursor.getColumnIndex(Contract.NOTEPAD._ID));
        holder.title.setText(name);
        holder.date.setText(date);
        holder.itemView.setTag(id);
        holder.mConstraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,edit_data.class);
                intent.putExtra("id",String.valueOf(id));
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mCursor.getCount();
    }

    public void swapCursor(Cursor newCursor){
        if(mCursor != null)
        {
            mCursor.close();
        }
        mCursor = newCursor;
        if(newCursor != null){
            notifyDataSetChanged();
        }
    }
}
