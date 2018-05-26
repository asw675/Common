package com.example.administrator.llactivity;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Administrator on 2018/5/25.
 */

public class LLApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmConfiguration config=new RealmConfiguration.Builder()
                .name("meizi.realm")
                .inMemory()
                .build();
    }
}
