package com.example.ruiz.customviewdemo.webmessageport;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebMessage;
import android.webkit.WebMessagePort;
import android.webkit.WebView;

import com.example.ruiz.customviewdemo.R;

public class WebMessagePortActivity extends AppCompatActivity {


    private WebView web_view;

    private WebMessagePort[] webMessagePort = web_view.createWebMessageChannel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_message_port);

        web_view = findViewById(R.id.web_view);

        web_view.loadUrl("https://www.baidu.com");

        webMessagePort[0].setWebMessageCallback(new WebMessagePort.WebMessageCallback() {
            @Override
            public void onMessage(WebMessagePort port, WebMessage message) {
                super.onMessage(port, message);
            }
        });

    }
}
