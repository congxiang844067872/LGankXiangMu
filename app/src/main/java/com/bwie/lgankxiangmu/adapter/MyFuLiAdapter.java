package com.bwie.lgankxiangmu.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.lgankxiangmu.R;
import com.bwie.lgankxiangmu.adapter.holder.MyFuLiHolder;
import com.bwie.lgankxiangmu.bean.FuLiBean;
import com.bwie.lgankxiangmu.view.Clicklist;

import java.util.List;

/**
 * Created by admin on 2018/3/23.
 */

public class MyFuLiAdapter extends RecyclerView.Adapter<MyFuLiHolder> {

    private final Context context;
    private final List<FuLiBean.ResultsBean> list;
    private Clicklist myOnClicklister;

    public MyFuLiAdapter(Context context, List<FuLiBean.ResultsBean> list) {

        this.context = context;
        this.list = list;
    }


    @Override
    public MyFuLiHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_fuli, parent, false);
        MyFuLiHolder holder = new MyFuLiHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyFuLiHolder holder, final int position) {
        FuLiBean.ResultsBean bean = list.get(position);
        if (bean.getUrl()==null){
            holder.sdv_fuli.setImageURI("http://pic20.nipic.com/20120411/6024284_164937480388_2.jpg");
        }else {
            holder.sdv_fuli.setImageURI(bean.getUrl());
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myOnClicklister.MyOnClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public void setMyOnClicklister(Clicklist myOnClicklister) {

        this.myOnClicklister = myOnClicklister;
    }
}
