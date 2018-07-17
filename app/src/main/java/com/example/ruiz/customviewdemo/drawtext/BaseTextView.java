package com.example.ruiz.customviewdemo.drawtext;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class BaseTextView extends View{


    Paint mPaint;
    String text;

    int baseLineY;
    float lineSpacing;


    Paint.FontMetrics fontMetrics;

    public BaseTextView(Context context) {
        super(context);
    }

    public BaseTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        mPaint.setTextSize(132);

        mPaint.setUnderlineText(false);

        text = "A B C D e f g h";
        lineSpacing = mPaint.getFontSpacing();

        fontMetrics = mPaint.getFontMetrics();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        Rect textrect = new Rect();
        mPaint.getTextBounds(text,0,text.length(),textrect);
        textrect.top = textrect.top+40-(int)fontMetrics.top;
        textrect.bottom = textrect.bottom+40-(int)fontMetrics.top;
        textrect.left=textrect.left+30;
        textrect.right = textrect.right+30;

        mPaint.setColor(Color.parseColor("#3300ff00"));
        canvas.drawRect(textrect,mPaint);

        mPaint.setColor(Color.BLACK);
        canvas.drawText(text,30,40-fontMetrics.top,mPaint);





        mPaint.setColor(Color.RED);
        canvas.drawLine(0,40,1600,40,mPaint);//画top线

        canvas.drawLine(0,40-fontMetrics.top+fontMetrics.bottom,1600,40-fontMetrics.top+fontMetrics.bottom,mPaint);

        mPaint.setColor(Color.BLACK);
        canvas.drawLine(0,40-fontMetrics.top,1600,40-fontMetrics.top,mPaint);//基线

        mPaint.setColor(Color.YELLOW);
        canvas.drawLine(0,40-fontMetrics.top+fontMetrics.ascent,1600,40-fontMetrics.top+fontMetrics.ascent,mPaint);
        mPaint.setColor(Color.BLUE);
        canvas.drawLine(0,40-fontMetrics.top+fontMetrics.descent,1600,40-fontMetrics.top+fontMetrics.descent,mPaint);


    }
}
