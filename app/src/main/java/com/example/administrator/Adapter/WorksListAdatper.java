package com.example.administrator.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.Model.Work;
import com.example.administrator.llactivity.R;

import java.util.List;

public class WorksListAdatper extends RecyclerView.Adapter<WorksListAdatper.ViewHolder> {

    private Context mContext;
    private List<Work> works;

    public WorksListAdatper(Context context,List<Work> works){
        this.mContext = context;
        this.works = works;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_works,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Work item = works.get(i);
        viewHolder.img.setImageResource(R.mipmap.jude);
        viewHolder.title.setText(item.getTitle());
        viewHolder.time.setText(item.getTime());
    }

    @Override
    public int getItemCount() {
        return works.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView title,time;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imageView);
            title = itemView.findViewById(R.id.work_title);
            time = itemView.findViewById(R.id.work_time);
        }
    }
}
