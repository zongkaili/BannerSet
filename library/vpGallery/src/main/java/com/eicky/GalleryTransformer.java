package com.eicky;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * @author zongkaili
 * scroll effect
 */
class GalleryTransformer implements ViewPager.PageTransformer {
    private static final float MIN_SCALE = 0.85f;
    private static final float MIN_ALPHA = 0.7f;

    @Override
    public void transformPage(View page, float position) {
        if (position >= -1 || position <= 1) {
            // Modify the default slide transition to shrink the page as well
            final float height = page.getHeight();
            final float width = page.getWidth();
            final float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
            final float vertMargin = height * (1 - scaleFactor) / 2;
            final float horzMargin = width * (1 - scaleFactor) / 2;

            // Center vertically
            page.setPivotY(0.5f * height);
            page.setPivotX(0.5f * width);

            if (position < 0) {
                page.setTranslationX(horzMargin - vertMargin / 2);
            } else {
                page.setTranslationX(-horzMargin + vertMargin / 2);
            }

            // Scale the page down (between MIN_SCALE and 1)
            page.setScaleX(scaleFactor);
            page.setScaleY(scaleFactor);

            // Fade the page relative to its size.
            page.setAlpha(MIN_ALPHA + (scaleFactor - MIN_SCALE) / (1 - MIN_SCALE) * (1 - MIN_ALPHA));
        }
    }
}
