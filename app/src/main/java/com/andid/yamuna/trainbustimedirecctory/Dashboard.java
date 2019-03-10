package com.andid.yamuna.trainbustimedirecctory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class Dashboard extends AppCompatActivity {
private CardView add,edit,del;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        add=(CardView)findViewById(R.id.bankcardId);
        edit=(CardView)findViewById(R.id.cardv);
        del=(CardView)findViewById(R.id.dele);
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
    }
}
