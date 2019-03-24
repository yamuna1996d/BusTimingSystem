package com.andid.yamuna.trainbustimedirecctory;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminDelete extends AppCompatActivity {
Button b;
EditText ed1;
String getBus;
DatabaseHelper adapter;
AlertDialog.Builder al;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_delete);
        ed1=(EditText)findViewById(R.id.c);
        getBus=ed1.getText().toString();
        b=(Button)findViewById(R.id.d);
        al = new AlertDialog.Builder(this);
        al.setTitle("Confirm");
        al.setMessage("Are u sure");
        al.setPositiveButton("Yes" ,new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                boolean status=adapter.busDelete(getBus);
                if(status==true) {
                    Toast.makeText(getApplicationContext(), "Deleted", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Error in deletion", Toast.LENGTH_SHORT).show();
                }
                dialog.dismiss();
            }
        });
        al.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "No", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog alertDialog=al.create();
                alertDialog.show();
                Boolean cu=adapter.busDelete(getBus);
                if (cu==true){
                    Toast.makeText(getApplicationContext(),"Deleted",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
