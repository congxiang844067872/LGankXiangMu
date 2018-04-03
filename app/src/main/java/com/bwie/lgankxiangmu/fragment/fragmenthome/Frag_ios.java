package com.bwie.lgankxiangmu.fragment.fragmenthome;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.lgankxiangmu.R;
import com.bwie.lgankxiangmu.activity.QianDuanActivity;
import com.bwie.lgankxiangmu.activity.UrlActivity;
import com.bwie.lgankxiangmu.adapter.MyIosAdapter;
import com.bwie.lgankxiangmu.bean.IosBean;
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
import butterknife.Unbinder;
import okhttp3.ResponseBody;

/**
 * Created by admin on 2018/3/23.
 */

public class Frag_ios extends Fragment implements MyView {
    @BindView(R.id.recycler_ios)
    RecyclerView recyclerIos;
    Unbinder unbinder;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    private List<IosBean.ResultsBean> list = new ArrayList<>();
    private Presenter presenter;
    private Map<String, String> map;
    private int page=1;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_ios, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        map = new HashMap<>();
        presenter = new Presenter(this);
        presenter.attachView(this);
        presenter.getUrl(RetrofitUtil.getCreate().doGet(ApiUrl.ios+"1", map));

    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void getResponseBody(ResponseBody responseBody) {
        try {
            //Log.d("+++++++++++",responseBody.string());

            final IosBean iosBean = new Gson().fromJson(responseBody.string(), IosBean.class);
            list.addAll(iosBean.getResults());
            //List<IosBean.ResultsBean> results = iosBean.getResults();
            recyclerIos.setLayoutManager(new LinearLayoutManager(getActivity()
                    , LinearLayoutManager.VERTICAL, false));
            MyIosAdapter adapter = new MyIosAdapter(getActivity(), list);
            recyclerIos.setAdapter(adapter);
            adapter.setOnClicked(new Clicklist() {
                @Override
                public void MyOnClick(int position) {
                    String url = list.get(position).getUrl();
                    Intent intent = new Intent(getActivity(),UrlActivity.class);
                    intent.putExtra("url",url);
                    startActivity(intent);
                }
            });

            refreshLayout.setOnRefreshListener(new OnRefreshListener() {
                @Override
                public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                    //list.addAll(0,iosBean.getResults());
                    refreshLayout.finishRefresh();
                }
            });

            refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
                @Override
                public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                    page++;
                    presenter.getUrl(RetrofitUtil.getCreate().doGet(ApiUrl.ios+page, map));

                    refreshLayout.finishLoadMore();
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
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
