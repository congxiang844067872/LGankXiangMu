package com.bwie.lgankxiangmu.presenter;

import com.bwie.lgankxiangmu.fragment.fragmenthome.Frag_android;
import com.bwie.lgankxiangmu.model.Model;
import com.bwie.lgankxiangmu.view.MyView;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;

/**
 * Created by admin on 2018/3/23.
 */

public class Presenter extends BasePresenter implements PresenterPort{
    private MyView myView;
    private final Model model;

    public Presenter(MyView myView) {
        model = new Model(this);
        this.myView = myView;
    }



    @Override
    public void getResponseBody(ResponseBody responseBody) {
        myView.getResponseBody(responseBody);
    }

    @Override
    public void getError(Throwable throwable) {
        myView.getError(throwable);
    }
    @Override
    public void getUrl(Observable<ResponseBody> responseBodyObservable) {
        model.getUrl(responseBodyObservable);
    }
    @Override
    public void setJieChu() {
        model.setJieChu();
    }
}
