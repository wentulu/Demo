package com.example.ruiz.customviewdemo.scroller;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.Scroller;

public class ScrollerLinearLayout extends LinearLayout {


    private final String TAG = ScrollerLinearLayout.class.getSimpleName();

    private float mLastX, mLastY;

    private Scroller scroller = new Scroller(getContext());

    public ScrollerLinearLayout(Context context) {
        this(context, null);
    }

    public ScrollerLinearLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ScrollerLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
//        super.onLayout(changed, l, t, r, b);
        for (int i = 0; i < getChildCount(); i++) {
            if (getOrientation() == HORIZONTAL) {
                int scrollX = getScrollX();
            } else {
                int scrollY = getScrollY();
                getChildAt(i).layout(0, scrollY + i * getMeasuredHeight(), getMeasuredWidth(), scrollY + getMeasuredHeight() * (i + 1));
            }
        }
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_MOVE) {
            return true;
        } else if (ev.getAction() == MotionEvent.ACTION_UP) {
            return false;
        } else {
            return false;
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX(),
                y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mLastX = x;
                mLastY = y;
                if (!scroller.isFinished()) {
                    scroller.abortAnimation();
                }
                return true;
            case MotionEvent.ACTION_MOVE:
                if (getOrientation() == HORIZONTAL) {
                    scrollBy(-(int) (x - mLastX), 0);
                } else {

                    scrollBy(0, -(int) (y - mLastY));
                }
                mLastX = x;
                mLastY = y;
                return true;
            case MotionEvent.ACTION_UP:
                if (getOrientation() == HORIZONTAL) {
                    smoothScroll((int) (event.getX() - mLastX), 0);
                } else {
                    smoothScroll(0, (int) Math.ceil(event.getY() - mLastY));
                }
                mLastX = x;
                mLastY = y;
                invalidate();
                return true;

        }


        return super.onTouchEvent(event);
    }


    private void smoothScroll(int distX, int distY) {

        int scrollX = getScrollX();
        int scrollY = getScrollY();
        if (getOrientation() == HORIZONTAL) {
            int delta = distX - scrollX;
            scroller.startScroll(scrollX, 0, distX, 0, 1000);
        } else {
            int delta = scrollY - distY;
            scroller.startScroll(0, scrollY, 0, -distY, 1000);
        }

    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if (scroller.computeScrollOffset()) {
            scrollTo(scroller.getCurrX(), scroller.getCurrY());
            postInvalidate();
        }
    }
}
