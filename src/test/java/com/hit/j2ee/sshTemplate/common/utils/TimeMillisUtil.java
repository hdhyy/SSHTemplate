package com.hit.j2ee.sshTemplate.common.utils;

/**
 * @ClassName: TimeMillisUtil
 * @ClassNameExplain: 类名说明
 * @Description: TODO(这里描述这个类的作用)
 * @author duhw
 * @date 2016年4月12日 上午8:26:21
 */
public class TimeMillisUtil {
	public static String getTimeMillisToStringHMS(Long time){
		String minuteZero = "0";
		String secondZero = "0";
		Long second = (time / 1000) % 60;
		if (second > 9) secondZero = "";
		Long minute = (time / 1000 / 60) % 60;
		if (minute > 9) minuteZero = "";
		Long hour = time / 1000 / 60 / 60;
		return hour+"时"+minuteZero+minute+"分"+secondZero+second+"秒";
	}
}
