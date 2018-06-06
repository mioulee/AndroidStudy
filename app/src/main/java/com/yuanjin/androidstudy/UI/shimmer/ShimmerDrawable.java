package com.yuanjin.androidstudy.UI.shimmer;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by leeyu on 2018/5/30.
 */

public class ShimmerDrawable extends Drawable {
    private Paint mShimmerPaint = new Paint();
    private RectF mRectF = new RectF();
    private ValueAnimator mValueAnimator;
    private float animateValue;
    private  int[] colors = new int[4];
    int highlightColor = Color.RED;
    int baseColor = 0x4cffffff;
    float intensity = 0f;
    float dropoff = 0.5f;
    final float[] positions = new float[4];

    public ShimmerDrawable() {
        colors[0] = baseColor;
        colors[1] = highlightColor;
        colors[2] = highlightColor;
        colors[3] = baseColor;
        positions[0] = Math.max((1f - intensity - dropoff) / 2f, 0f);
        positions[1] = Math.max((1f - intensity - 0.001f) / 2f, 0f);
        positions[2] = Math.min((1f + intensity + 0.001f) / 2f, 1f);
        positions[3] = Math.min((1f + intensity + dropoff) / 2f, 1f);
        mShimmerPaint.setAntiAlias(true);
        mShimmerPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        updateShader();
        updateValueAnimator();
        invalidateSelf();
    }

    private void updateValueAnimator() {
        mValueAnimator = ValueAnimator.ofFloat(0f,1.0f);
        mValueAnimator.setRepeatCount(6);
        mValueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        mValueAnimator.setDuration(5000);
        mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                animateValue = animation.getAnimatedFraction();
                invalidateSelf();
            }
        });

    }

    private void updateShader() {
        Rect bounds = new Rect();
        int boundswidth = bounds.width();
        int boundsheight = bounds.height();

        Shader shader = new LinearGradient(0,0,boundswidth,0,colors,positions, Shader.TileMode.CLAMP);
        mShimmerPaint.setShader(shader);
        startShimmer();
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        Rect bounds = getBounds();
        float width = bounds.width();
        float height = bounds.height();
        float dx;
        float dy;
        dx = offset(-height, height, animateValue);
        dy = 0;

        int savecount = canvas.save();
        canvas.translate(dx, dy);
        canvas.rotate(20f, width / 2f, height / 2f);
        canvas.drawRect(mRectF, mShimmerPaint);
        canvas.restoreToCount(savecount);
    }

    @Override
    protected void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);
        int width = bounds.width();
        int height = bounds.height();
        mRectF.set(2*-width,2*-height,4*width,4*height);
        updateShader();
    }

    /** Starts the shimmer animation. */
    public void startShimmer() {
        if (mValueAnimator != null && !isShimmerStarted() && getCallback() != null) {
            mValueAnimator.start();
        }
    }

    /** Stops the shimmer animation. */
    public void stopShimmer() {
        if (mValueAnimator != null && isShimmerStarted()) {
            mValueAnimator.cancel();
        }
    }

    /** Return whether the shimmer animation has been started. */
    public boolean isShimmerStarted() {
        return mValueAnimator != null && mValueAnimator.isStarted();
    }

    private float offset(float start, float end, float percent) {
        return start + (end - start) * percent;
    }

    @Override
    public void setAlpha(int alpha) {

    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {

    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }
}
