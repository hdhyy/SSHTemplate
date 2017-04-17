package com.hit.j2ee.sshTemplate.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 赵阳 on 2016/5/29.
 */
public class DateFormatUtil {

    //转换时间格式
    public static String setTimeFormat(long time){
        String timeString;
        int s = (int)time/1000;
        int h = s/3600;
        int m = s / 60 - h * 60;
        s = s - (h * 3600 + m * 60);
        timeString = String.valueOf(h)+":"+ String.valueOf(m)+":"+ String.valueOf(s);
        return timeString;
    }

    public static String hourTimeFormat(long time) {
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date(time);
        String result = df.format(date);
        return result;
    }

    public static String fullTimeFormat(long time){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(time);
        String result = df.format(date);
        return result;
    }

    public static String yearTimeFormat(long time){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(time);
        String result = df.format(date);
        return result;
    }
}
