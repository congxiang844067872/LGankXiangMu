package com.bwie.lgankxiangmu;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.bwie.lgankxiangmu.activity.Main2Activity;
import com.bwie.lgankxiangmu.url.Serc;
import com.facebook.drawee.view.SimpleDraweeView;


import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.sdv_1)
    SimpleDraweeView sdv1;
    @BindView(R.id.time)
    TextView time;
    private int t=1;
    @SuppressLint("HandlerLeak")
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==0){
                if (t>0){
                    t--;
                    time.setText(t+"S");
                    handler.sendEmptyMessageDelayed(0,1000);
                }else {
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View decorView = getWindow().getDecorView();
        int option = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(option);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        ButterKnife.bind(this);
        //showUrlBlur(draweeView, url, iterations, blurRadius)；
        //https://www.zhaoapi.cn//images//quarter//ad1.png
        Serc.showUrlBlur(sdv1,
                "http://pic20.nipic.com/20120411/6024284_164937480388_2.jpg"
                , 0, 2);
        handler.sendEmptyMessageDelayed(0,1000);
    }


}
