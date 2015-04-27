package com.example.ricky.polyparker;

/**
 * Created by Ricky on 4/25/2015.
 */
public class LotInfo {

    private String lotName;
    private int waitTime;

    public LotInfo(String lotName, int waitTime){
        this.lotName = lotName;
        this.waitTime = waitTime;
    }

    public void setLotName(String lotName) {
        this.lotName = lotName;
    }

    public void setWaitTime(int waitTime) {
        this.waitTime = waitTime;
    }

    public String getLotName() {
        return lotName;
    }

    public int getWaitTime() {
        return waitTime;
    }
}
