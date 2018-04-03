package com.bwie.lgankxiangmu.url;

/**
 * Created by admin on 2018/3/23.
 */

public class ApiUrl {
    //共同部分
    public static String gongtong="http://gank.io/api/data/";

    //home   明天接着做
    public static String home="Android/10/1";
    //ios
    public static String ios="iOS/10/";
    //fuli
    public static String fuli="福利/10/";

    //category 后面可接受参数 all | Android | iOS
    // | 休息视频 | 福利 | 拓展资源 | 前端 | 瞎推荐 | App
    //http://gank.io/api/search/query/listview/category/Android/count/10/page/1
    //http://gank.io/api/search/query/listview/category/App/count/10/page/1
    //福利 | Android | iOS | 休息视频 | 拓展资源 | 前端 | all
    //http://gank.io/api/data/休息视频/10/1

    //休息视频
    public static String shiping="休息视频/10/";
    //拓展资源
    public static String ziyuan="拓展资源/10/";
    //前端
    public static String qianduan="前端/20/";


    //接着做3.30
    public static String bufen="http://gank.io/api/search/query/listview/category/";
    //瞎推荐
    public static String tuijian="瞎推荐/10/";
    //app
    public static String app="App/10/";




}
