package com.example.ruiz.customviewdemo.annotation;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.ruiz.customviewdemo.R;

public class AnnotationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_annotation);
        setLayout(R.layout.activity_annotation);
        setText(R.string.app_name);
    }


    @NonNull
    private View setLayout(@LayoutRes int layoutId){
        View view = getLayoutInflater().inflate(layoutId,null);
        return view;
    }

    private void setText(@StringRes int stringId){

    }

}
