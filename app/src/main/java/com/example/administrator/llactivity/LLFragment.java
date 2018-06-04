package com.example.administrator.llactivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.llactivity.english.englishActivity;
import com.example.administrator.llactivity.fuli.FuliActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2018/4/14.
 */
public class LLFragment extends Fragment{

    private static final String ABC_ID="hha";
    private Button mButton;
    private List<LL> mLL;
    private ViewPager mViewPager;
    private ArrayList<View> mList;
    private LLFragmentPager mAdapter;
    private LLab mLLab;
    private LLFragmentPager mLLFragmentPager;
    private LL ll;
    private DrawerLayout mDrawerLayout;

    public static LLFragment newInstance(UUID LLId) {

        Bundle args = new Bundle();
        args.putSerializable(ABC_ID,LLId);

        LLFragment fragment = new LLFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID LLId = (UUID) getArguments().getSerializable(ABC_ID);
        ll=mLLab.get(getActivity()).getLL(LLId);
    }

    @Override
    public void onPause() {
        super.onPause();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.l_main_fragment, container, false);
        mViewPager=(ViewPager) v.findViewById(R.id.L_view_pager);

        Toolbar toolbar = (Toolbar) v.findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.l_main_fragment);

        mButton=(Button)v.findViewById(R.id.button1);
        mButton.setText(ll.getCourse());

        switch (ll.getCourse()){
            case "福利":mButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i=new Intent(getActivity(),FuliActivity.class);
                    startActivity(i);
                }
            });break;
            case "翻译":mButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i=new Intent(getActivity(),englishActivity.class);
                    startActivity(i);
                }
            });break;

        }


        Typeface typeface=Typeface.createFromAsset(getActivity().getAssets(), "华文行楷.ttf");
        mButton.setTypeface(typeface);
        TextView mDT=(TextView)v.findViewById(R.id.textView);
        mDT.setText(ll.getDestext());
        String image=ll.getImage();
        v.setBackgroundResource(Integer.parseInt(image));

        return v;
    }

}
