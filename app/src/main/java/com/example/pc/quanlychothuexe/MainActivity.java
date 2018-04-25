package com.example.pc.quanlychothuexe;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView moto = (ImageView)findViewById(R.id.imageView);
        moto.setImageResource(R.drawable.animation_run_moto);
        AnimationDrawable runningmoto = (AnimationDrawable)moto.getDrawable();
        runningmoto.start();

        // tạo thời gian chờ cho activity
        Thread myThread = new Thread(){
            @Override
            public void run() {
                try{
                    sleep(3000);
                    Intent intent = new Intent(getApplicationContext(), Login.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        myThread.start();
    }
}
