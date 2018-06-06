package com.yuanjin.androidstudy.UI.shimmer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * Created by leeyu on 2018/5/30.
 * https://github.com/facebook/shimmer-android/blob/master/shimmer/src/main/java/com/facebook/shimmer/ShimmerFrameLayout.java
 */

public class ShimmerFrameLayout extends FrameLayout {
    private ShimmerDrawable mShimmerDrawable = new ShimmerDrawable();
    private final Paint mContentPaint = new Paint();
    public ShimmerFrameLayout(@NonNull Context context) {
        this(context,null);
    }

    public ShimmerFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ShimmerFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr,0);
    }

    public ShimmerFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context,attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        mShimmerDrawable.setCallback(this);
        setLayerType(LAYER_TYPE_HARDWARE, mContentPaint);
        startShimmer();
    }

    @Override
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        final int width = getWidth();
        final int height = getHeight();
        mShimmerDrawable.setBounds(0, 0, width, height);
    }

    @Override
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        mShimmerDrawable.draw(canvas);
    }

    /** Starts the shimmer animation. */
    public void startShimmer() {
        mShimmerDrawable.startShimmer();
    }

    /** Stops the shimmer animation. */
    public void stopShimmer() {
        mShimmerDrawable.stopShimmer();
    }

    /** Return whether the shimmer animation has been started. */
    public boolean isShimmerStarted() {
        return mShimmerDrawable.isShimmerStarted();
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopShimmer();
    }
}
