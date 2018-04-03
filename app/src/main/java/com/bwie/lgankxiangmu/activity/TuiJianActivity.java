package com.bwie.lgankxiangmu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.bwie.lgankxiangmu.R;
import com.bwie.lgankxiangmu.adapter.QianDuanAdapter;
import com.bwie.lgankxiangmu.adapter.TuiJianAdapter;
import com.bwie.lgankxiangmu.bean.QianDuanBean;
import com.bwie.lgankxiangmu.bean.TuiJianBean;
import com.bwie.lgankxiangmu.presenter.Presenter;
import com.bwie.lgankxiangmu.url.ApiUrl;
import com.bwie.lgankxiangmu.url.RetrofitUtil;
import com.bwie.lgankxiangmu.view.Clicklist;
import com.bwie.lgankxiangmu.view.MyView;
import com.google.gson.Gson;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;

public class TuiJianActivity extends AppCompatActivity implements MyView{

    @BindView(R.id.recycler_tuijian)
    RecyclerView recyclerTuijian;
    @BindView(R.id.swipe_refre)
    SmartRefreshLayout swipeRefre;
    private Presenter presenter;
    private Map<String, String> map;
    private List<TuiJianBean.ResultsBean> list = new ArrayList<>();
    private int page = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getWindow().getDecorView();
        int option = View.SCREEN_STATE_OFF;
        decorView.setSystemUiVisibility(option);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_tui_jian);
        ButterKnife.bind(this);

        map = new HashMap<>();
        presenter = new Presenter(this);
        presenter.attachView(this);
        presenter.getUrl(RetrofitUtil.getService().doGet(ApiUrl.tuijian + "1", map));

    }


    @Override
    public void getResponseBody(ResponseBody responseBody) {
        try {
            //Log.d("+++++++++",responseBody.string());
            TuiJianBean tuiJianBean = new Gson().fromJson(responseBody
                    .string(), TuiJianBean.class);
            List<TuiJianBean.ResultsBean> results = tuiJianBean.getResults();

            list.addAll(results);
            recyclerTuijian.setLayoutManager(new LinearLayoutManager(this
                    , LinearLayoutManager.VERTICAL, false));
            TuiJianAdapter adapter = new TuiJianAdapter(this, list);
            recyclerTuijian.setAdapter(adapter);

            adapter.setOnClicked(new Clicklist() {
                @Override
                public void MyOnClick(int position) {
                    String url = list.get(position).getUrl();
                    Intent intent = new Intent(TuiJianActivity.this,UrlActivity.class);
                    intent.putExtra("url",url);
                    startActivity(intent);
                }
            });

            swipeRefre.setOnRefreshListener(new OnRefreshListener() {
                @Override
                public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                    refreshLayout.finishRefresh(1000);
                }
            });
            swipeRefre.setOnLoadMoreListener(new OnLoadMoreListener() {
                @Override
                public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                    page++;
                    presenter.getUrl(RetrofitUtil.getService().doGet(ApiUrl
                            .tuijian +page, map));
                    refreshLayout.finishLoadMore(1000);
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

}
