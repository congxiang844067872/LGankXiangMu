package com.bwie.lgankxiangmu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.lgankxiangmu.R;
import com.bwie.lgankxiangmu.activity.TuoZhanZiYuanActivity;
import com.bwie.lgankxiangmu.adapter.holder.MyHomeHolder;
import com.bwie.lgankxiangmu.bean.TuoZhanZiYuanBean;
import com.bwie.lgankxiangmu.view.Clicklist;

import java.util.List;

/**
 * Created by admin on 2018/3/30.
 */

public class ZiYuanAdapter extends RecyclerView.Adapter<MyHomeHolder> {
    private final Context context;
    private final List<TuoZhanZiYuanBean.ResultsBean> list;
    private Clicklist clicked;

    public ZiYuanAdapter(Context context, List<TuoZhanZiYuanBean.ResultsBean> list) {

        this.context = context;
        this.list = list;
    }

    @Override
    public MyHomeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_home, parent, false);
        MyHomeHolder holder = new MyHomeHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHomeHolder holder, final int position) {
        TuoZhanZiYuanBean.ResultsBean bean = list.get(position);
        if (bean.getImages()==null){
            holder.sdv_recycler.setImageURI("http://pic20.nipic.com/20120411/6024284_164937480388_2.jpg");
        }else {
            holder.sdv_recycler.setImageURI(bean.getImages().get(0));
        }
        holder.text_tite.setText(bean.getDesc());
        holder.text_name.setText(bean.getWho());
        holder.text_time.setText(bean.getPublishedAt());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked.MyOnClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public void setOnClicked(Clicklist clicked){

        this.clicked = clicked;
    }
}
