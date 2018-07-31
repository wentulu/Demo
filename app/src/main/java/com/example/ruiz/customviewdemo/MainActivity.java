package com.example.ruiz.customviewdemo;

import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.ruiz.customviewdemo.gesturedetector.GestureDetectorActivity;
import com.example.ruiz.customviewdemo.gesturedetector.GestureDetectorView;
import com.example.ruiz.customviewdemo.motionevent.MotionEventActivity;
import com.example.ruiz.customviewdemo.scroller.ScrollLinearLayoutActivity;
import com.example.ruiz.customviewdemo.view.ViewPositionActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void goPositionView(View view){
        Intent intent = new Intent(this, ViewPositionActivity.class);
        startActivity(intent);
    }


    public void goMotionEvent(View view){
        Intent intent = new Intent(this, MotionEventActivity.class);
        startActivity(intent);
    }


    public void goGestureDetector(View view){
        Intent intent = new Intent(this, GestureDetectorActivity.class);
        startActivity(intent);
    }


    public void goScrollLinearLayout(View view){
        Intent intent = new Intent(this, ScrollLinearLayoutActivity.class);
        startActivity(intent);
    }

    public void installUnknowm(View view){
        Intent intent = new Intent(Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES, Uri.parse("package:"+getPackageName()));
        startActivity(intent);
    }

}
