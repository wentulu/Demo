package com.example.ruiz.customviewdemo.flipped;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

import com.example.ruiz.customviewdemo.R;

public class MapView extends View {


    int degreeY;
    int degreeZ;
    int fixDegreeY;

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    Bitmap bitmap;
    Camera camera;

    int centerX;
    int centerY;
    Point point = new Point();

    AnimatorSet animationSet = new AnimatorSet();
    ObjectAnimator animator1 = ObjectAnimator.ofInt(this,"degreeY",0,-45);
    ObjectAnimator animatior2 = ObjectAnimator.ofInt(this,"degreeZ",0,270);
    ObjectAnimator animator3 = ObjectAnimator.ofInt(this,"fixDegreeY",0,30);

    public MapView(Context context) {
        super(context);
    }

    public MapView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MapView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.google_map);
        camera = new Camera();

        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        camera.setLocation(0, 0, -displayMetrics.density*6);

        animator1.setDuration(1000);
        animator1.setStartDelay(500);

        animatior2.setDuration(800);
        animator1.setStartDelay(500);

        animator3.setDuration(500);
        animator3.setStartDelay(500);


        animationSet.playSequentially(animator1,animatior2,animator3);
        animationSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        animationSet.start();
                        degreeY=0;
                        degreeZ=0;
                        fixDegreeY=0;
                    }
                },500);

            }
        });

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int bitmapWidth = bitmap.getWidth();
        int bitmapHeight = bitmap.getHeight();
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int x = centerX - bitmapWidth / 2;
        int y = centerY - bitmapHeight / 2;

        //画变换的一半
        //先旋转，再裁切，再使用camera执行3D动效,**然后保存camera效果**,最后再旋转回来
        canvas.save();
        camera.save();
        canvas.translate(centerX, centerY);
        canvas.rotate(-degreeZ);
        camera.rotateY(degreeY);
        camera.applyToCanvas(canvas);
        //计算裁切参数时清注意，此时的canvas的坐标系已经移动
        canvas.clipRect(0, -centerY, centerX, centerY);
        canvas.rotate(degreeZ);
        canvas.translate(-centerX, -centerY);
        camera.restore();
        canvas.drawBitmap(bitmap, x, y, paint);
        canvas.restore();

        //画不变换的另一半
        canvas.save();
        camera.save();
        canvas.translate(centerX, centerY);
        canvas.rotate(-degreeZ);
        //计算裁切参数时清注意，此时的canvas的坐标系已经移动
        canvas.clipRect(-centerX, -centerY, 0, centerY);
        //此时的canvas的坐标系已经旋转，所以这里是rotateY
        camera.rotateY(fixDegreeY);
        camera.applyToCanvas(canvas);
        canvas.rotate(degreeZ);
        canvas.translate(-centerX, -centerY);
        camera.restore();
        canvas.drawBitmap(bitmap, x, y, paint);
        canvas.restore();


    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        animationSet.start();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        animationSet.end();
    }

    public void setDegreeY(int degreeY) {
        this.degreeY = degreeY;
        invalidate();
    }

    public void setDegreeZ(int degreeZ) {
        this.degreeZ = degreeZ;
        invalidate();
    }

    public void setFixDegreeY(int fixDegreeY) {
        this.fixDegreeY = fixDegreeY;
        invalidate();
    }

    class Point {
        int left;
        int top;
        int right;
        int bottom;
    }

}
