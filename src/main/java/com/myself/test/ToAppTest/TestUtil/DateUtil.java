package com.myself.test.ToAppTest.TestUtil;/**
 * Created by Administrator on 2018-5-30.
 */

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @Project : pm-web
 * @Package Name : cn.pinming.common.utils
 * @company 杭州品茗信息技术有限公司
 * @Description:
 * @Author jade on 2018-5-30 15:06.
 */

public class DateUtil {
    /**
     * Timestamp转Date
     *
     * @param timestamp
     * @return
     */
    public static Date convertToTimestamp(Timestamp timestamp) {
        if (timestamp == null)
            return null;
        return new Date(timestamp.getTime());
    }

    /**
     * Date转imestamp
     *
     * @param date
     * @return
     */
    public static Timestamp converBySqlDate(Date date) {
        if (date == null) {
            return null;
        }
        return new Timestamp(date.getTime());
    }

    /**
     * util.Date转imestamp
     *
     * @param date
     * @return
     */
    public static Timestamp converByUtilDate(java.util.Date date) {
        if (date == null) {
            return null;
        }
        return new Timestamp(date.getTime());
    }

    /**
     * 将String字符串转换为java.sql.Timestamp格式日期,用于数据库保存
     *
     * @param strDate
     *            表示日期的字符串
     * @param dateFormat
     *            传入字符串的日期表示格式（如："yyyy-MM-dd HH:mm:ss"）
     * @return java.sql.Timestamp类型日期对象（如果转换失败则返回null）
     */
    public static Timestamp strToSqlDate(String strDate, String dateFormat) {
        SimpleDateFormat sf = new SimpleDateFormat(dateFormat);
        java.util.Date date = null;
        try {
            date = sf.parse(strDate);
        } catch (ParseException e) {
//            e.printStackTrace();
        }
        Timestamp dateSQL = new Timestamp(date.getTime());
        return dateSQL;
    }

    public static java.util.Date strToUtilDate(String strDate, String dateFormat) {
        SimpleDateFormat sf = new SimpleDateFormat(dateFormat);
        java.util.Date date = null;
        try {
            date = sf.parse(strDate);
        } catch (ParseException e) {
//            e.printStackTrace();
        }
        return date;
    }


    /**
     * 获取前一天
     *
     * @param date
     * @return
     */
    public static java.util.Date getBeforeDay(java.util.Date date, int beforeCount) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, 0 - beforeCount);
        date = calendar.getTime();
        return date;
    }

    /**
     * 获取前一天
     *
     * @param timestamp
     * @return
     */
    public static Timestamp getBeforeDay(Timestamp timestamp, int beforeCount) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(timestamp);
        calendar.add(Calendar.DAY_OF_MONTH, 0 - beforeCount);
        java.util.Date date = calendar.getTime();
        return converByUtilDate(date);
    }

    /**
     * 当前时间对应日期
     *
     * @param date
     * @return
     */
    public static java.util.Date getNowDay(java.util.Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, 0);
        date = calendar.getTime();
        return date;
    }

    /**
     * 获取后一天
     *
     * @param date
     * @return
     */
    public static java.util.Date getNextDay(java.util.Date date, int nextCount) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, nextCount);
        date = calendar.getTime();
        return date;
    }

    /**
     * 获取后一天
     *
     * @param timestamp
     * @return
     */
    public static Timestamp getNextDay(Timestamp timestamp, int nextCount) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(timestamp);
        calendar.add(Calendar.DAY_OF_MONTH, nextCount);
        java.util.Date date = calendar.getTime();
        return converByUtilDate(date);
    }

    /**
     * 格式化日期返回对文本
     * @param timestamp 日期
     * @param formatStr 格式化类型
     * @return
     */
    public static String formatData(Timestamp timestamp,String formatStr){
        SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
        return sdf.format(timestamp.getTime());
    }

    /**
     * 格式化日期返回对文本
     * @param date 日期
     * @param formatStr 格式化类型
     * @return
     */
    public static String formatData(java.util.Date date, String formatStr){
        SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
        return sdf.format(date.getTime());
    }

    /**
     * 获取现在到明天零时还有多少分钟
     */
    public static int getToTomorrowRestMinute(){
        java.util.Date nextDay = DateUtil.getNextDay(new java.util.Date(), 1);
        long current=System.currentTimeMillis();
        java.util.Date date = DateUtil.strToUtilDate(DateUtil.formatData(nextDay, "yyyy-MM-dd 00:00:00"), "yyyy-MM-dd");
        long ll = (date.getTime() / 1000 / 60) - (current / 1000 / 60);
        return (int)ll;
    }

    /**
     * 获取当天最后一秒的时间戳
     * @param timestamp
     * @return
     */
    public static long getSameDayLastSecond(Timestamp  timestamp){
        //格式化时间戳为当天时间
        String formatData = DateUtil.formatData(timestamp, "yyyy-MM-dd");
        Timestamp sameDay = DateUtil.strToSqlDate(formatData, "yyyy-MM-dd");
        int dayMis= 1000 * 60 * 60 * 24;
        //当天的毫秒
        long curMillisecond = sameDay.getTime();
        //当天最后一秒
        long resultMis= curMillisecond+(dayMis-1);
        java.util.Date resultDate=new java.util.Date(resultMis);
        return resultDate.getTime();
    }
}
