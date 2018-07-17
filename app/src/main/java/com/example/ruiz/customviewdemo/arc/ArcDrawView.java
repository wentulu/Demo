package com.example.ruiz.customviewdemo.arc;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.Map;

public class ArcDrawView extends View{



    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public ArcDrawView(Context context) {
        super(context);
    }

    public ArcDrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ArcDrawView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setStyle(Paint.Style.STROKE);

        canvas.drawRect(100,200,300,400,mPaint);


        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawArc(100,200,300,400,0,-90,false, mPaint);

    }
}
