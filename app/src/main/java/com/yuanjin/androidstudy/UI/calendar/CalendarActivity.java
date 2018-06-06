package com.yuanjin.androidstudy.UI.calendar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.yuanjin.androidstudy.R;

import java.util.ArrayList;
import java.util.List;

public class CalendarActivity extends AppCompatActivity {

    private MoreSelectCalendar dld;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        RecyclerView recyclerView = findViewById(R.id.list);
        List<Object> list = new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        recyclerView.setAdapter(new CalendarAdapter(this,R.layout.item_calendar,list));
    }
}
