package com.andid.yamuna.trainbustimedirecctory;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Dashboard extends AppCompatActivity {
private CardView add,edit,del;
Button Log;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        SharedPreferences sharedobj=getSharedPreferences("Login",MODE_PRIVATE);
        String user=sharedobj.getString("username",null);
        Toast.makeText(getApplicationContext(),user,Toast.LENGTH_SHORT).show();

        add=(CardView)findViewById(R.id.bankcardId);
        edit=(CardView)findViewById(R.id.cardv);
        del=(CardView)findViewById(R.id.dele);
        Log=(Button)findViewById(R.id.l);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),AdminAddData.class);
                startActivity(i);
            }
        });
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),AdminUpdate.class);
                startActivity(i);
            }
        });
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),AdminDelete.class);
                startActivity(i);
            }
        });
        Log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor ed=getSharedPreferences("Login",MODE_PRIVATE).edit();
                ed.clear();
                ed.commit();
                Intent i=new Intent(getApplicationContext(),AdminLogin.class);
                startActivity(i);
            }
        });
    }
}
