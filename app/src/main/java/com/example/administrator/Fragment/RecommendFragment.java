package com.example.administrator.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.Adapter.RecommendAdapter;
import com.example.administrator.Adapter.RecommendMainAdapter;
import com.example.administrator.Model.MainRecommend;
import com.example.administrator.Model.Recommend;
import com.example.administrator.llactivity.R;

import java.util.ArrayList;
import java.util.List;

public class RecommendFragment extends Fragment {

    private RecyclerView rvMain;
    private RecyclerView.LayoutManager manager;
    private RecommendMainAdapter mainAdapter;

    private List<Recommend> mHotList = new ArrayList<>();
    private List<Recommend> mNewList = new ArrayList<>();
    private List<Recommend> mGirlList = new ArrayList<>();
    private List<MainRecommend> mMainList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.fragment_recommend, container, false);
        initView(v);
        return v;
    }

    void initView(View v) {
        rvMain = (RecyclerView) v.findViewById(R.id.rv_main_recommend);
        manager = new LinearLayoutManager(getContext());

        mHotList.clear();
        mNewList.clear();
        mGirlList.clear();

        //虚拟数据
        for (int i = 0; i < 6; i++) {
            Recommend recommend = new Recommend();
            mHotList.add(recommend);
            mNewList.add(recommend);
            mGirlList.add(recommend);
        }
        MainRecommend mainRecommend1 = new MainRecommend();
        MainRecommend mainRecommend2 = new MainRecommend();
        MainRecommend mainRecommend3 = new MainRecommend();
        mainRecommend1.setRecommends(mHotList);
        mainRecommend1.setTitle("啊啊啊啊啊啊啊啊啊啊");
        mainRecommend2.setRecommends(mNewList);
        mainRecommend2.setTitle("啵啵啵啵啵啵啵啵啵啵");
        mainRecommend3.setRecommends(mGirlList);
        mainRecommend3.setTitle("曾出现在出现在出现在");
        mMainList.add(mainRecommend1);
        mMainList.add(mainRecommend2);
        mMainList.add(mainRecommend3);

        mainAdapter = new RecommendMainAdapter(getContext(), mMainList);
        rvMain.setLayoutManager(manager);
        rvMain.setAdapter(mainAdapter);
    }

}
