package com.bwie.lgankxiangmu.bean;

import java.util.List;

/**
 * Created by admin on 2018/3/30.
 */

public class AppBean {

    /**
     * count : 10
     * error : false
     * results : [{"desc":"Tapet - HD材质壁纸 一款免费的Android壁纸应用","ganhuo_id":"56cc6d1d421aa95caa70758b","publishedAt":"2015-10-30T03:50:54.401000","readability":"","type":"App","url":"http://weibo.com/1874136301/D1vAps9cW?type=comment#_rnd1446173693528","who":"咕咚"},{"desc":"MD风格的36氪Android阅读客户端","ganhuo_id":"56cc6d22421aa95caa707936","publishedAt":"2015-10-19T03:47:21.638000","readability":"","type":"App","url":"https://github.com/kinneyyan/36krReader","who":"咕咚"},{"desc":"PocketHub 一个 Github 非官方客户端","ganhuo_id":"56cc6d26421aa95caa707fce","publishedAt":"2015-12-14T04:19:59.742000","readability":"","type":"App","url":"https://github.com/pockethub/PocketHub","who":"咕咚"},{"desc":"一个图像处理相关的 Android 开源 App ","ganhuo_id":"56cc6d26421aa95caa708098","publishedAt":"2016-01-22T05:14:47.797000","readability":"","type":"App","url":"https://github.com/yaa110/Effects-Pro","who":"咕咚"},{"desc":"品趣App","ganhuo_id":"56cc6d26421aa95caa708058","publishedAt":"2015-12-30T04:14:04.798000","readability":"","type":"App","url":"https://github.com/ltebean/novel-design","who":"Jason"},{"desc":"心动\u2014\u2014记录生活中的心动瞬间","ganhuo_id":"56cc6d29421aa95caa7080f5","publishedAt":"2016-01-05T05:47:06.948000","readability":"","type":"App","url":"https://github.com/maxiee/HeartBeat","who":"Jason"},{"desc":"用Swift写围棋App","ganhuo_id":"56cc6d28421aa95caa7080b7","publishedAt":"2015-12-30T04:14:04.816000","readability":"","type":"App","url":"https://github.com/marknote/GoTao","who":"Jason"},{"desc":"微信抢红包插件, 帮助你在微信群聊抢红包时战无不胜！","ganhuo_id":"56cc6d29421aa95caa7081f1","publishedAt":"2016-01-25T06:59:09.007000","readability":"","type":"App","url":"https://github.com/geeeeeeeeek/WeChatLuckyMoney/releases/","who":"咕咚"},{"desc":"一个 Chrome 查单词插件 支持划词，自动加入扇贝单词生词本，方便手机同步学习。","ganhuo_id":"56cc6d29421aa95caa7081b5","publishedAt":"2016-01-19T04:06:04.444000","readability":"","type":"App","url":"https://github.com/XYUU/ChaZD","who":"咕咚"},{"desc":"A Material Design styled Game of Life for Android\n","ganhuo_id":"56cc6d29421aa95caa708150","publishedAt":"2016-01-12T04:15:24.611000","readability":"","type":"App","url":"https://github.com/juankysoriano/MaterialLife","who":"咕咚"}]
     */

    private int count;
    private boolean error;
    private List<ResultsBean> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * desc : Tapet - HD材质壁纸 一款免费的Android壁纸应用
         * ganhuo_id : 56cc6d1d421aa95caa70758b
         * publishedAt : 2015-10-30T03:50:54.401000
         * readability :
         * type : App
         * url : http://weibo.com/1874136301/D1vAps9cW?type=comment#_rnd1446173693528
         * who : 咕咚
         */

        private String desc;
        private String ganhuo_id;
        private String publishedAt;
        private String readability;
        private String type;
        private String url;
        private String who;
        private List<String> images;

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getGanhuo_id() {
            return ganhuo_id;
        }

        public void setGanhuo_id(String ganhuo_id) {
            this.ganhuo_id = ganhuo_id;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getReadability() {
            return readability;
        }

        public void setReadability(String readability) {
            this.readability = readability;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }
        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }
}
