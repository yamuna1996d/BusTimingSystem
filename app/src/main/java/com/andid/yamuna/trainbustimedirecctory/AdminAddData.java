package com.andid.yamuna.trainbustimedirecctory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminAddData extends AppCompatActivity {
EditText ed1,ed2,ed3,ed4;
Button sumbit;
String s1,s2,s3,s4;
DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_data);
        ed1=(EditText)findViewById(R.id.code);
        ed2=(EditText)findViewById(R.id.name);
        ed3=(EditText)findViewById(R.id.route);
        ed4=(EditText)findViewById(R.id.stop);
        sumbit=(Button)findViewById(R.id.sub);
        databaseHelper=new DatabaseHelper(this);
        databaseHelper.getWritableDatabase();
        sumbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1=ed1.getText().toString();
                s2=ed2.getText().toString();
                s3=ed3.getText().toString();
                s4=ed4.getText().toString();
                Toast.makeText(getApplicationContext(),s1,Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(),s2,Toast.LENGTH_LONG).show();
            }
        });

    }
}
