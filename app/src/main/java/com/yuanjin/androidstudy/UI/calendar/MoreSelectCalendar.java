package com.yuanjin.androidstudy.UI.calendar;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;

import com.yuanjin.androidstudy.UI.calendar.base.BaseBlock;
import com.yuanjin.androidstudy.UI.calendar.base.BaseCalendar;
import com.yuanjin.androidstudy.UI.calendar.base.Dd1;

import java.util.ArrayList;

/**
 * Created by yujinzhao on 17/2/7.
 */

public class MoreSelectCalendar extends BaseCalendar {
    String TAG = "MoreSelectCalendar";
    ArrayList<Dd1> selectDd1s = new ArrayList<>();

    public MoreSelectCalendar(Context context) {
        super(context);
    }

    public MoreSelectCalendar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MoreSelectCalendar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private long mDownTime;//按下时间
    private boolean isAddMode;

    /**
     * 单选模式的点击
     *
     * @param SelectDd1
     */
    @Override
    public void onClickListener(Dd1 SelectDd1) {
        Log.e(TAG, "onClickListener: "+SelectDd1.d);
        selectDd1s.add(SelectDd1);
        invalidate();
    }

    @Override
    public void onMoveClickListener(long downTime, Dd1 firstDd1, Dd1 selectDd1) {

        if (mDownTime == 0) {//初始化Tag
            mDownTime = downTime;
        }

        if (mDownTime == downTime) {//同一次按下的操作
        } else {//非同一次按下操作
            Log.e("yjz", "非同一次按下操作");
            isAddMode = true;
            mDownTime = downTime;
            for (int i = 0; i < selectDd1s.size(); i++) {
                if (firstDd1.isseclet(selectDd1s.get(i))) {//如果选择的第一个在集合里存在
                    isAddMode = false;
                    break;
                }
            }
        }
        if (selectDd1.isukow) {//如果点击了日历外退出
            return;
        }

        if (isAddMode) {//添加模式
            addDd1(selectDd1);
        } else {
            deleteDd1(selectDd1);
        }
    }

    /**
     * 添加
     *
     * @param selectDd1
     */
    public void addDd1(Dd1 selectDd1) {
        boolean isHave = false;
        for (int i = 0; i < selectDd1s.size(); i++) {
            if (selectDd1.isseclet(selectDd1s.get(i))) {
                isHave = true;
                break;
            }
        }
        if (!isHave) {
            selectDd1s.add(selectDd1);
            invalidate();
        }
    }

    public void deleteDd1(Dd1 selectDd1) {
        boolean isHave = false;
        for (int i = 0; i < selectDd1s.size(); i++) {
            if (selectDd1.isseclet(selectDd1s.get(i))) {
                isHave = true;
                selectDd1s.remove(selectDd1s.get(i));
                break;
            }
        }
        if (isHave) {
            invalidate();
        }
    }

    /**
     * 每次绘画block前调用的方法，
     * 传一个block进来
     * 在这里设置选中的日期集合
     * @param baseBlock
     */
    @Override
    public void customDrawBlock(BaseBlock baseBlock) {
        MoreSelectBlock block = (MoreSelectBlock) baseBlock;
        block.selectDa1s = selectDd1s;
    }
}
