package com.bwie.lgankxiangmu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioGroup;

import com.bwie.lgankxiangmu.R;
import com.bwie.lgankxiangmu.fragment.Frag_Home;
import com.bwie.lgankxiangmu.fragment.Frag_Me;
import com.bwie.lgankxiangmu.fragment.Frag_Read;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main2Activity extends AppCompatActivity {

    @BindView(R.id.view_vp)
    ViewPager viewVp;
    @BindView(R.id.radio_group)
    RadioGroup radioGroup;
    @BindView(R.id.list_view)
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
        View decorView = getWindow().getDecorView();
        int option = View.SCREEN_STATE_OFF;
        decorView.setSystemUiVisibility(option);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        List<String> list = new ArrayList<>();
        list.add("前端");
        list.add("瞎推荐");
        list.add("APP");
        list.add("拓展资源");
        list.add("休息视频");
        list.add("主题切换");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent intent = new Intent(Main2Activity
                                .this, QianDuanActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent1 = new Intent(Main2Activity
                                .this, TuiJianActivity.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(Main2Activity
                                .this, AppActivity.class);
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(Main2Activity
                                .this, TuoZhanZiYuanActivity.class);
                        startActivity(intent3);
                        break;
                    case 4:
                        Intent intent4 = new Intent(Main2Activity
                                .this, ShiPingActivity.class);
                        startActivity(intent4);
                        break;
                    case 5:
                        Intent intent5 = new Intent(Main2Activity
                                .this, ZhuTiQieHuanActivity.class);
                        startActivity(intent5);
                        break;
                }
            }
        });
        viewVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Fragment fragment = null;
                switch (position) {
                    case 0:
                        fragment = new Frag_Home();
                        break;
                    case 1:
                        fragment = new Frag_Read();
                        break;
                    case 2:
                        fragment = new Frag_Me();
                        break;
                }
                return fragment;
            }

            @Override
            public int getCount() {
                return 3;
            }
        });
        viewVp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                radioGroup.check(radioGroup.getChildAt(position).getId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio_01:
                        viewVp.setCurrentItem(0, false);
                        break;
                    case R.id.radio_02:
                        viewVp.setCurrentItem(1, false);
                        break;
                    case R.id.radio_03:
                        viewVp.setCurrentItem(2, false);
                        break;
                }
            }
        });
    }

    @OnClick(R.id.image_sousuo)
    public void onClick() {
        Intent intent = new Intent(Main2Activity
                .this,SouSuoActivity.class);
        startActivity(intent);
    }
}
