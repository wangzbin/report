package com.report.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtil {
    /**
     * 日期转时间戳
     * @param date
     * @return
     */
    public static Integer transForMilliSecond(Date date){
        if(date==null) return null;
        return (int)(date.getTime()/1000);
    }

    /**
     * 时间戳转日期
     * @param ms
     * @return
     */
    public static Date transForDate3(Integer ms){
        if(ms==null){
            ms=0;
        }
        long msl=(long)ms*1000;
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date temp=null;
        if(ms!=null){
            try {
                String str=sdf.format(msl);
                temp=sdf.parse(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return temp;
    }

    public static String transForDate1(Integer ms){
        String str = "";
        if(ms!=null){
            long msl=(long)ms*1000;
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            if(ms!=null){
                try {
                    str=sdf.format(msl);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println(transForMilliSecond(new Date()));
        System.out.println(transForDate1(1524585262));
    }

}
