package com.example.ruiz.customviewdemo.scroller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.ruiz.customviewdemo.R;

public class ScrollLinearLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_linear_layout);
    }



    public void onClickRed(View view){
        Toast.makeText(this,"clcik Red",Toast.LENGTH_SHORT).show();
    }
    public void onClickGreen(View view){
        Toast.makeText(this,"clcik Green",Toast.LENGTH_SHORT).show();
    }
    public void onClickBlue(View view){
        Toast.makeText(this,"clcik Blue",Toast.LENGTH_SHORT).show();
    }
}
