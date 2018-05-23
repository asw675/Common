package com.example.administrator.llactivity.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.administrator.llactivity.LL;
import com.example.administrator.llactivity.R;
import com.example.administrator.llactivity.database.LLDbSchema.LLTable;


/**
 * Created by Administrator on 2018/4/14.
 */
public class LLBaseHelper extends SQLiteOpenHelper {
    private static final int VA=1;
    private static final String DATABASE_NAME = "LLBase.db";

    public LLBaseHelper(Context context) {
        super(context,DATABASE_NAME, null, VA);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + LLTable.NAME + "(" +
                " _id integer primary key autoincrement, " +
                LLTable.Cols.UUID +","+
                LLTable.Cols.image+","+
                LLTable.Cols.Destext+","+
                LLTable.Cols.course+
                ")");
        Integer[] mThumbIds ={R.drawable.j2,R.drawable.j2,R.drawable.j2,R.drawable.j2,R.drawable.j2,R.drawable.j2,R.drawable.j2,R.drawable.j2,R.drawable.j2};
        String[] mCourses={"语文","数学","英语","物理","化学","生物","政治","历史","地理"};
        for(int i=0;i<mThumbIds.length;i++){
        LL l=new LL();
        db.execSQL("insert into "+LLTable.NAME+"("+LLTable.Cols.UUID+","+LLTable.Cols.image+","+LLTable.Cols.course+
                ")values('"+l.getId().toString()+"','"+mThumbIds[i].toString()+"','"+mCourses[i].toString()+"')");}
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
