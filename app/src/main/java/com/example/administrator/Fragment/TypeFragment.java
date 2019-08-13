package com.example.administrator.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.administrator.Adapter.TypeAdapter;
import com.example.administrator.Model.Type;
import com.example.administrator.llactivity.R;

import java.util.ArrayList;
import java.util.List;


public class TypeFragment extends Fragment {

    private RecyclerView rvType;
    private RecyclerView.LayoutManager manager;
    private TypeAdapter adapter;
    private List<Type> typeList = new ArrayList<>();
    private Boolean upType;

    public TypeFragment getInstance(Boolean type){
        Bundle bundle=new Bundle();
        bundle.putBoolean("type",type);
        TypeFragment fragment=new TypeFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        upType=getArguments().getBoolean("type");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v=LayoutInflater.from(getContext()).inflate(R.layout.fragment_type,container,false);
        initView(v);
        return v;
    }

    void initView(View v){
        rvType=(RecyclerView) v.findViewById(R.id.rv_type);
        manager = new GridLayoutManager(getContext(),3);

        for (int i=0;i<20;i++){
            Type type=new Type();
            type.setUpType(upType);
            type.setType("收缩");
            typeList.add(type);
        }

        adapter = new TypeAdapter(getContext(),typeList);
        rvType.setAdapter(adapter);
        rvType.setLayoutManager(manager);
        rvType.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
    }
}
