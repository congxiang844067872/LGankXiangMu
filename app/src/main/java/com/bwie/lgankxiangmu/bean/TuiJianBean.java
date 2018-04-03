package com.bwie.lgankxiangmu.bean;

import java.util.List;

/**
 * Created by admin on 2018/3/30.
 */

public class TuiJianBean {

    /**
     * count : 10
     * error : false
     * results : [{"desc":"为什么Chrome如代码家爱丢肥皂一样爱吃内存","ganhuo_id":"56cc6d1d421aa95caa7075ed","publishedAt":"2015-06-03T04:59:44.395000","readability":"","type":"瞎推荐","url":"http://www.pingwest.com/much-ram-very-slow-so-chrome-wow/","who":"有时放纵"},{"desc":"阿里又出大事了, 阿里这是隔几天上一次知乎头条的节奏...","ganhuo_id":"56cc6d1d421aa95caa7075f2","publishedAt":"2015-06-03T04:59:44.395000","readability":"","type":"瞎推荐","url":"http://www.zhihu.com/question/30778071","who":"Andrew Liu"},{"desc":"一个轻量级的Markdown Wiki系统","ganhuo_id":"56cc6d1d421aa95caa7076b3","publishedAt":"2015-07-02T03:50:46.973000","readability":"","type":"瞎推荐","url":"https://github.com/zacharyvoase/markdoc","who":"mthli"},{"desc":"根本停不下的一只猫( ꒪⌓꒪)","ganhuo_id":"56cc6d1d421aa95caa70772f","publishedAt":"2015-05-27T04:21:14.140000","readability":"","type":"瞎推荐","url":"http://www.nyan.cat/","who":"mthli"},{"desc":"SQL总结（一）基本查询","ganhuo_id":"56cc6d1d421aa95caa7077d4","publishedAt":"2016-03-11T12:37:20.004000","readability":"","type":"瞎推荐","url":"http://www.imooc.com/article/1412","who":"LHF"},{"desc":"MAT - Memory Analyzer Tool 使用进阶","ganhuo_id":"56cc6d1d421aa95caa707838","publishedAt":"2016-04-22T12:18:49.675000","readability":"","type":"瞎推荐","url":"http://www.lightskystreet.com/2015/09/01/mat_usage/","who":"LHF"},{"desc":"youtube小窗口 边刷网页边看视频","ganhuo_id":"56cc6d22421aa95caa7078fc","publishedAt":"2015-10-08T04:29:48","readability":"","type":"瞎推荐","url":"http://sideplayer.com/","who":"lxxself"},{"desc":"在局域网里找到你的树莓派地址\n","ganhuo_id":"56cc6d23421aa95caa707a03","publishedAt":"2015-05-28T03:49:21.702000","readability":"","type":"瞎推荐","url":"https://github.com/dlion/WhereIsMyPi","who":"\u0003tiiime"},{"desc":"向产品宣战\u2014\u2014开发者眼中的Android UI Design","ganhuo_id":"56cc6d23421aa95caa707aad","publishedAt":"2015-06-10T04:12:03.892000","readability":"","type":"瞎推荐","url":"http://blog.csdn.net/eclipsexys/article/details/46238889","who":" "},{"desc":"谷歌大牛Jeff Dean的那些\u201c惊人真相\u201d","ganhuo_id":"56cc6d23421aa95caa707c37","publishedAt":"2015-07-27T04:01:34.367000","readability":"","type":"瞎推荐","url":"http://blog.jobbole.com/51607/","who":"andyiac"}]
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
         * desc : 为什么Chrome如代码家爱丢肥皂一样爱吃内存
         * ganhuo_id : 56cc6d1d421aa95caa7075ed
         * publishedAt : 2015-06-03T04:59:44.395000
         * readability :
         * type : 瞎推荐
         * url : http://www.pingwest.com/much-ram-very-slow-so-chrome-wow/
         * who : 有时放纵
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
