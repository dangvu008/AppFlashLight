package com.dang.agi.appflashlight;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class TrafficActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textViewCount;
    CountDownTimer countDownTimer;
    int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traffic);
        imageView = (ImageView) findViewById(R.id.imgTraffic);
        textViewCount = (TextView) findViewById(R.id.textviewTimeCount);
         countDownTimer = new CountDownTimer(30000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                textViewCount.setText(String.valueOf(millisUntilFinished/1000));
            }

            @Override
            public void onFinish() {
                CountDownTimer countDownTimer1 = new CountDownTimer(2000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        textViewCount.setText("0");
                        imageView.setImageLevel(2);
                    }

                    @Override
                    public void onFinish() {
                        CountDownTimer countDownTimer2 = new CountDownTimer(30000,1000) {
                            @Override
                            public void onTick(long millisUntilFinished) {
                                imageView.setImageLevel(3);
                                textViewCount.setText(String.valueOf(millisUntilFinished/1000));
                            }

                            @Override
                            public void onFinish() {
                                imageView.setImageLevel(0);
                                countDownTimer.start();
                            }
                        }.start();
                    }
                }.start();
            }
        }.start();
    }
}
