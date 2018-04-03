package com.bwie.lgankxiangmu.activity;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bwie.lgankxiangmu.R;
import com.bwie.lgankxiangmu.adapter.MyXiangCeAdapter;
import com.bwie.lgankxiangmu.url.MessageEvent;
import com.bwie.lgankxiangmu.view.Clicklist;

import org.greenrobot.eventbus.EventBus;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BenDiXiangCeActivity extends AppCompatActivity {

    @BindView(R.id.recycler_xiangce)
    RecyclerView recyclerXiangce;
    private List<String> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ben_di_xiang_ce);
        ButterKnife.bind(this);

        Cursor cursor = getContentResolver().query(MediaStore
                        .Images.Media.EXTERNAL_CONTENT_URI, null
                , null, null, null);
        while (cursor.moveToNext()){
            String paths = cursor.getString(cursor
                    .getColumnIndex(MediaStore.Images.Media.DATA));
            File file = new File(paths);
            String absolutePath = file.getAbsolutePath();
            list.add(absolutePath);
        }
        cursor.close();

        recyclerXiangce.setLayoutManager(new GridLayoutManager(BenDiXiangCeActivity
                .this,3,GridLayoutManager.VERTICAL,false));
        MyXiangCeAdapter adapter = new MyXiangCeAdapter(this, list);
        recyclerXiangce.setAdapter(adapter);
        //接着做
        adapter.setOnCicklist(new Clicklist() {
            @Override
            public void MyOnClick(int position) {
                EventBus.getDefault().post(new MessageEvent(list.get(position)));
                finish();
            }
        });

    }
}
