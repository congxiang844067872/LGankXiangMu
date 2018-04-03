package com.bwie.lgankxiangmu.presenter;

import io.reactivex.Observable;
import okhttp3.ResponseBody;

/**
 * Created by admin on 2018/3/23.
 */

public interface PresenterPort {
    void getResponseBody(ResponseBody responseBody);
    void getError(Throwable throwable);

    void getUrl(Observable<ResponseBody> responseBodyObservable);
    void setJieChu();
}
