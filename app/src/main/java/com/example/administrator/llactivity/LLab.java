package com.example.administrator.llactivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.administrator.llactivity.database.LLBaseHelper;
import com.example.administrator.llactivity.database.LLCursorWrapper;
import com.example.administrator.llactivity.database.LLDbSchema;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.example.administrator.llactivity.database.LLDbSchema.LLTable.Cols.UUID;
import static com.example.administrator.llactivity.database.LLDbSchema.LLTable.Cols.image;
import static com.example.administrator.llactivity.database.LLDbSchema.LLTable.NAME;

/**
 * Created by Administrator on 2018/4/14.
 */
public class LLab {
    private static LLab sLLab;
    private Context mContext;
    private SQLiteDatabase mDatabase;
    private List<LL> mll;

    public static LLab get(Context context){
        if(sLLab==null){
            sLLab=new LLab(context);
        }
        return sLLab;
    }
    private LLab(Context context){
        mContext=context.getApplicationContext();
        mDatabase=new LLBaseHelper(mContext).getWritableDatabase();
    }
    public List<LL> getLL(){
        List<LL> lls=new ArrayList<>();
        LLCursorWrapper cursor=queryLL(null,null);
        try{
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                lls.add(cursor.getLL());
                cursor.moveToNext();
            }
        }finally {
            cursor.close();
        }
        return lls;
    }
//    public void updateLL(LL ll){
//        String uuidString=ll.getId().toString();
//        ContentValues values=getContentValues(ll);
//        mDatabase.update(NAME,values, UUID+"=?",new String[]{uuidString});
//    }

    private LLCursorWrapper queryLL(String whereClause, String[] whereArgs){
        Cursor cursor=mDatabase.query(
                LLDbSchema.LLTable.NAME,null,whereClause,whereArgs,null,null,null
        );
        return new LLCursorWrapper(cursor);
    }

    private static ContentValues getContentValues(LL ll){
        ContentValues values=new ContentValues();
        values.put(UUID,ll.getId().toString());
        values.put(image,ll.getImage().toString());
        return values;
    }
    public LL getLL(UUID id) {

        LLCursorWrapper cursor = queryLL(LLDbSchema.LLTable.Cols.UUID + "=?", new String[]{id.toString()});
        try {
            if (cursor.getCount() == 0) {
                return null;
            }
            cursor.moveToFirst();
            return cursor.getLL();
        } finally {
            cursor.close();
        }
    }

    public void addLL(LL l){
        ContentValues values=getContentValues(l);
        mDatabase.insert(NAME,null,values);
    }

}
