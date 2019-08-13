package com.example.administrator.Adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.Model.MainRecommend;
import com.example.administrator.Model.Recommend;
import com.example.administrator.llactivity.R;

import java.util.ArrayList;
import java.util.List;

public class RecommendMainAdapter extends RecyclerView.Adapter<RecommendMainAdapter.ViewHolder> {

    public Context mContext;
    private List<MainRecommend> mList;
    private RecommendAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    public RecommendMainAdapter(Context context,List<MainRecommend> list){
        this.mContext=context;
        this.mList=new ArrayList<>(list);
    }

    @Override
    public RecommendMainAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(mContext).inflate(R.layout.item_recommend,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecommendMainAdapter.ViewHolder holder, int position) {
        adapter=new RecommendAdapter(mContext,mList.get(position).getRecommends());
        layoutManager=new GridLayoutManager(mContext,3);
        holder.rvRecommend.setAdapter(adapter);
        holder.rvRecommend.setLayoutManager(layoutManager);
        holder.tvTitle.setText(mList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RecyclerView rvRecommend;
        TextView tvTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            rvRecommend=(RecyclerView)itemView.findViewById(R.id.rv_recommend);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_recommend_title);

        }
    }
}
