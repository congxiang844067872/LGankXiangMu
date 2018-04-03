package com.bwie.lgankxiangmu.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.bwie.lgankxiangmu.R;
import com.bwie.lgankxiangmu.zidingyi.XCFlowLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SouSuoActivity extends AppCompatActivity {

    @BindView(R.id.edit_sousuo)
    EditText editSousuo;
    @BindView(R.id.list_view)
    ListView listView;
    private String mNames[] = {
            "RxJava", "RxAndroid", "数据库",
            "下拉刷新", "mvp", "直播",
            "权限管理", "Retrofit", "OkHttp",
            "WebWiew", "热修复"
    };
    private XCFlowLayout mFlowLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getWindow().getDecorView();
        int option = View.SCREEN_STATE_OFF;
        decorView.setSystemUiVisibility(option);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        setContentView(R.layout.activity_sou_suo);
        ButterKnife.bind(this);
        initChildViews();
//http://gank.io/api/data/all/10/1


    }

    @OnClick({R.id.image_fanhui, R.id.text_sousuo,R.id.text_lishi})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.image_fanhui:
                finish();
                break;
            case R.id.text_sousuo:
                Intent intent = new Intent(SouSuoActivity
                        .this, SouSuoLieBiaoActivity.class);
                String s = editSousuo.getText().toString();
                intent.putExtra("s", s);
                startActivity(intent);
                break;
            case R.id.text_lishi:


                break;
        }
    }

    private void initChildViews() {
        // TODO Auto-generated method stub
        mFlowLayout = (XCFlowLayout) findViewById(R.id.flowlayout);
        ViewGroup.MarginLayoutParams lp = new ViewGroup.MarginLayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.leftMargin = 5;
        lp.rightMargin = 5;
        lp.topMargin = 5;
        lp.bottomMargin = 5;
        for (int i = 0; i < mNames.length; i++) {
            TextView view = new TextView(this);
            view.setText(mNames[i]);
            view.setTextColor(Color.BLACK);
            view.setBackgroundDrawable(getResources().getDrawable(R.drawable.textview_bg));
            mFlowLayout.addView(view, lp);

        }

    }

}
