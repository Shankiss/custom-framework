package com.zyuc.demo.utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @Version 1.0
 * @Description 日期工具类
 * @Date 2020/5/10 10:41
 * @Created by ChenHao
 */
public interface DateUtil {
    /**
     * 20111203
     */
    DateTimeFormatter DEFAULT_DATETIMEFORMATTER = DateTimeFormatter.BASIC_ISO_DATE;
    //    DateTimeFormatter DATETIMEFORMATTER_1 = DateTimeFormatter.ISO_LOCAL_DATE;//2011-12-03
    ZoneId ZONE_ID = ZoneId.systemDefault();

    /**
     * 获取指定日期所在周的周一和周天
     */
    static LocalDate[] getMondaySunday(LocalDate localDate) {
        LocalDate begin = localDate.minusDays(localDate.getDayOfWeek().ordinal());
        LocalDate end = localDate.plusDays(6 - localDate.getDayOfWeek().ordinal());
        return new LocalDate[]{begin, end};
    }

    /**
     * 获取指定日期周的周一和周天
     *
     * @return
     */
    static String[] getThisMondaySunday(LocalDate localDate) {
        LocalDate[] localDateArr = getMondaySunday(localDate);
        return l2s(localDateArr);
    }

    /**
     * 获取指定日期上周的周一和周天
     *
     * @return
     */
    static String[] getLastMondaySunday(LocalDate localDate) {
        LocalDate[] localDateArr = getMondaySunday(localDate.minusWeeks(1));
        return l2s(localDateArr);
    }


    /**
     * 获取指定日期的月初和月末
     */
    static LocalDate[] getMonthEarlyEnd(LocalDate localDate) {
        LocalDate begin = localDate.minusDays(localDate.getDayOfMonth() - 1);
        LocalDate end = begin.plusDays(localDate.getMonth().length(localDate.isLeapYear()) - 1);
        return new LocalDate[]{begin, end};
    }

    /**
     * 获取指定日期月的月初和月末
     */
    static String[] getThisMonthEarlyEnd(LocalDate localDate) {
        LocalDate[] localDateArr = getMonthEarlyEnd(localDate);
        return l2s(localDateArr);
    }

    /**
     * 获取指定日期上月的月初和月末
     */
    static String[] getLastMonthEarlyEnd(LocalDate localDate) {
        LocalDate[] localDateArr = getMonthEarlyEnd(localDate.minusMonths(1));
        return l2s(localDateArr);
    }

    /**
     * 字符串 转 LocalDate,默认格式20190101
     */
    static LocalDate s2l(String str) {
        return s2l(str, DEFAULT_DATETIMEFORMATTER);
    }

    /**
     * 字符串 转 LocalDate
     */
    static LocalDate s2l(String str, DateTimeFormatter formatter) {
        return LocalDate.parse(str, formatter);
    }

    /**
     * date 转 LocalDate
     */
    static LocalDate d2l(Date date) {
        return date.toInstant().atZone(ZONE_ID).toLocalDate();
    }

    /**
     * date 转 String
     */
    static String d2s(Date date) {
        return l2s(d2l(date));
    }

    /**
     * LocalDate 转 date
     */
    static Date l2d(LocalDate localDate) {
        ZonedDateTime zdt = localDate.atStartOfDay(ZONE_ID);
        return Date.from(zdt.toInstant());
    }

    /**
     * LocalDate[] 转 date[]
     */
    static Date[] l2d(LocalDate[] localDateArr) {
        Date[] dateArr = new Date[localDateArr.length];
        for (int i = 0; i < localDateArr.length; i++) {
            dateArr[i] = l2d(localDateArr[i]);
        }
        return dateArr;
    }


    /**
     * LocalDate 转 String
     */
    static String l2s(LocalDate localDate) {
        return localDate.format(DEFAULT_DATETIMEFORMATTER);
    }

    /**
     * LocalDate[] 转 String[]
     */
    static String[] l2s(LocalDate[] localDateArr) {
        String[] strArr = new String[localDateArr.length];
        for (int i = 0; i < localDateArr.length; i++) {
            strArr[i] = l2s(localDateArr[i]);
        }
        return strArr;
    }

    /**
     * 计算前 n 天时间
     */
    static String preDay(LocalDate localDate, int n) {
        return l2s(localDate.minusDays(n));
    }


    /**
     * 计算前 n 周时间
     */
    static String preWeek(LocalDate localDate, int n) {
        return l2s(localDate.minusWeeks(n));
    }

    /**
     * 计算前 n 月时间
     */
    static String preMonth(LocalDate localDate, int n) {
        return l2s(localDate.minusMonths(n));
    }

    /**
     * 获取指定日期的周一
     */
    static String getMonday(String str) {
        LocalDate ld = s2l(str);
        ld = ld.minusDays(ld.getDayOfWeek().ordinal());
        return l2s(ld);
    }

    /**
     * 获取指定日期的月初
     */
    static String getMonthFirst(String str) {
        LocalDate ld = s2l(str);
        ld = ld.minusDays(ld.getDayOfMonth() - 1);
        return l2s(ld);
    }

}
