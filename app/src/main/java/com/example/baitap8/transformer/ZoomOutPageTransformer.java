package com.example.baitap8.transformer;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.viewpager2.widget.ViewPager2;

public class ZoomOutPageTransformer implements ViewPager2.PageTransformer{
    private static final float MIN_SCALE = 0.85f;
    private static final float MIN_ALPHA = 0.5f;

    @Override
    public void transformPage(@NonNull View page, float position) {
        int pageWidth = page.getWidth();
        int pageHeight = page.getHeight();
        if (position < -1) {
            // This page is way off-screen to the left
            page.setAlpha(0f);
        } else if (position <= 1) {
            // Modify the default slide transition to shrink the page as well
            float scareFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
            float vertMargin = pageHeight * (1 - scareFactor) / 2;
            float horzMargin = pageWidth * (1 - scareFactor) / 2;
            if (position < 0) {
                page.setTranslationX(horzMargin - vertMargin / 2);
            } else {
                page.setTranslationX(-horzMargin + vertMargin / 2);
            }
            // Scale the page down (
            page.setScaleX(scareFactor);
            page.setScaleY(scareFactor);
            // Fade the page relative to its size.
            page.setAlpha(MIN_ALPHA + (scareFactor - MIN_SCALE) / (1 - MIN_SCALE) * (1 - MIN_ALPHA));
            page.setPivotX(pageWidth * 0.5f);
            page.setPivotY(pageHeight * 0.5f);
        } else {
            // This page is way off-screen to the right
            page.setAlpha(0f);
        }
    }
}
