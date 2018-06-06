package com.yuanjin.androidstudy.UI.rollingnumber;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;

/**
 * Created by leeyu on 2018/6/1.
 */

@SuppressLint("AppCompatCustomView")
public class RollingNumberView extends TextView {
    public RollingNumberView(Context context) {
        super(context);
    }

    public RollingNumberView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RollingNumberView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void playNumAnim(float num) {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(num);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                RollingNumberView.this.setText(animation.getAnimatedFraction()+"");
            }
        });
        valueAnimator.setInterpolator(new DecelerateInterpolator());
    }
}
