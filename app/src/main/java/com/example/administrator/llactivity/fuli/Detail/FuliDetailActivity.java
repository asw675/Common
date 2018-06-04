package com.example.administrator.llactivity.fuli.Detail;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.llactivity.SingleFragmentActivity;
import com.example.administrator.llactivity.fuli.FuliActivity;

/**
 * Created by Administrator on 2018/5/28.
 */

public class FuliDetailActivity extends SingleFragmentActivity {

    private String url;
    public static final String EXTRA_IMAGE = "url";
    private ImageView mImageView;

    @Override
    protected Fragment createFragment(){
        Intent i=getIntent();
        Bundle bundle = i.getExtras();
        url=bundle.getString("url");
        return FuliDetailFragment.newInstance(url);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }//去除顶部状态栏
        super.onCreate(savedInstanceState);
    }

    public static void launch(FuliActivity activity, View transitionView, String url) {
        ActivityOptionsCompat options =
                ActivityOptionsCompat.makeSceneTransitionAnimation(
                        activity, transitionView, EXTRA_IMAGE);
        Intent intent = new Intent(activity, FuliDetailActivity.class);
        intent.putExtra(EXTRA_IMAGE, url);
        ActivityCompat.startActivity(activity, intent, options.toBundle());
    }


}
