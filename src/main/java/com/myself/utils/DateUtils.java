package com.myself.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static void main(String[] args) {

    }

    public static String getNow() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        return simpleDateFormat.format(date);
    }
}
