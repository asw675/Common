package com.example.administrator.llactivity.fuli;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Administrator on 2018/6/1.
 */

public class RecyclerViewItemTouchListener  extends RecyclerView.SimpleOnItemTouchListener{
    public static interface OnItemClickListener {
        void onItemClick(View view);
        void onItemLongClick(View view);
    }
    private OnItemClickListener mClickListener;
    private GestureDetectorCompat mGestureDetector;

    public RecyclerViewItemTouchListener(final RecyclerView recyclerView,
                                         OnItemClickListener listener) {
        this.mClickListener = listener;
        mGestureDetector = new GestureDetectorCompat(recyclerView.getContext(),
                new GestureDetector.SimpleOnGestureListener() {
                    @Override
                    public boolean onSingleTapUp(MotionEvent e) {
                        View childView = recyclerView.findChildViewUnder(e.getX(), e.getY());
                        if (childView != null && mClickListener != null) {
                            mClickListener.onItemClick(childView);
                        }
                        return true;
                    }

                    @Override
                    public void onLongPress(MotionEvent e) {
                        View childView = recyclerView.findChildViewUnder(e.getX(), e.getY());
                        if (childView != null && mClickListener != null) {
                            mClickListener.onItemLongClick(childView);
                        }
                    }
                });
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        mGestureDetector.onTouchEvent(e);
        return false;
    }
}


