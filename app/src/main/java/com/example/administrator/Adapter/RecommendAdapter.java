package com.example.administrator.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.administrator.Model.Recommend;
import com.example.administrator.llactivity.R;


import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class RecommendAdapter extends RecyclerView.Adapter<RecommendAdapter.ViewHolder> {

    private Context mContext;
    private List<Recommend> mList;

    public RecommendAdapter(Context context,List<Recommend> list){
        this.mContext=context;
        this.mList=new ArrayList<>(list);
    }

    @Override
    public RecommendAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(mContext).inflate(R.layout.item_rv_main_photo,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecommendAdapter.ViewHolder holder, int position) {
        holder.ivCover.setImageResource(R.mipmap.jude);
        holder.tvAuthor.setText("憨憨");
        holder.tvTitle.setText("铁憨憨");
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivCover;
        TextView tvTitle,tvAuthor;
        public ViewHolder(View itemView) {
            super(itemView);
            ivCover = (ImageView) itemView.findViewById(R.id.cover);
            tvTitle = (TextView) itemView.findViewById(R.id.title);
            tvAuthor = (TextView) itemView.findViewById(R.id.author);
        }
    }
}
