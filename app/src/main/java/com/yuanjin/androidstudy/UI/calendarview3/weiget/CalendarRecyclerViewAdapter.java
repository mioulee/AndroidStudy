package com.yuanjin.androidstudy.UI.calendarview3.weiget;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.yuanjin.androidstudy.R;
import com.yuanjin.androidstudy.UI.calendarview3.bean.AttrsBean;
import com.yuanjin.androidstudy.UI.calendarview3.listener.CalendarViewAdapter;
import com.yuanjin.androidstudy.UI.calendarview3.utils.CalendarUtil;
import com.yuanjin.androidstudy.UI.calendarview3.utils.SolarUtil;
import com.yuanjin.androidstudy.baseadapter.CommonAdapter;
import com.yuanjin.androidstudy.baseadapter.ViewHolder;

import java.util.List;

/**
 * Created by leeyu on 2018/6/7.
 */

public class CalendarRecyclerViewAdapter extends CommonAdapter {

    private AttrsBean mAttrsBean;
    private int item_layout;
    private CalendarViewAdapter mCalendarViewAdapter;

    public CalendarRecyclerViewAdapter(Context context, int layoutId, List<Object> list) {
        super(context,layoutId,list);
    }
    @Override
    protected void convert(ViewHolder holder, Object o, int position) {
        MonthView view = holder.getView(R.id.dd);
        //根据position计算对应年、月
        int[] date = CalendarUtil.positionToDate(position, mAttrsBean.getStartDate()[0], mAttrsBean.getStartDate()[1]);
        view.setAttrsBean(mAttrsBean);
        view.setOnCalendarViewAdapter(item_layout, mCalendarViewAdapter);
        view.setDateList(CalendarUtil.getMonthDate(date[0], date[1], mAttrsBean.getSpecifyMap()), SolarUtil.getMonthDays(date[0], date[1]));
    }

    public void setAttrsBean(AttrsBean attrsBean) {
        mAttrsBean = attrsBean;
    }

    public void setOnCalendarViewAdapter(int item_layout, CalendarViewAdapter calendarViewAdapter) {
        this.item_layout = item_layout;
        mCalendarViewAdapter = calendarViewAdapter;
    }
}
