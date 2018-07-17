package com.example.ruiz.customviewdemo.xiaomisport;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.ruiz.customviewdemo.R;

public class MiSportAnimatorView extends View{



    private final int DEFAULTWIDTH = 400;
    private final int DEFAULTHEIGHT = 300;

    private Bitmap backGroundBitMap;

    Paint paint = new Paint();


    public MiSportAnimatorView(Context context) {
        this(context,null);
    }

    public MiSportAnimatorView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MiSportAnimatorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


        init();
    }

    private void init() {

        backGroundBitMap = BitmapFactory.decodeResource(getResources(), R.drawable.bg_step_law);

    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = initMeasureSpec(widthMeasureSpec,true);
        int height = initMeasureSpec(heightMeasureSpec,false);
        setMeasuredDimension(width,height);
    }

    private int initMeasureSpec(int spec,boolean isWidth){

        int measureMode = MeasureSpec.getMode(spec);
        int measureWidth = MeasureSpec.getSize(spec);

        int padding = isWidth? getPaddingLeft()+getPaddingRight() : getPaddingBottom()+getPaddingTop();

        if (measureMode == MeasureSpec.EXACTLY){
            return measureWidth;
        }else {
            int reSize = isWidth? DEFAULTWIDTH+padding : DEFAULTHEIGHT+padding;
            if (measureMode == MeasureSpec.UNSPECIFIED){
                return Math.min(reSize,measureWidth);
            }else {
                return reSize;
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawBitmap(backGroundBitMap,0,getMeasuredHeight()-backGroundBitMap.getHeight(),paint);


    }
}
