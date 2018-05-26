package com.example.administrator.llactivity.fuli;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.llactivity.R;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2018/5/24.
 */

public class FuliActivity extends AppCompatActivity{

    private ImageView mImageView;
    private RecyclerView mRecyclerView;
    private StaggeredGridLayoutManager mLayoutManager;
//    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<FuliRealm> meizis = new ArrayList<>();
    private MeiziAdapter mAdapter;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private Realm mRealm;
    private int check;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }//去除顶部状态栏
        check=0;
        setContentView(R.layout.fuli_activity);
        initView();//初始化视图
    }


    void initView(){
        mRecyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        int spanCount = 2;//设置显示行为2行
        mLayoutManager = new StaggeredGridLayoutManager(
                spanCount,
                StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);//防止上拉时ITEM跳动
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                mLayoutManager.invalidateSpanAssignments();//去除顶部空白
            }
        });
        mSwipeRefreshLayout=(SwipeRefreshLayout)findViewById(R.id.swipe_refresh);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorAccent);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                request();
                mAdapter.notifyDataSetChanged();
                mSwipeRefreshLayout.setRefreshing(false);
                initMeizi();
            }
        });

        mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener(){
            //用来标记是否正在向最后一个滑动，既是否向下滑动
            boolean isSlidingToLast = false;

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                StaggeredGridLayoutManager manager = (StaggeredGridLayoutManager) recyclerView.getLayoutManager();
                // 当不滚动时
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    //获取最后一个完全显示的ItemPosition
                    int[] lastVisiblePositions = manager.findLastVisibleItemPositions(new int[manager.getSpanCount()]);
                    int lastVisiblePos = getMaxElem(lastVisiblePositions);
                    int totalItemCount = manager.getItemCount();

                    // 判断是否滚动到底部
                    if (lastVisiblePos == (totalItemCount -1) && isSlidingToLast) {
                        //加载更多功能的代码
                        request();
                        initMeizi();
                        mAdapter.notifyDataSetChanged();

                    }
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                //dx用来判断横向滑动方向，dy用来判断纵向滑动方向
                if(dy > 0){
                    //大于0表示，正在向下滚动
                    isSlidingToLast = true;
                }else{
                    //小于等于0 表示停止或向上滚动
                    isSlidingToLast = false;
                }

            }
        });
        request();//图片请求
        if(check!=0){
        initMeizi();}
//        mAdapter=new MeiziAdapter(meizis);
//        mRecyclerView.setAdapter(mAdapter);

    }

    private int getMaxElem(int[] arr) {
        int size = arr.length;
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            if (arr[i]>maxVal)
                maxVal = arr[i];
        }
        return maxVal;
    }

    void request(){

        mRealm=Realm.getDefaultInstance();

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://gank.io/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PostFuli_Interface request=retrofit.create(PostFuli_Interface.class);

        Call<Fuli> call=request.getFuli();

        call.enqueue(new Callback<Fuli>() {
            @Override
            public void onResponse(Call<Fuli> call, Response<Fuli> response) {
                for(int i=0;i<20;i++) {
                    mRealm.beginTransaction();
                    FuliRealm fuli = mRealm.createObject(FuliRealm.class);
                    fuli.setUrl(response.body().getResults().get(i).getUrl());
                    mRealm.commitTransaction();
                }
                while(check==0){
                    initMeizi();
                    mAdapter=new MeiziAdapter(meizis);
                    mRecyclerView.setAdapter(mAdapter);
                }

//                for(int i=0;i<20;i++){
//                    meizis.add(response.body().getResults().get(i));
//                }
//                while(check!=1){
//                    mAdapter=new MeiziAdapter(meizis);
//                    mRecyclerView.setAdapter(mAdapter);
//                    check=1;
//                }

//                Glide.with(FuliActivity.this).load(response.body().getResults().get(0).getUrl()).into(mImageView);
                System.out.println(response.body().getResults().get(0).get_id());
            }

            @Override
            public void onFailure(Call<Fuli> call, Throwable t) {
                System.out.println("请求失败");
                System.out.println(t.getMessage());
            }
        });
    }



    void initMeizi(){
        RealmResults<FuliRealm> fulis=mRealm.where(FuliRealm.class).findAll();
        for(int i=0;i<20;i++){
                    meizis.add(fulis.get(check));
            check++;
                }
    }



    @Override
    protected void onDestroy() {
        mRealm.close();
        super.onDestroy();
    }

}
