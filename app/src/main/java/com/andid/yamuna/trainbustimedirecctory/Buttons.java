package com.andid.yamuna.trainbustimedirecctory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Buttons extends AppCompatActivity {
Button ds,fd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buttons);
        ds=(Button)findViewById(R.id.adm);
        fd=(Button)findViewById(R.id.us);

        ds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent e=new Intent(getApplicationContext(),AdminLogin.class);
                startActivity(e);
            }
        });
        fd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent e=new Intent(getApplicationContext(),Recyclerview.class);
                startActivity(e);
            }
        });
    }
}
