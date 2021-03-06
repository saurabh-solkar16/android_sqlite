package com.example.shradha.app_sqlite;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {
    Databasehelper db;
    EditText editText3, editText4, editText5;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new Databasehelper(this);
        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);
        editText5 = findViewById(R.id.editText5);

    }

    public void insert(View v) {

        if (db.insertBata(editText3.getText().toString(), editText4.getText().toString(), editText5.getText().toString()) == true) {
            Toast.makeText(getApplication().getBaseContext(), "success", Toast.LENGTH_LONG).show();
        } else {

            Toast.makeText(getApplication().getBaseContext(), "fail to insert", Toast.LENGTH_LONG).show();
        }
    }

    public void view(View v) {
        StringBuffer sb = new StringBuffer();
        Cursor c = db.viewd();
        while (c.moveToNext()) {
            sb.append("id  " + c.getString(0) + "\n");
            sb.append("name  " + c.getString(1) + "\n");
            sb.append("surname  " + c.getString(2) + "\n");
            sb.append("marks  " + c.getString(3) + "\n\n");
        //    Toast.makeText(getApplicationContext(), sb, Toast.LENGTH_LONG).show();
        }
showmessage("data",sb.toString());

    }

    public void showmessage(String title,String message){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
