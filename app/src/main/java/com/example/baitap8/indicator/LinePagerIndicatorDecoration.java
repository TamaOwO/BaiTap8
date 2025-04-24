package com.example.baitap8.indicator;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import com.example.baitap8.activity.RecycleViewSearch;

public class LinePagerIndicatorDecoration extends RecyclerView.ItemDecoration {
    private RecycleViewSearch recycleViewSearch;
    private final float DP;

    public LinePagerIndicatorDecoration(Context context) {
        this.DP = context.getResources().getDisplayMetrics().density;
    }
}

