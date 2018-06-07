package com.yuanjin.androidstudy.UI.calendar;

import android.content.Context;

import com.yuanjin.androidstudy.R;
import com.yuanjin.androidstudy.baseadapter.CommonAdapter;
import com.yuanjin.androidstudy.baseadapter.ViewHolder;

import java.util.List;

/**
 * Created by leeyu on 2018/6/6.
 */

public class CalendarAdapter extends CommonAdapter {
    public CalendarAdapter(Context context,int layoutId,List<Object> datas) {
        super(context,layoutId,datas);
    }
    @Override
    protected void convert(ViewHolder holder, Object o, int position) {
        MoreSelectCalendar calendar = holder.getView(R.id.dd);
        for (int i = 0; i < position; i++) {
            calendar.changeMonth(true);
        }
        calendar.setBaseBlock(new MoreSelectBlock());
        holder.setText(R.id.tv,calendar.getCalendarTitle());
    }
}
