package com.dang.agi.appflashlight;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class PoliceActivity extends AppCompatActivity {
 ImageView img;
    String str;
    private CountDownTimer countDownTimer;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police);
        img = (ImageView) findViewById(R.id.imgPolice);
         str ="01010101010101";
         mediaPlayer = MediaPlayer.create(PoliceActivity.this,R.raw.alert_sound2);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
        countDownTimer = new CountDownTimer(100,100) {
            @Override
            public void onTick(long millisUntilFinished) {
                mediaPlayer.start();
            }

            @Override
            public void onFinish() {
                img.setImageLevel(2);
                CountDownTimer countDownTimer1 = new CountDownTimer(100,100) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        mediaPlayer.start();
                    }

                    @Override
                    public void onFinish() {
                        img.setImageLevel(1);
                        countDownTimer.start();
                    }
                }.start();
            }
        }.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.stop();
    }
}
