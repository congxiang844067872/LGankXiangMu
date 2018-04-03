package com.bwie.lgankxiangmu.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bwie.lgankxiangmu.MainActivity;
import com.bwie.lgankxiangmu.R;
import com.bwie.lgankxiangmu.activity.BenDiXiangCeActivity;
import com.bwie.lgankxiangmu.activity.FengXiangActivity;
import com.bwie.lgankxiangmu.url.MessageEvent;
import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by admin on 2018/3/23.
 */

public class Frag_Me extends Fragment {
    Unbinder unbinder;
    @BindView(R.id.sdv_3)
    SimpleDraweeView sdv3;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_me, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //注册成为订阅者
        EventBus.getDefault().register(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.sdv_3, R.id.relative_Boke, R.id.relative_Banben, R.id.relative_follow, R.id.relative_shouchang})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sdv_3:

                Intent intent = new Intent(getActivity()
                        , BenDiXiangCeActivity.class);
                startActivity(intent);
                break;
            case R.id.relative_Boke:
                //明天做
                Intent intent1 = new Intent(getActivity(), FengXiangActivity.class);
                startActivity(intent1);
                break;
            case R.id.relative_Banben:

                break;
            case R.id.relative_follow:

                break;
            case R.id.relative_shouchang:

                break;
        }
    }

    //订阅方法，当接收到事件的时候，会调用该方法
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(MessageEvent messageEvent){
        //Log.d("cylog","receive it");
        Uri uri = Uri.fromFile(new File(messageEvent.getMessage()));
        sdv3.setImageURI(uri);
        //Toast.makeText(getActivity(), messageEvent.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //解除注册
        EventBus.getDefault().unregister(this);
    }
}
