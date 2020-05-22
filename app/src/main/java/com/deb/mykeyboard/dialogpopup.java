package com.deb.mykeyboard;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.google.android.material.textfield.TextInputEditText;

public class dialogpopup extends AppCompatDialogFragment {
private TextInputEditText title;
DialogListener mDialogListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            mDialogListener = (DialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()+"must implement Dialoglistener");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(),AlertDialog.THEME_HOLO_LIGHT);
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_view, null);
        title = view.findViewById(R.id.titlename);
        builder.setView(view)
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String name = title.getText().toString();
                        mDialogListener.applyText(name);
                    }
                });

        return builder.create();
    }
    public  interface  DialogListener{
        void applyText(String name);
    }
}
