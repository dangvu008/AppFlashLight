package com.dang.agi.appflashlight;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class Warring2 extends AppCompatActivity {
ImageView img;
    Timer timer;
    Handler handler;
    int i=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warring2);
        img= (ImageView) findViewById(R.id.imgWarring);
       /* countDownTimer = new CountDownTimer(300,300) {
            @Override
            public void onTick(long millisUntilFinished) {
                mediaPlayer.start();
            }

            @Override
            public void onFinish() {
                img.setImageLevel(2);
                CountDownTimer countDownTimer1 = new CountDownTimer(200,200) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                    }

                    @Override
                    public void onFinish() {
                        img.setImageLevel(1);
                        countDownTimer.start();
                    }
                }.start();
            }
        }.start();*/
         timer = new Timer();
        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what==0) {
                    if (i < 3) {
                      i++;
                        img.setImageLevel(i);
                    }else {
                        i=1;
                        img.setImageLevel(i);
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
