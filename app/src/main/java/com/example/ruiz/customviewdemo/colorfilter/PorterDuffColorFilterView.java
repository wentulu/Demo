package com.example.ruiz.customviewdemo.colorfilter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.ruiz.customviewdemo.R;

public class PorterDuffColorFilterView extends View{


    Bitmap bitmap;

    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    LightingColorFilter lightingColorFilter = new LightingColorFilter(0x00ffff,0x000000);

    PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(Color.WHITE, PorterDuff.Mode.DARKEN);//搞不清楚

    public PorterDuffColorFilterView(Context context) {
        super(context);
    }

    public PorterDuffColorFilterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PorterDuffColorFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.batman);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setColorFilter(porterDuffColorFilter);

        canvas.drawBitmap(bitmap,0,0,mPaint);

    }
}
