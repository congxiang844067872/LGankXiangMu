package com.bwie.lgankxiangmu.fragment.fragmenthome;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.bwie.lgankxiangmu.R;
import com.bwie.lgankxiangmu.activity.QianDuanActivity;
import com.bwie.lgankxiangmu.activity.UrlActivity;
import com.bwie.lgankxiangmu.adapter.MyHomeAdapter;
import com.bwie.lgankxiangmu.bean.HomeBean;
import com.bwie.lgankxiangmu.presenter.Presenter;
import com.bwie.lgankxiangmu.url.ApiUrl;
import com.bwie.lgankxiangmu.url.RetrofitUtil;
import com.bwie.lgankxiangmu.view.Clicklist;
import com.bwie.lgankxiangmu.view.MyView;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import okhttp3.ResponseBody;

/**
 * Created by admin on 2018/3/23.
 */

public class Frag_android extends Fragment implements MyView, SwipeRefreshLayout.OnRefreshListener {
    @BindView(R.id.recycler_home)
    RecyclerView recyclerHome;
    Unbinder unbinder;
    @BindView(R.id.swipe_refre)
    SwipeRefreshLayout swipeRefre;
    private Presenter presenter;
    private Map<String, String> map;
    private MyHomeAdapter adapter;
    private List<HomeBean> list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_android, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        map = new HashMap<>();
        presenter = new Presenter(this);
        presenter.attachView(this);
        swipeRefre.setOnRefreshListener(this);

    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.getUrl(RetrofitUtil.getCreate().doGet(ApiUrl.home, map));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void getResponseBody(ResponseBody responseBody) {
        try {
            //Log.d("+++++++++++",responseBody.string());
            final HomeBean homeBean = new Gson().fromJson(responseBody.string(), HomeBean.class);
//为SwipeRefreshLayout设置刷新时的颜色变化，最多可以设置4种
            swipeRefre.setColorSchemeResources(android.R.color.holo_blue_bright,
                    android.R.color.holo_green_light,
                    android.R.color.holo_orange_light,
                    android.R.color.holo_red_light);

            recyclerHome.setLayoutManager(new LinearLayoutManager(getActivity()
                    , LinearLayoutManager.VERTICAL, false));
            adapter = new MyHomeAdapter(getActivity(), homeBean);
            recyclerHome.setAdapter(adapter);
            adapter.setOnClicked(new Clicklist() {
                @Override
                public void MyOnClick(int position) {
                    String url = homeBean.getResults().get(position).getUrl();
                    Intent intent = new Intent(getActivity(),UrlActivity.class);
                    intent.putExtra("url",url);
                    startActivity(intent);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getError(Throwable throwable) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.setJieChu();
        if (presenter != null) {
            presenter.detachView();
        }
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeRefre.setRefreshing(false);
            }
        },3000);
        /*new Handler().post(new Runnable() {
            @Override
            public void run() {
                refreshData();
                //设置适配器
                swipeRefre.setRefreshing(false);
            }
        });*/
    }
    //简单示例，手动添加数据
    private void refreshData() {
        //list.add(0,);
        adapter.notifyDataSetChanged();
    }

}
