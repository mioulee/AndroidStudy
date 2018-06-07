package com.yuanjin.androidstudy.UI.calendarview3.listener;

import android.view.View;

import com.yuanjin.androidstudy.UI.calendarview3.bean.DateBean;


/**
 * 日期点击接口
 */
public interface OnSingleChooseListener {
    /**
     * @param view
     * @param date
     */
    void onSingleChoose(View view, DateBean date);
}
