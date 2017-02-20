package com.dang.agi.appflashlight;

import android.graphics.drawable.LevelListDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class ScreenLight extends AppCompatActivity {
    TextView textView;
    Timer timer;
    Handler handler;
    int count = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_light);
        textView = (TextView) findViewById(R.id.textviewScreen);
        timer = new Timer();
        final LevelListDrawable level = (LevelListDrawable) textView.getBackground();
        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what==0){
                    if (count<5){
                        count++;
                        level.setLevel(count);
                    }else{
                        count =1;
                        level.setLevel(count);
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
