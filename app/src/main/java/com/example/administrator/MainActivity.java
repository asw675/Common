package com.example.administrator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.Fragment.MeFragment;
import com.example.administrator.Fragment.RecommendFragment;
import com.example.administrator.Fragment.TypeFragment;
import com.example.administrator.llactivity.R;

public class MainActivity extends AppCompatActivity {

    private ViewPager vpMain;
    private TabLayout tabMain;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    void initView(){
        vpMain = (ViewPager) findViewById(R.id.viewpager_main);
        tabMain = (TabLayout) findViewById(R.id.tab_bottom);

        vpMain.setAdapter(new PageAdapter(getSupportFragmentManager()));
        tabMain.setupWithViewPager(vpMain);
    }

    public class PageAdapter extends FragmentPagerAdapter{

        private String[] mTitles = new String[]{"首页", "分类", "我的"};

        public PageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 1) {
                return new TypeFragment();
            } else if (position == 2) {
                return new MeFragment();
            }
            return new RecommendFragment();
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }
    }
}
