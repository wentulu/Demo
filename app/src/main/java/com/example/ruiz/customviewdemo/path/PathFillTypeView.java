package com.example.ruiz.customviewdemo.path;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class PathFillTypeView extends View{

    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public PathFillTypeView(Context context) {
        super(context);
    }

    public PathFillTypeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PathFillTypeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Path path = new Path();


        //实验EVEN_ODD方向对于fill type无影响
        //从一个点任意射线，交点是奇数的在图形内，交点是偶数的在图形外
        path.addCircle(200,200,100, Path.Direction.CW);
        path.addCircle(200,250,100, Path.Direction.CCW);
        path.setFillType(Path.FillType.EVEN_ODD);
        canvas.drawPath(path,mPaint);

        path.reset();
        //实验INVERSE_EVEN_ODD
        //与EVEN_ODD相反，奇数在图外，偶数在图内  canvas外的都是偶数  会在圆形外面也画出来
        path.addCircle(500,200,100, Path.Direction.CW);
        path.addCircle(500,250,100, Path.Direction.CW);
//        canvas.save();
        path.setFillType(Path.FillType.INVERSE_EVEN_ODD);
        canvas.drawPath(path,mPaint);
//        canvas.restore();


        path.reset();
        //实验WINDING 统一的顺时针
        path.addCircle(200, 600,100, Path.Direction.CW);
        path.addCircle(200,650,100, Path.Direction.CW);
        path.setFillType(Path.FillType.WINDING);
        canvas.drawPath(path,mPaint);


        //实验WINDING 顺时针和逆时针
        path.addCircle(500, 600,100, Path.Direction.CW);
        path.addCircle(500,650,100, Path.Direction.CCW);
        path.setFillType(Path.FillType.WINDING);
        canvas.drawPath(path,mPaint);

        //实验INVERSE_WINDING 统一顺时针
        path.reset();
        path.addCircle(200,1000,100, Path.Direction.CW);
        path.addCircle(200,1050,100, Path.Direction.CW);
        path.setFillType(Path.FillType.INVERSE_WINDING);
        canvas.drawPath(path,mPaint);


        path.reset();
        //
        path.addCircle(500,1000,100, Path.Direction.CW);
        path.addCircle(500,1050,100, Path.Direction.CCW);
        path.setFillType(Path.FillType.INVERSE_WINDING);
        canvas.drawPath(path,mPaint);

    }
}
