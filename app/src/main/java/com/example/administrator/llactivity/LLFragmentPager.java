package com.example.administrator.llactivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2018/4/14.
 */
public class LLFragmentPager extends AppCompatActivity {
    private static final String LL_ID="hou.a!";

    private ViewPager mViewPager;
    private List<LL> mLL;
    private LLab mLLab;
    private TabLayout mTabLayout;
    private DrawerLayout mDrawerLayout;

    public static Intent newIntent(Context packageContext,UUID LLId){
        Intent intent = new Intent(packageContext,LLFragmentPager.class);
        intent.putExtra(LL_ID,LLId);
        return intent;
    }

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        setContentView(R.layout.activity_l_pager);
        mViewPager=(ViewPager)findViewById(R.id.L_view_pager);
        mTabLayout=(TabLayout)findViewById(R.id.tablayout);
        mTabLayout.setupWithViewPager(mViewPager);



        mLL=LLab.get(this).getLL();
        FragmentManager fragmentManager=getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                LL ll=mLL.get(position);
                return LLFragment.newInstance(ll.getId());
            }

            @Override
            public int getCount() {
               return mLL.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                LL ll=mLL.get(position);
                return ll.getCourse();
            }
        });


        UUID LLId = (UUID)getIntent().getSerializableExtra(LL_ID);

        for(int i=0;i<mLL.size();i++){
            if(mLL.get(i).getId().equals(LLId)){
                mViewPager.setCurrentItem(i);
                break;
            }
        }
    }

}
