package com.andid.yamuna.trainbustimedirecctory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Recyclerview extends AppCompatActivity{
private RecyclerView recyclerview;
private ExampleAdapter adapter;
private Button ade;
private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        ade=(Button)findViewById(R.id.ad);
        ArrayList<exampleitem>arrayList=new ArrayList<>();
        arrayList.add(new exampleitem(R.drawable.ic_directions_bus_black_24dp,"Location"));
        arrayList.add(new exampleitem(R.drawable.ic_directions_bus_black_24dp,"Location1"));
        arrayList.add(new exampleitem(R.drawable.ic_directions_bus_black_24dp,"Location2"));

        recyclerview = (RecyclerView) findViewById(R.id.recycler);
        recyclerview.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        adapter= new ExampleAdapter(arrayList);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setAdapter(adapter);

        adapter.setOnClickListener(new ExampleAdapter.onitemclickListener() {
            @Override
            public void onitemclick(int i) {
                Intent r=new Intent(getApplicationContext(),AdminUpdate.class);
                startActivity(r);
            }
        });
        ade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent r=new Intent(getApplicationContext(),AdminAddData.class);
                startActivity(r);
            }
        });
    }
}
