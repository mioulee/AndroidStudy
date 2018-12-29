package com.yuanjin.androidstudy.UI.calendarview2_hotel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.yuanjin.androidstudy.R;

import java.util.List;

public class CalendarActivity extends AppCompatActivity {

    private DayPickerView dayPickerView;
    private DayPickerView.DataModel mDataModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        dayPickerView = (DayPickerView) findViewById(R.id.dpv_calendar);

        DayPickerView.DataModel dataModel = new DayPickerView.DataModel();
        dataModel.yearStart = 2016;
        dataModel.monthStart = 6;
        dataModel.monthCount = 16;
        dataModel.defTag = "￥100";
        dataModel.leastDaysNum = 2;
        dataModel.mostDaysNum = 100;

        dayPickerView.setParameter(dataModel, new DatePickerController() {
            @Override
            public void onDayOfMonthSelected(SimpleMonthAdapter.CalendarDay calendarDay) {
                Toast.makeText(CalendarActivity.this, "onDayOfMonthSelected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDateRangeSelected(List<SimpleMonthAdapter.CalendarDay> selectedDays) {
                Toast.makeText(CalendarActivity.this, "onDateRangeSelected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void alertSelectedFail(FailEven even) {
                Toast.makeText(CalendarActivity.this, "alertSelectedFail", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
