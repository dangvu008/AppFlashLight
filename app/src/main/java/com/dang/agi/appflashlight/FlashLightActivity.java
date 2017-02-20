package com.dang.agi.appflashlight;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class FlashLightActivity extends AppCompatActivity {
    ToggleButton toggleButton;
    Camera camera;
    String str;
    CameraManager camManager;
    String cameraId = null;
    CheckBox checkbox;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_light2);
        toggleButton = (ToggleButton) findViewById(R.id.toggleButtonFlashLight);
        checkbox = (CheckBox) findViewById(R.id.checkboxFlicker);
        if (getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)){
            toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    mediaPlayer = MediaPlayer.create(FlashLightActivity.this,R.raw.light_swich_3);
                        mediaPlayer.start();

                    if (isChecked){
                        if (checkbox.isChecked()) {
                             str = "010101010101";
                                for (int i = 0; i <str.length() ; i++) {
                                    if (str.charAt(i)=='1'){
                                        turnOn();
                                    }else{
                                        turnOff();
                                    }
                                }

                        }else{
                            turnOn();
                        }

                    }else{
                        str="";
                      turnOff();
                    }
                }
            });
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void turnOff() {
        if (Build.VERSION.SDK_INT>=23){
            try {
                camManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
                cameraId = camManager.getCameraIdList()[0];
                camManager.setTorchMode(cameraId,false);
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }
        }else{
            if (camera!=null){
                camera.release();
                camera.stopPreview();

            }
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mediaPlayer!=null)
            mediaPlayer.stop();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void turnOn(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            camManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
            // Usually front camera is at 0 position.
            try {
                cameraId = camManager.getCameraIdList()[0];
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }
            try {

                camManager.setTorchMode(cameraId, true);

            } catch (CameraAccessException e) {
                e.printStackTrace();
            }
        }else{
           if (camera!=null){
               camera = Camera.open();
               Camera.Parameters parameters = camera.getParameters();
               parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
               camera.setParameters(parameters);
               camera.startPreview();
           }
        }


    }
}
