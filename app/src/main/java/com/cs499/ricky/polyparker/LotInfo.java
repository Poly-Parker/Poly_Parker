package com.cs499.ricky.polyparker;

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

    public boolean isrecentlySubmitted(){
        //printDateCompare();
        Calendar cal = Calendar.getInstance();
        if (cal.get(Calendar.YEAR) != getYear()) return false;
        if (cal.get(Calendar.MONTH)!= getMonth()) return false;
        if (cal.get(Calendar.DAY_OF_MONTH) != getDayOfMonth()) return false;
        if (cal.get(Calendar.DAY_OF_WEEK)!= getDayOfWeek()) return false;
        if (cal.get(Calendar.HOUR_OF_DAY) != getHour()) {
            if (cal.get(Calendar.MINUTE) > 10) return false;
            else {
                if (cal.get(Calendar.HOUR_OF_DAY) != getHour() + 1 ) return false;
                else {
                    int offset = 9 - cal.get(Calendar.MINUTE);
                    if (getMinute() < (59 - offset) ) return false;
                }
            }
        }
        else if (getMinute() < cal.get(Calendar.MINUTE) - 10) return false;
        return true;
    }

    public void printDateCompare(){
        Log.i("~TIMEDEGUG~Instance", "" + getInt("hour") + ":" + minute + "::" + dayOfMonth + "," + month  + "," + year);
        Calendar cal = Calendar.getInstance();
        Log.i("~TIMEDEGUG-Compare~", "" + cal.get(Calendar.HOUR) + ":" + cal.get(Calendar.MINUTE) + "::" + cal.get(Calendar.DAY_OF_MONTH) + "," + cal.get(Calendar.MONTH)  + "," + cal.get(Calendar.YEAR));
    }
}
