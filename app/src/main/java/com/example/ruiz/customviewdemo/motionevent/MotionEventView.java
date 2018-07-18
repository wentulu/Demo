package com.example.ruiz.customviewdemo.motionevent;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;

public class MotionEventView extends View {

    private final String TAG = MotionEventView.class.getSimpleName();


    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Path mPath = new Path();

    private int touchSlop;//判定为滑动的最小距离
    private VelocityTracker mVelocity;//滑动速度计算

    public MotionEventView(Context context) {
        super(context);
    }

    public MotionEventView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MotionEventView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        mPaint.setStyle(Paint.Style.STROKE);
        touchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();

        mVelocity = VelocityTracker.obtain();
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG,"Down ("+event.getX()+","+event.getY()+")");
                mPath.reset();
                mPath.moveTo(event.getX(),event.getY());
                break;

            case MotionEvent.ACTION_MOVE:
                Log.e(TAG,"Move ("+event.getX()+","+event.getY()+")");
                mPath.lineTo(event.getX(),event.getY());
                mVelocity.addMovement(event);
                break;

            case MotionEvent.ACTION_UP:
                Log.e(TAG,"Up ("+event.getX()+","+event.getY()+")");

                break;
        }
        invalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mVelocity.computeCurrentVelocity(200);
        Log.e(TAG,"X velocity is"+mVelocity.getXVelocity());
        Log.e(TAG,"Y Velocity is"+mVelocity.getYVelocity());

        canvas.drawPath(mPath,mPaint);
        Log.e(TAG,"Touch Slop"+touchSlop);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mVelocity.clear();
        mVelocity.recycle();
    }
}
