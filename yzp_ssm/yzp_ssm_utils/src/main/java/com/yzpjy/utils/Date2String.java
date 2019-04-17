package com.yzpjy.utils;

import javafx.scene.input.DataFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Date2String {

    public static Date string2date(String date){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date d = format.parse(date);
            return d;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String date2string(Date date){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = format.format(date);
        return s;
    }

}
