package com.example.ricky.polyparker;

import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by Ricky on 4/25/2015.
 */

@ParseClassName("LotInfo")
public class LotInfo extends ParseObject{

    private String lotName;
    private int waitTime;

    public LotInfo(){
        lotName = "NULL";
        waitTime = -1;
    }

    public LotInfo(String lotName, int waitTime){
        put("lotName", lotName);
        put("waitTime", waitTime);
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

    public int getWaitTime() {
        return getInt("waitTime");
    }
}
