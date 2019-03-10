package com.andid.yamuna.trainbustimedirecctory;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminUpdate extends AppCompatActivity {
EditText ed1;
Button b;
String code,getcode,getname,getroute,getstop;
DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_update);
        ed1=(EditText)findViewById(R.id.encode);
        b=(Button)findViewById(R.id.se);
        databaseHelper=new DatabaseHelper(this);
        databaseHelper.getWritableDatabase();

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                code = ed1.getText().toString();
                Cursor c = databaseHelper.Search(code);
                if (c.getCount() == 0) {
                    Toast.makeText(getApplicationContext(), "No data", Toast.LENGTH_SHORT).show();
                } else {
                    while (c.moveToNext()) {
                        getcode = c.getString(1);
                        getname = c.getString(2);
                        getroute = c.getString(3);
                        getstop = c.getString(4);
                        if (code.equals(getcode)) {
                            SharedPreferences.Editor obj = getSharedPreferences("Login", MODE_PRIVATE).edit();
                            obj.putString("code", getcode);
                            obj.putString("name", getname);
                            obj.putString("route", getroute);
                            obj.putString("stop", getstop);
                            obj.apply();

                            Intent i = new Intent(getApplicationContext(), Display.class);
                            startActivity(i);
                        } else {
                            Toast.makeText(getApplicationContext(), "Invalid", Toast.LENGTH_LONG).show();
                        }
                    }

                }
            }
        });
    }
    }
