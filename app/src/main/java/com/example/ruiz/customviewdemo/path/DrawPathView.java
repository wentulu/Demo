package com.example.ruiz.customviewdemo.path;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class DrawPathView extends View{


    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public DrawPathView(Context context) {
        super(context);
    }

    public DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        mPaint.setStyle(Paint.Style.STROKE);

        Path path = new Path();
        path.moveTo(100,100);
        path.lineTo(100,200);
        path.rLineTo(100,0);

        path.moveTo(300,300);

        RectF rectF = new RectF(200,300,300,500);

        path.arcTo(rectF,90,180,true);

        canvas.drawPath(path,mPaint);


        mPaint.setColor(Color.RED);
        canvas.drawRect(rectF,mPaint);

    }
}
