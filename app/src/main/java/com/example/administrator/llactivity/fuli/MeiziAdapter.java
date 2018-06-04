package com.example.administrator.llactivity.fuli;

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

    private FuliActivity mContext;

    private ArrayList<FuliRealm> meizis = new ArrayList<>();

    private OnItemClickListener mOnItemClickListener = null;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;}

    public static interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public MeiziAdapter(ArrayList<FuliRealm> Meizis,FuliActivity context){
        this.meizis=Meizis;
        this.mContext=context;
    }

    class viewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView mImageView;
        CardView cardView;
        public viewHolder(View itemView){
            super(itemView);
            cardView=(CardView) itemView;
            mImageView=(ImageView)itemView.findViewById(R.id.meizi);
        }

        @Override
        public void onClick(View v) {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(v, getLayoutPosition());
            }
        }
    }
    @Override
    public MeiziAdapter.viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.meizi_item,
                parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MeiziAdapter.viewHolder holder, int position) {
        FuliRealm info = meizis.get(position);
        Glide.with(mContext).load(info.getUrl()).asBitmap().placeholder(R.drawable.button1).into(holder.mImageView);
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i=new Intent(mContext, FuliDetailActivity.class);
//                FuliRealm info = meizis.get(holder.getAdapterPosition());
////                i.putExtra("url",info.getUrl());
////                mContext.startActivity(i);
//                FuliDetailActivity.launch(mContext,v.findViewById(R.id.meizi_detail),info.getUrl());
//            }
//        });
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
