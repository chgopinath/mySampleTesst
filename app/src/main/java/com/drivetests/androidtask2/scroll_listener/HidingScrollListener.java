package com.drivetests.androidtask2.scroll_listener;


import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public abstract class HidingScrollListener extends RecyclerView.OnScrollListener {

    private static final int HIDE_THRESHOLD = 20;

    private int mScrolledDistance = 0;
    private boolean mControlsVisible = true;


    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        int firstVisibleItem = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();

        if (firstVisibleItem == 0) {
            if(!mControlsVisible) {
                onShow();
                mControlsVisible = true;
            }
        } else {
            if (mScrolledDistance > HIDE_THRESHOLD && mControlsVisible) {
                onHide();
                mControlsVisible = false;
                mScrolledDistance = 0;
            } else if (mScrolledDistance < -HIDE_THRESHOLD && !mControlsVisible) {
                onShow();
                mControlsVisible = true;
                mScrolledDistance = 0;
            }
        }
        if((mControlsVisible && dy>0) || (!mControlsVisible && dy<0)) {
            mScrolledDistance += dy;
        }
    }

    public abstract void onHide();
    public abstract void onShow();
}