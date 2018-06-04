package com.example.administrator.llactivity.fuli;

import io.realm.RealmConfiguration;

/**
 * Created by Administrator on 2018/5/29.
 */

public class bdUtil {

    public static RealmConfiguration getConfigutration(){

        RealmConfiguration config = new RealmConfiguration.Builder()
                .name("meizi.realm")
                .inMemory()
                .build();
        return config;
    }

}
