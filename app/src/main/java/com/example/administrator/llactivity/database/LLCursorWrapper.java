package com.example.administrator.llactivity.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.administrator.llactivity.LL;

import java.util.UUID;
/**
 * Created by Administrator on 2018/4/14.
 */
public class LLCursorWrapper extends CursorWrapper {
    /**
     * Creates a cursor wrapper.
     *
     * @param cursor The underlying cursor to wrap.
     */
    public LLCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public LL getLL(){
        String uuidString=getString(getColumnIndex(LLDbSchema.LLTable.Cols.UUID));
        String image=getString(getColumnIndex(LLDbSchema.LLTable.Cols.image));
        String destext=getString(getColumnIndex(LLDbSchema.LLTable.Cols.Destext));
        String course=getString(getColumnIndex(LLDbSchema.LLTable.Cols.course));

       LL ll = new LL(UUID.fromString(uuidString));
        ll.setImage(image);
        ll.setDestext(destext);
        ll.setCourse(course);


        return ll;
    }
}
