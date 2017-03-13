package com.dang.agi.appflashlight;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ImageButton ibtnFlashBulb,ibtnTraffic,ibtnFlash,ibtnNeon,ibtnWarring,ibtnPolice,ibtnWarring2,ibtnFlashScreen;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadControls();
        ibtnTraffic.setOnClickListener(this);
        ibtnFlashBulb.setOnClickListener(this);
        ibtnFlash.setOnClickListener(this);
        ibtnWarring.setOnClickListener(this);
        ibtnPolice.setOnClickListener(this);
        ibtnFlashScreen.setOnClickListener(this);
        ibtnWarring2.setOnClickListener(this);
        ibtnNeon.setOnClickListener(this);

    }

    private void loadControls() {
        ibtnFlashBulb = (ImageButton) findViewById(R.id.ibtnFlashBulb);
       ibtnTraffic = (ImageButton) findViewById(R.id.ibtnTraffic);
        ibtnFlash = (ImageButton) findViewById(R.id.ibtnFlashLight);
        ibtnNeon = (ImageButton) findViewById(R.id.ibtnNeon);
        ibtnPolice = (ImageButton) findViewById(R.id.ibtnPolice);
        ibtnWarring = (ImageButton) findViewById(R.id.ibtnwarring);
        ibtnWarring2 = (ImageButton) findViewById(R.id.ibtnwarring2);
        ibtnFlashScreen = (ImageButton) findViewById(R.id.ibtnFlashScreen);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ibtnFlashBulb:{
                Intent intent = new Intent(MainActivity.this,FlashBulb.class);
                startActivity(intent);
            }break;
            case R.id.ibtnTraffic:{
                Intent intent = new Intent(MainActivity.this,TrafficActivity.class);
                startActivity(intent);
            }break;
            case R.id.ibtnFlashLight:{
                Intent intent = new Intent(MainActivity.this,FlashLightActivity.class);
                startActivity(intent);
            }break;
            case R.id.ibtnPolice:{
                Intent intent = new Intent(MainActivity.this,PoliceActivity.class);
                startActivity(intent);
            }break;
            case R.id.ibtnwarring:{
                Intent intent = new Intent(MainActivity.this,WarringActivity.class);
                startActivity(intent);
            }break;
            case R.id.ibtnFlashScreen:{
                Intent intent = new Intent(MainActivity.this,ScreenLight.class);
                startActivity(intent);
            }break;
            case R.id.ibtnwarring2:{
                Intent intent = new Intent(MainActivity.this,Warring2.class);
                startActivity(intent);
            }break;
            case R.id.ibtnNeon:{
                Intent intent = new Intent(MainActivity.this,NeonActivity.class);
                startActivity(intent);
            }break;
            default:
                break;
        }
    }

    private void loadFlash() {
    }
}
