package com.example.ruiz.customviewdemo.scroller;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Scroller;

public class ScrollerLinearLayout extends ViewGroup {


    private final String TAG = ScrollerLinearLayout.class.getSimpleName();

    private float mLastX, mLastY;

    private float mLastInterceptX, mLastInterceptY;

    private Scroller scroller = new Scroller(getContext());

    private int contentHeight = 0, height;

    private VelocityTracker velocityTracker = VelocityTracker.obtain();


    int touchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();

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

            int scrollY = getScrollY();
            getChildAt(i).layout(0, scrollY + i * getMeasuredHeight(), getMeasuredWidth(), scrollY + getMeasuredHeight() * (i + 1));

        }
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        contentHeight = getMeasuredHeight() * 3;
        height = getMeasuredHeight();
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {

        float x = ev.getX();
        float y = ev.getY();

        boolean intercepted = false;

        switch (ev.getAction()) {

            case MotionEvent.ACTION_DOWN:

                intercepted = false;
                break;

            case MotionEvent.ACTION_MOVE:
                if (Math.abs(y - mLastInterceptY) > touchSlop) {
                    intercepted = true;
                } else {
                    intercepted = false;
                }

                break;

            case MotionEvent.ACTION_UP:
                intercepted = false;
                break;
        }

        mLastX = x;
        mLastY = y;
        mLastInterceptX = x;
        mLastInterceptY = y;

        return intercepted;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX(),
                y = event.getY();
        int scrollY;
        velocityTracker.addMovement(event);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (!scroller.isFinished()) {
                    scroller.abortAnimation();
                }
                mLastX = x;
                mLastY = y;
                return true;
            case MotionEvent.ACTION_MOVE:

                scrollY = getScrollY();
                Log.e(TAG, "scrollY=" + scrollY);
                float distX = mLastY - y;
                Log.e(TAG, "distY=" + distX);
                if (Math.abs(distX) > touchSlop) {
                    if (distX > 0) {
                        if (scrollY + distX >= contentHeight - height) {
//                            distX = contentHeight - height - scrollY;
                        }
                        scrollBy(0, (int) distX);
                    } else {
                        if (scrollY < Math.abs(distX)) {
//                            distX = -scrollY;
                        }
                        scrollBy(0, (int) distX);
                    }
                }
                mLastX = x;
                mLastY = y;

                return true;
            case MotionEvent.ACTION_UP:
                scrollY = getScrollY();
                if (scrollY < 0) {
                    smoothScroll(0, scrollY);
                } else if (scrollY > height * 2) {
                    smoothScroll(0, scrollY - height * 2);
                }
                mLastX = x;
                mLastY = y;
                return true;
        }
        mLastX = x;
        mLastY = y;
        return true;

    }


    private void smoothScroll(int distX, int distY) {
        int scrollY = getScrollY();
        scroller.startScroll(0, scrollY, 0, -distY, 200);
        invalidate();
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
