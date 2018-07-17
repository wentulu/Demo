package com.example.ruiz.customviewdemo.shader;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class ShaderView extends View{

    Paint mPaint = new Paint();

    public ShaderView(Context context) {
        super(context);
    }

    public ShaderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ShaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        LinearGradient linearGradient = new LinearGradient(300,300,500,500, Color.RED,Color.BLUE, Shader.TileMode.CLAMP);
//        mPaint.setShader(linearGradient);

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(10);

//        RadialGradient radialGradient = new RadialGradient(400,500,400,Color.BLUE,Color.BLACK, Shader.TileMode.CLAMP);
//        mPaint.setShader(radialGradient);

        SweepGradient sweepGradient = new SweepGradient(400,400,new int[]{Color.RED,Color.YELLOW,Color.BLUE,Color.BLACK},new float[]{0.25f,0.5f,0.75f,1f});
        mPaint.setShader(sweepGradient);


        canvas.drawCircle(400,400,400,mPaint);

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(20);
        canvas.drawPoint(400,400,mPaint);
    }
}
