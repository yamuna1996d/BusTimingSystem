package com.andid.yamuna.trainbustimedirecctory;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Display extends AppCompatActivity {
    EditText ed1,ed2,ed3,ed4,ed5;
    Button b;
    String code,getcode,getname,getroute,getstop;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        setContentView(R.layout.activity_display);
        ed1=(EditText)findViewById(R.id.c);
        ed2=(EditText)findViewById(R.id.na);
        ed3=(EditText)findViewById(R.id.ro);
        ed4=(EditText)findViewById(R.id.st);
        b=(Button)findViewById(R.id.upd);
        databaseHelper=new DatabaseHelper(this);
        databaseHelper.getWritableDatabase();
        SharedPreferences sharfed=getSharedPreferences("Login",MODE_PRIVATE);
        String user=sharfed.getString("code",null);
        String email=sharfed.getString("name",null);
        String mobile=sharfed.getString("route",null);
        String username=sharfed.getString("stop",null);
        ed1.setText(user);
        ed2.setText(email);
        ed3.setText(mobile);
        ed4.setText(username);
    }
}
