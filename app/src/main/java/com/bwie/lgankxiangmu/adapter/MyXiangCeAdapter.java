package com.bwie.lgankxiangmu.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.lgankxiangmu.R;
import com.bwie.lgankxiangmu.activity.BenDiXiangCeActivity;
import com.bwie.lgankxiangmu.adapter.holder.MyXiangCeHolder;
import com.bwie.lgankxiangmu.view.Clicklist;

import java.io.File;
import java.util.List;

import retrofit2.http.Url;

/**
 * Created by admin on 2018/3/29.
 */

public class MyXiangCeAdapter extends RecyclerView.Adapter<MyXiangCeHolder> {
    private final Context context;
    private final List<String> list;
    private Clicklist cicklist;

    public MyXiangCeAdapter(Context context, List<String> list) {

        this.context = context;
        this.list = list;
    }

    @Override
    public MyXiangCeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_xiangce, parent, false);
        MyXiangCeHolder holder = new MyXiangCeHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyXiangCeHolder holder, final int position) {
        Uri uri = Uri.fromFile(new File(list.get(position)));
        holder.sdv_1.setImageURI(uri);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cicklist.MyOnClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setOnCicklist(Clicklist cicklist){

        this.cicklist = cicklist;
    }
}
