package com.example.ruiz.customviewdemo.scrollconflict;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

public class HorizontalScrollViewEx extends ViewGroup{

    public HorizontalScrollViewEx(Context context) {
        super(context);
    }

    public HorizontalScrollViewEx(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HorizontalScrollViewEx(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }
}
