package com.example.ruiz.customviewdemo.gesturedetector;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

public class GestureDetectorView extends ViewGroup{

    private static final String TAG = GestureDetector.class.getSimpleName();


    GestureDetector mGestureDetector;

    public GestureDetectorView(Context context) {
        this(context,null);
    }

    public GestureDetectorView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public GestureDetectorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mGestureDetector = new GestureDetector(getContext(),simpleOnGestureListener);
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
         boolean consum = mGestureDetector.onTouchEvent(event);
         return true;
    }



    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

    /**
     * 双击时doubleTap只会调用一次
     * 而doubleTapEvent会会多次调用
     *
     * */
    GestureDetector.SimpleOnGestureListener simpleOnGestureListener = new GestureDetector.SimpleOnGestureListener(){

        @Override
        public boolean onContextClick(MotionEvent e) {
            return true;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            return true;
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            Log.e(TAG,"double tap"+e.getAction());
            return true;
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            Log.e(TAG,"Single Tap Confirmed"+e.getAction());
            return true;
        }

        @Override
        public boolean onDoubleTapEvent(MotionEvent e) {
            Log.e(TAG,"Double Tap Event"+e.getAction());
            return true;
        }

        @Override
        public void onLongPress(MotionEvent e) {
            super.onLongPress(e);
        }
    } ;

//    @Override
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//    }
//
//
//    @Override
//    public boolean onDown(MotionEvent e) {
//        Log.e(TAG,"DOWN");
//        return false;
//    }
//
//    @Override
//    public void onShowPress(MotionEvent e) {
//        Log.e(TAG,"showPress");
//    }
//
//    @Override
//    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
//        Log.e(TAG,"scroll");
//        return false;
//    }
//
//    @Override
//    public boolean onSingleTapUp(MotionEvent e) {
//        Log.e(TAG,"single tap up");
//        return false;
//    }
//
//
//    @Override
//    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
//        Log.e(TAG,"fling");
//        return false;
//    }
//
//
//    @Override
//    public void onLongPress(MotionEvent e) {
//        Log.e(TAG,"long press");
//    }
//
//    @Override
//    public boolean onSingleTapConfirmed(MotionEvent e) {
//        Log.e(TAG,"single tap confirmed");
//        return false;
//    }
//
//    @Override
//    public boolean onDoubleTap(MotionEvent e) {
//        Log.e(TAG,"double tap");
//        return false;
//    }
//
//    @Override
//    public boolean onDoubleTapEvent(MotionEvent e) {
//        Log.e(TAG,"double tap event");
//        return false;
//    }
}
