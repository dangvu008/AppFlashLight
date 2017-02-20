package com.dang.agi.appflashlight;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class WarringActivity extends AppCompatActivity {
    ImageView img;
    CountDownTimer countDownTimer;
    String str;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warring);
        img = (ImageView) findViewById(R.id.imgPolice1);
        str ="01010101010101";
        mediaPlayer = MediaPlayer.create(WarringActivity.this,R.raw.alert_sound2);
        countDownTimer = new CountDownTimer(300,300) {
            @Override
            public void onTick(long millisUntilFinished) {
                mediaPlayer.start();
            }

            @Override
            public void onFinish() {
                img.setImageLevel(2);
                CountDownTimer countDownTimer1 = new CountDownTimer(300,300) {
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
        }.start();
       /* Timer timer = new Timer();
        final Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what==0){
                    for (int i = 0; i < str.length(); i++) {
                        if (str.charAt(i)=='0'){
                           img.setImageLevel(1);
                        }else{
                         img.setImageLevel(2);
                        }
                    }
                }
            }
        };
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0);
            }
        },300,300);*/
      /*  handler.post(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i)=='0'){
                        img.setImageLevel(2);
                    }else{
                        img.setImageLevel(1);
                    }
                }
            }
        });*/
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
