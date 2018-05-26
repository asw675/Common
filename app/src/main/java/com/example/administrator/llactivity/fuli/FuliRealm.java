package com.example.administrator.llactivity.fuli;

import io.realm.RealmObject;

/**
 * Created by Administrator on 2018/5/26.
 */

public class FuliRealm extends RealmObject {
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
