package com.example.administrator.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.administrator.Adapter.WorksListAdatper;
import com.example.administrator.Model.Work;
import com.example.administrator.llactivity.R;

import java.util.ArrayList;
import java.util.List;

public class WorksListActivity extends AppCompatActivity {

    private RecyclerView worksList;
    private LinearLayoutManager worksListManager;
    private WorksListAdatper worksListAdatper;
    private List<Work> works = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_works_list);

        initView();
        initData();

    }
    void initView(){
        worksList = findViewById(R.id.rv_works_list);
        worksListManager = new LinearLayoutManager(this);
        worksListAdatper = new WorksListAdatper(this,works);
        worksList.setLayoutManager(worksListManager);
        worksList.setAdapter(worksListAdatper);
    }

    void initData(){
        for (int i=0;i<30;i++){
            Work work = new Work();
            work.setTime("2020-02-02");
            work.setTitle("床前明月光");
            works.add(work);
        }
        worksListAdatper.notifyDataSetChanged();
    }
}
