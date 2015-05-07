package com.example.ricky.polyparker;

import android.util.Log;

import com.parse.ParseClassName;
import com.parse.ParseObject;

import java.util.Calendar;

/**
 * Created by Ricky on 4/25/2015.
 */

@ParseClassName("LotInfo")
public class LotInfo extends ParseObject{

    private String lotName;
    private int waitTime;
    private int dayOfWeek;
    private int hour;
    private int minute;
    private int month;
    private int dayOfMonth;
    private int year;

    public LotInfo(){
    }

    public LotInfo(String lotName, int waitTime){
        put("lotName", lotName);
        put("waitTime", waitTime);
        Calendar cal = Calendar.getInstance();
        put("dayOfWeek", cal.get(Calendar.DAY_OF_WEEK));
        put("hour", cal.get(Calendar.HOUR_OF_DAY));
        put("minute", cal.get(Calendar.MINUTE));
        put("month", cal.get(Calendar.MONTH));
        put("dayOfMonth", cal.get(Calendar.DAY_OF_MONTH));
        put("year", cal.get(Calendar.YEAR));
    }

    public void setLotName(String lotName) {
        put("lotName", lotName);
    }

    public void setWaitTime(int waitTime) {
        put("waitTime", waitTime);
    }

    public String getLotName() {
        return getString("lotName");
    }

    public int getDayOfWeek(){
        return getInt("dayOfWeek");
    }

    public int getHour(){
        return getInt("hour");
    }

    public int getMinute(){
        return getInt("minute");
    }

    public int getMonth() {
        return getInt("month");
    }

    public int getDayOfMonth(){
        return getInt("dayOfMonth");
    }

    public int getYear(){
        return getInt("year");
    }

    public int getWaitTime() {
        return getInt("waitTime");
    }
}
