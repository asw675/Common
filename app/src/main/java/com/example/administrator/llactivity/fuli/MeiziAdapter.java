package com.example.administrator.llactivity.fuli;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.administrator.llactivity.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/5/25.
 */

public class MeiziAdapter extends RecyclerView.Adapter<MeiziAdapter.viewHolder>{

    private Context mContext;

    private ArrayList<FuliRealm> meizis = new ArrayList<>();

    public MeiziAdapter(ArrayList<FuliRealm> Meizis){this.meizis=Meizis;}

    static class viewHolder extends RecyclerView.ViewHolder{
        ImageView mImageView;
        CardView cardView;
        public viewHolder(View itemView){
            super(itemView);
            cardView=(CardView) itemView;
            mImageView=(ImageView)itemView.findViewById(R.id.meizi);
        }
    }


    @Override
    public MeiziAdapter.viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(mContext ==null){
            mContext=parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.meizi_item,
                parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(MeiziAdapter.viewHolder holder, int position) {
        FuliRealm info = meizis.get(position);
        Glide.with(mContext).load(info.getUrl()).asBitmap().placeholder(R.drawable.button1).into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return meizis.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }
}
