package com.yuanjin.androidstudy.UI.calendar.base;

import java.util.Date;

public class Dd1 {
	/**
	 * 不在本月的日期
	 */
	public boolean isukow = true;
	/**
	 * moth
	 */
	public int m;
	/**
	 * year
	 */
	public int y;
	/**
	 * day
	 */
	public int d;
	int index;

	public Date date;

	/**
	 * 是否是同一日期
	 * @param dd
	 * @return
	 */
	public boolean isseclet(Dd1 dd) {
		if (this.m == dd.m && this.y == dd.y && this.d == dd.d) {
			return true;
		} else {
			return false;
		}
	}
}

