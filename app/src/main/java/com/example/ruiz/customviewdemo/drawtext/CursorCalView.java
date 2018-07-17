package com.example.ruiz.customviewdemo.drawtext;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class CursorCalView extends View{


    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    String text = "Hello HenCoder \\uD83C\\uDDE8\\uD83C\\uDDF3";

    Paint.FontMetrics fontMetrics;

    float rowHeight;
    float baseLineHeight;

    public CursorCalView(Context context) {
        super(context);
    }

    public CursorCalView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CursorCalView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {

        mPaint.setTextSize(60);
        fontMetrics = mPaint.getFontMetrics();
        rowHeight = fontMetrics.bottom-fontMetrics.top;
        baseLineHeight = -fontMetrics.top;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        canvas.drawText(text,10,baseLineHeight,mPaint);

    }
}
