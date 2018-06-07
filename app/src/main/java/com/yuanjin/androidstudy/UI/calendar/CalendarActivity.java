package com.yuanjin.androidstudy.UI.calendar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.maning.calendarlibrary.MNCalendar;
import com.maning.calendarlibrary.MNCalendarVertical;
import com.maning.calendarlibrary.model.MNCalendarConfig;
import com.maning.calendarlibrary.model.MNCalendarVerticalConfig;
import com.yuanjin.androidstudy.R;
import com.yuanjin.androidstudy.UI.calendarview3.weiget.CalendarView_Horizontal;
import com.yuanjin.androidstudy.UI.calendarview3.weiget.CalendarView_Vertical;

public class CalendarActivity extends AppCompatActivity {

    private MoreSelectCalendar dld;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
//        CalendarView_Vertical calendar = findViewById(R.id.calendar);
//        /**
//         *  自定义设置相关
//         */
//
//        MNCalendarVerticalConfig mnCalendarVerticalConfig = new MNCalendarVerticalConfig.Builder()
//                .setMnCalendar_showWeek(true)                   //是否显示星期栏
//                .setMnCalendar_showLunar(true)                  //是否显示阴历
//                .setMnCalendar_colorWeek("#B07219")             //星期栏的颜色
//                .setMnCalendar_titleFormat("yyyy-MM")           //每个月的标题样式
//                .setMnCalendar_colorTitle("#FF0000")            //每个月标题的颜色
//                .setMnCalendar_colorSolar("#ff0fc7")            //阳历的颜色
//                .setMnCalendar_colorLunar("#00ff00")            //阴历的颜色
//                .setMnCalendar_colorBeforeToday("#F1EDBD")      //今天之前的日期的颜色
//                .setMnCalendar_colorRangeBg("#9930C553")        //区间中间的背景颜色
//                .setMnCalendar_colorRangeText("#000000")        //区间文字的颜色
//                .setMnCalendar_colorStartAndEndBg("#258C3E")    //开始结束的背景颜色
//                .setMnCalendar_countMonth(12)
//                .setDate("2018-7-12")//显示多少月(默认6个月)
//                .build();
//        calendar.setConfig(mnCalendarVerticalConfig);

        CalendarView_Vertical calendarViewHorizontal = (CalendarView_Vertical) findViewById(R.id.calendar);
//日历init，年月日之间用点号隔开
        calendarViewHorizontal
                .setStartEndDate("2010.7", "2018.12")
                .setInitDate("2017.11")
                .setSingleDate("2017.12.12")
                .setDisableStartEndDate("2017.12.1","2017.12.22")
                .init();

//        RecyclerView recyclerView = findViewById(R.id.list);
//        List<Object> list = new ArrayList<>();
//        list.add("");
//        list.add("");
//        list.add("");
//        recyclerView.setAdapter(new CalendarAdapter(this,R.layout.item_calendar,list));
    }
}
