package com.bwie.lgankxiangmu.adapter.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bwie.lgankxiangmu.R;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by admin on 2018/3/23.
 */

public class MyFuLiHolder extends RecyclerView.ViewHolder {

    public SimpleDraweeView sdv_fuli;

    public MyFuLiHolder(View itemView) {
        super(itemView);
        sdv_fuli = itemView.findViewById(R.id.sdv_fuli);
    }
}
