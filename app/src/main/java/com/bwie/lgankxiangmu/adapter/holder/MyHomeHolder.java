package com.bwie.lgankxiangmu.adapter.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.bwie.lgankxiangmu.R;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by admin on 2018/3/23.
 */

public class MyHomeHolder extends RecyclerView.ViewHolder {

    public SimpleDraweeView sdv_recycler;
    public TextView text_tite;
    public TextView text_name;
    public TextView text_time;

    public MyHomeHolder(View itemView) {
        super(itemView);
        sdv_recycler = itemView.findViewById(R.id.sdv_recycler);
        text_tite = itemView.findViewById(R.id.text_tite);
        text_name = itemView.findViewById(R.id.text_name);
        text_time = itemView.findViewById(R.id.text_time);


    }
}
