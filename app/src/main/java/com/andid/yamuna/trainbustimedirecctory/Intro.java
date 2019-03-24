package com.andid.yamuna.trainbustimedirecctory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Intro extends AppCompatActivity {
private TextView tv;
private ImageView im;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        tv=(TextView)findViewById(R.id.te);
        im=(ImageView)findViewById(R.id.img);
        Animation animation=AnimationUtils.loadAnimation(this,R.anim.mytransition);
        tv.startAnimation(animation);
        im.startAnimation(animation);
        final Intent i=new Intent(getApplicationContext(),Buttons.class);

        Thread timer=new Thread(){
            public void run(){
                try{
                    sleep(5000);
                }
                catch (InterruptedException i){
                    i.printStackTrace();
                }
                finally {
                    startActivity(i);
                    finish();
                }
            }
        };
        timer.start();
    }
}
