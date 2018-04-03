package com.bwie.lgankxiangmu.bean;

import java.util.List;

/**
 * Created by admin on 2018/3/30.
 */

public class ShiPingBean {

    /**
     * error : false
     * results : [{"_id":"58ae6af7421aa957f9dd6dc3","createdAt":"2017-02-23T12:54:15.286Z","desc":"我媽要我告訴你 ","publishedAt":"2018-03-12T08:44:50.326Z","source":"chrome","type":"休息视频","url":"https://v.qq.com/x/page/m0377ib544o.html?start=1","used":true,"who":"lxxself"},{"_id":"59fefc13421aa90fe72535fc","createdAt":"2017-11-05T19:54:59.820Z","desc":"100年来，看看中国人是如何拍照的。看到哪一个触动了你 \u200b","publishedAt":"2018-02-22T08:24:35.209Z","source":"chrome","type":"休息视频","url":"https://weibo.com/tv/v/Fcbf78DEK?fid=1034:e95c9d521d94f4ce5ba8a4a0e5eda105&display=0&retcode=6102","used":true,"who":"lxxself"},{"_id":"5a769cc2421aa90d24a065c8","createdAt":"2018-02-04T13:40:18.31Z","desc":"马英九回答大陆学生提问","publishedAt":"2018-02-08T08:13:24.479Z","source":"chrome","type":"休息视频","url":"https://weibo.com/3280647594/FCQbzdVnm?type=comment","used":true,"who":"lxxself"},{"_id":"593d5534421aa92c7be61bed","createdAt":"2017-06-11T22:35:32.688Z","desc":"惊人的篮球实验！简直不敢相信自己的双眼！","publishedAt":"2018-01-29T07:53:57.676Z","source":"chrome","type":"休息视频","url":"http://www.bilibili.com/video/av4804332/","used":true,"who":"LHF"},{"_id":"571cd54667765974f885bf75","createdAt":"2016-04-24T22:16:38.889Z","desc":"搞机番外篇：三个曲面屏环绕打LOL算不算作弊？","publishedAt":"2018-01-23T08:46:45.132Z","source":"chrome","type":"休息视频","url":"http://www.bilibili.com/video/av4416912/","used":true,"who":"LHF"},{"_id":"59e8acf3421aa90fe72535ad","createdAt":"2017-10-19T21:47:31.863Z","desc":"【敖厂长】日本精神污染游戏","publishedAt":"2018-01-16T08:40:08.101Z","source":"chrome","type":"休息视频","url":"http://www.bilibili.com/video/av15534849/","used":true,"who":"LHF"},{"_id":"5a29ec8b421aa90fe2f02cc0","createdAt":"2017-12-08T09:36:11.575Z","desc":"街上碰上恶犬怎么办？学习一下如何自救和救人很有必要[赞] \u200b","publishedAt":"2018-01-10T07:57:19.486Z","source":"chrome","type":"休息视频","url":"https://weibo.com/tv/v/FyeOLvFNJ?fid=1034:c083e10c606f754488ec2164a76ec138","used":true,"who":"lxxself"},{"_id":"5a1cbc6f421aa90fef20356c","createdAt":"2017-11-28T09:31:27.148Z","desc":"看得我感动坏了\u2026\u2026赶快抽根烟冷静冷静！","publishedAt":"2018-01-04T13:45:57.211Z","source":"chrome","type":"休息视频","url":"https://weibo.com/tv/v/FrYj4jDtq?fid=1034:43e698f0f0a30d084f5f95bb655ffd33","used":true,"who":"lxxself"},{"_id":"59f74276421aa90fe72535dc","createdAt":"2017-10-30T23:17:10.916Z","desc":"黑色幽默创意短片 《This Is It》","publishedAt":"2018-01-02T08:43:32.216Z","source":"chrome","type":"休息视频","url":"http://www.miaopai.com/show/-m4Fiv6Xb4zEq-zEDGYbsrJ9VPY7mQ62iGfoPQ__.htm","used":true,"who":"lxxself"},{"_id":"5a3b11f1421aa90fe50c029a","createdAt":"2017-12-21T09:44:17.859Z","desc":"耳听为虚，眼见也未必为实，转发此片，与君共勉。","publishedAt":"2017-12-27T12:13:22.418Z","source":"chrome","type":"休息视频","url":"https://www.miaopai.com/show/B1alOrneHv2MdRAOyPd04EuDikyZMG1Kh~1i0Q__.htm","used":true,"who":"lxxself"}]
     */

    private boolean error;
    private List<ResultsBean> results;

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
         * _id : 58ae6af7421aa957f9dd6dc3
         * createdAt : 2017-02-23T12:54:15.286Z
         * desc : 我媽要我告訴你
         * publishedAt : 2018-03-12T08:44:50.326Z
         * source : chrome
         * type : 休息视频
         * url : https://v.qq.com/x/page/m0377ib544o.html?start=1
         * used : true
         * who : lxxself
         */

        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;
        private List<String> images;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
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

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
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
