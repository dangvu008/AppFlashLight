package com.dang.agi.appflashlight;

import android.graphics.drawable.LevelListDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import java.util.Timer;
import java.util.TimerTask;

public class NeonActivity extends AppCompatActivity {
 Handler handler;
    int count = 0;
    Timer timer;
LinearLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neon);
        timer = new Timer();
        layout = (LinearLayout) findViewById(R.id.layout_neon);
        final LevelListDrawable levelListDrawable = (LevelListDrawable) layout.getBackground();
        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what==0){
                    if (count<=9){
                        levelListDrawable.setLevel(count);
                        count ++;
                    }else{
                        count= 0;
                        levelListDrawable.setLevel(count);
                    }
                }
            }
        };
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
              handler.sendEmptyMessage(0);
            }
        },200,200);
    }
}
