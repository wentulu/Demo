package com.example.ruiz.customviewdemo.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatSeekBar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.ruiz.customviewdemo.R;

public class ViewPositionActivity extends AppCompatActivity {


    private TextView position_tv,position_info_tv;
    private AppCompatSeekBar withSeekBar,heightSeekBar;

    StringBuffer positionStr = new StringBuffer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_position);

        initView();
    }

    private void initView() {
        position_tv = findViewById(R.id.position_tv);
        position_info_tv = findViewById(R.id.position_info_tv);

        withSeekBar = findViewById(R.id.width_seekbar);
        heightSeekBar = findViewById(R.id.height_seekbar);
        withSeekBar.setOnSeekBarChangeListener(changeListener);
        heightSeekBar.setOnSeekBarChangeListener(changeListener);

    }

    SeekBar.OnSeekBarChangeListener changeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            int translateX = withSeekBar.getProgress()*5;
            int translateY = heightSeekBar.getProgress()*5;

            /**
             * X的值是X= left + translateX。
            * TranslateX/Y修改了translateX/Y的值
            * */
//            position_tv.setTranslationX(translateX);
//            position_tv.setTranslationY(translateY);

            /**
             * LayoutParam 中的margin信息修改的是 left和top值
             * */
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) position_tv.getLayoutParams();

            layoutParams.leftMargin =translateX;
            layoutParams.topMargin = translateY;
            position_tv.setLayoutParams(layoutParams);


            positionStr = new StringBuffer();
            positionStr.append("X: "+position_tv.getX()+" = "+position_tv.getLeft()+" + "+ position_tv.getTranslationX() );
            positionStr.append("\n");
            positionStr.append("Y: "+position_tv.getY()+" = "+position_tv.getTop() +" + "+ position_tv.getTranslationY());
            position_info_tv.setText(positionStr);
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

}
