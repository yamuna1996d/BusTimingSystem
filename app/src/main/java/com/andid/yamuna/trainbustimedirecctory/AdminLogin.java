package com.andid.yamuna.trainbustimedirecctory;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLogin extends AppCompatActivity {

    EditText ed1,ed2;
    Button b;
    String s1,s2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        SharedPreferences sharedPreferences=getSharedPreferences("Login",MODE_PRIVATE);
        String check=sharedPreferences.getString("username",null);
        if(check!=null){
            Intent i=new Intent(getApplicationContext(),Dashboard.class);
            startActivity(i);
        }
        ed1=(EditText)findViewById(R.id.user);
        ed2=(EditText)findViewById(R.id.pass);
        b=(Button)findViewById(R.id.login);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1=ed1.getText().toString();
                s2=ed2.getText().toString();
                if (s1.equals("admin")&&s2.equals("admin"))
                {
                    SharedPreferences.Editor obj=getSharedPreferences("login",MODE_PRIVATE).edit();
                    obj.putString("username",s1);
                    obj.apply();
                    Intent i=new Intent(getApplicationContext(),Dashboard.class);
                    startActivity(i);

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Invalid username or password",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
