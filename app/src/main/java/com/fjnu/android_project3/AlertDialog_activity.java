package com.fjnu.android_project3;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import androidx.appcompat.app.AppCompatActivity;

public class AlertDialog_activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle SaveInstanceState) {
        super.onCreate(SaveInstanceState);
        setContentView(R.layout.alertdialog_test);

        Button ad = findViewById(R.id.buttom);
        ad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                create_Alert_Dialog();
            }
        });
    }

    public void create_Alert_Dialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        LayoutInflater inflater = getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.alert_items, null))
                .setPositiveButton(R.string.Sign, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //LoginDialogFragment.this.getDialog().cancel();
                    }
                });


        builder.create();
        builder.show();
    }
}