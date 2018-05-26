package com.example.administrator.llactivity.fuli;

import java.util.List;

/**
 * Created by Administrator on 2018/5/24.
 */

public class Fuli{
    /**
     * _id : 5aff4645421aa95f55cab5e1
     * createdAt : 2018-05-10T00:00:00.0Z
     * desc : 2018-05-10
     * publishedAt : 2018-05-10T00:00:00.0Z
     * source : web
     * type : 福利
     * url : http://ww1.sinaimg.cn/large/0065oQSqly1freps07ubij30sg1dgwr7.jpg
     * used : true
     * who : lijinshanmx
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
    /**
     * error : false
     * results : [{"_id":"56de2b1b6776592b6192bf46","createdAt":"2016-03-08T09:30:03.578Z","desc":"3.8","publishedAt":"2016-03-08T12:55:59.161Z","source":"chrome","type":"福利","url":"http://ww3.sinaimg.cn/large/7a8aed7bjw1f1p77v97xpj20k00zkgpw.jpg","used":true,"who":"张涵宇"}]
     */

    private boolean error;
    private List<Fuli> results;

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

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<Fuli> getResults() {
        return results;
    }

    public void setResults(List<Fuli> results) {
        this.results = results;
    }
}
