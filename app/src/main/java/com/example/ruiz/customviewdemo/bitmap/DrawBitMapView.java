package com.example.ruiz.customviewdemo.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.ruiz.customviewdemo.R;

public class DrawBitMapView extends View{

    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public DrawBitMapView(Context context) {
        super(context);
    }

    public DrawBitMapView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawBitMapView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
//        canvas.drawBitmap(bitmap,200,200,mPaint);


        canvas.drawBitmapMesh(bitmap,9,9,new float[]{1,2,3,4,5,6,7,8,9,0},0,new int[]{Color.RED,Color.RED,Color.RED,Color.RED,Color.RED,Color.RED,Color.RED,Color.RED,Color.RED,Color.RED},0,mPaint);
    }
}
