package com.example.administrator.Model;

import java.util.List;

public class MainRecommend {
    private String title;
    private List<Recommend> recommends;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Recommend> getRecommends() {
        return recommends;
    }

    public void setRecommends(List<Recommend> recommends) {
        this.recommends = recommends;
    }
}
