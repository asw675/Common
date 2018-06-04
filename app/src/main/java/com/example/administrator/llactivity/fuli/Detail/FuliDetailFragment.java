package com.example.administrator.llactivity.fuli.Detail;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.administrator.llactivity.R;
import com.example.administrator.llactivity.fuli.SDFileUtil;

/**
 * Created by Administrator on 2018/5/28.
 */

public class FuliDetailFragment extends Fragment{

    private ImageView mImageView;
    private static final String URL="url";

    public static FuliDetailFragment newInstance(String url) {

        Bundle args = new Bundle();
        args.putString(URL,url);

        FuliDetailFragment fragment = new FuliDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        View v=inflater.inflate(R.layout.meizi_detail,container,false);
        mImageView=(ImageView)v.findViewById(R.id.meizi_detail);
        final String url= getArguments().getString(URL);
        Glide.with(getActivity()).load(url).asBitmap().into(mImageView);

        mImageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(final View v) {


            new saveThread(v).start();


            return true;
            }

        });
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
        return v;

    }

    Handler handler = new Handler()
    {
        public void handleMessage(android.os.Message msg) {
            if(msg.what==0x123)
            {
                Toast.makeText(getActivity(),"图片已保存",Toast.LENGTH_SHORT).show();
            }
        };
    };

    class saveThread extends Thread
    {
        View v;
        saveThread(View view){
            v=view;
        }
        @Override
        public void run() {
            //延迟两秒更新

             SDFileUtil sdFileUtil=new SDFileUtil(getActivity());
             sdFileUtil.SaveBitmapFromView(v);
            handler.sendEmptyMessage(0x123);
        }
    }
}
