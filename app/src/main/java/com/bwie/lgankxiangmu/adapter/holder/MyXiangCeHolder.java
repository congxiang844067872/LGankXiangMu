package com.bwie.lgankxiangmu.adapter.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bwie.lgankxiangmu.R;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by admin on 2018/3/29.
 */

public class MyXiangCeHolder extends RecyclerView.ViewHolder {

    public SimpleDraweeView sdv_1;

    public MyXiangCeHolder(View itemView) {
        super(itemView);
        sdv_1 = itemView.findViewById(R.id.sdv_1);
    }
}
