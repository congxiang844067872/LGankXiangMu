package com.bwie.lgankxiangmu.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.bwie.lgankxiangmu.R;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainFuLiActivity extends AppCompatActivity {

    @BindView(R.id.sdv_tu)
    SimpleDraweeView sdvTu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getWindow().getDecorView();
        int option = View.SCREEN_STATE_OFF;
        decorView.setSystemUiVisibility(option);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        setContentView(R.layout.activity_main_fu_li);
        ButterKnife.bind(this);

        String url = getIntent().getStringExtra("url");
        sdvTu.setImageURI(url);

    }
}
