package com.bwie.lgankxiangmu.model;

import com.bwie.lgankxiangmu.presenter.PresenterPort;

import io.reactivex.Observable;
import okhttp3.ResponseBody;

/**
 * Created by admin on 2018/3/23.
 */

public interface ModelPort {
    void getUrl(Observable<ResponseBody> responseBodyObservable);
    void setJieChu();
}
