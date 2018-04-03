package com.bwie.lgankxiangmu.fragment.fragmenthome;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.lgankxiangmu.R;
import com.bwie.lgankxiangmu.activity.MainFuLiActivity;
import com.bwie.lgankxiangmu.adapter.MyFuLiAdapter;
import com.bwie.lgankxiangmu.bean.FuLiBean;
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

public class Frag_fuli extends Fragment implements MyView {
    @BindView(R.id.recycler_fuli)
    RecyclerView recyclerFuli;
    Unbinder unbinder;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    private Presenter presenter;
    private Map<String, String> map;
    private List<FuLiBean.ResultsBean> list = new ArrayList<>();
    private int page = 1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_fuli, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        map = new HashMap<>();
        presenter = new Presenter(this);
        presenter.attachView(this);
        presenter.getUrl(RetrofitUtil.getCreate().doGet(ApiUrl.fuli + "1", map));
    }

    @Override
    public void onResume() {
        super.onResume();
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
            final FuLiBean fuLiBean = new Gson().fromJson(responseBody.string(), FuLiBean.class);
            List<FuLiBean.ResultsBean> results = fuLiBean.getResults();
            list.addAll(results);
            recyclerFuli.setLayoutManager(new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false));
            MyFuLiAdapter adapter = new MyFuLiAdapter(getActivity(), list);
            recyclerFuli.setAdapter(adapter);

            adapter.setMyOnClicklister(new Clicklist() {
                @Override
                public void MyOnClick(int position) {
                    Intent intent = new Intent(getActivity(), MainFuLiActivity.class);
                    intent.putExtra("url", fuLiBean.getResults().get(position).getUrl() + "");
                    startActivity(intent);

                }
            });

            refreshLayout.setOnRefreshListener(new OnRefreshListener() {
                @Override
                public void onRefresh(@NonNull RefreshLayout refreshLayout) {

                    refreshLayout.finishRefresh();
                }
            });
            refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
                @Override
                public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                    page++;
                    presenter.getUrl(RetrofitUtil.getCreate().doGet(ApiUrl.fuli +page, map));
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
}
