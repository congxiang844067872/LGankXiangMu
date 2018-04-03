package com.bwie.lgankxiangmu.model;

import com.bwie.lgankxiangmu.presenter.Presenter;
import com.bwie.lgankxiangmu.presenter.PresenterPort;
import com.bwie.lgankxiangmu.url.RetrofitUtil;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/**
 * Created by admin on 2018/3/23.
 */

public class Model implements ModelPort {
    private Disposable d;
    private PresenterPort presenterPort;
    public Model(PresenterPort presenterPort) {

        this.presenterPort = presenterPort;
    }

    @Override
    public void getUrl(Observable<ResponseBody> responseBodyObservable) {
        responseBodyObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {

                    @Override
                    public void onSubscribe(Disposable d) {

                        Model.this.d = d;
                    }

                    @Override
                    public void onNext(ResponseBody value) {
                        presenterPort.getResponseBody(value);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    @Override
    public void setJieChu() {
        d.dispose();
    }
}
