package com.bwie.lgankxiangmu.view;

import okhttp3.ResponseBody;

/**
 * Created by admin on 2018/3/23.
 */

public interface MyView {
    void getResponseBody(ResponseBody responseBody);
    void getError(Throwable throwable);
}
