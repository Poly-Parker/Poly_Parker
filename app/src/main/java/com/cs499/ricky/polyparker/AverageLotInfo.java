package com.cs499.ricky.polyparker;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ricky on 5/13/2015.
 */
public class AverageLotInfo {
    public List<LotInfo> lotInfoList;
    public ArrayList<LotInfo> averagedLotList;
    public ArrayList<LotInfo> lastTenMinAvgList;
    public ArrayList<String>  uniqueNames;

    public int    lotCount;
    public int    [] averageTime;
    public int    [] numberOfEntries;

    public AverageLotInfo(){
        averagedLotList = new ArrayList<>();
        averagedLotList.add(new LotInfo("TEST LOT", -1));
    }

    public void setLotInfoList(List<LotInfo> lotInfoList){
        this.lotInfoList = lotInfoList;
        getLotAverages();
        getLastTenMinAverage();
    }

    private void getLotAverages() {
        // first get the unique lots in the list
        uniqueNames = new ArrayList<>();
        for (int i = 0; i < lotInfoList.size(); i++) {
            if (!uniqueNames.contains(lotInfoList.get(i).getLotName())) {
                uniqueNames.add(lotInfoList.get(i).getLotName());
                Log.i("TESTING UNIQUE", "New Unique: " + lotInfoList.get(i).getLotName());
            }
            else {
                Log.i("TESTING UNIQUE", "Supposed existing: " +  lotInfoList.get(i).getLotName());
            }
        }
        // update lotCount initialize new arrays
        lotCount = uniqueNames.size();
        Log.i("LotAverage", "UniqueLots = " + lotCount);
        averageTime = new int[lotCount];
        numberOfEntries = new int[lotCount];
        // Averages Calculated Here
        for (int i = 0; i < lotInfoList.size(); i++) {
            LotInfo currentLotInfo = lotInfoList.get(i);
            String currentLot = currentLotInfo.getLotName();
            int waitTime = currentLotInfo.getWaitTime();
            int index = uniqueNames.indexOf(currentLot);
            averageTime[index] += waitTime;
            numberOfEntries[index]++;
        }
        for (int i=0; i<lotCount; i++){
            averageTime[i] /= numberOfEntries[i];
        }
        averagedLotList = new ArrayList<>();
        for (int i=0; i<lotCount; i++){
            String name = uniqueNames.get(i);
            int    time = averageTime[i];
            averagedLotList.add(new LotInfo(name,time));
        }
        Log.i("LotAverage", "averagedLotList Size=" + averagedLotList.size());
    }

    private void getLastTenMinAverage(){
        averageTime = new int[lotCount];
        numberOfEntries = new int[lotCount];
        // Averages Calculated Here
        for (int i = 0; i < lotInfoList.size(); i++) {
            LotInfo currentLotInfo = lotInfoList.get(i);
            if (currentLotInfo.isrecentlySubmitted()) {
                String currentLot = currentLotInfo.getLotName();
                int waitTime = currentLotInfo.getWaitTime();
                int index = uniqueNames.indexOf(currentLot);
                averageTime[index] += waitTime;
                numberOfEntries[index]++;
            }
            else {

            }
        }
        for (int i=0; i<lotCount; i++){
            if (numberOfEntries[i] > 0)
                averageTime[i] /= numberOfEntries[i];
        }
        lastTenMinAvgList = new ArrayList<>();
        for (int i=0; i<lotCount; i++){
            if (numberOfEntries[i] > 0) {
                String name = uniqueNames.get(i);
                int time = averageTime[i];
                lastTenMinAvgList.add(new LotInfo(name, time));
            }
        }
    }

    public ArrayList<LotInfo> getAveragedLotList(){
        return averagedLotList;
    }

    public ArrayList<LotInfo> getLastTenMinAvgList(){
        if (lastTenMinAvgList.size() == 0){
            lastTenMinAvgList.add(new LotInfo("No Recent Data",-1));
        }
        return lastTenMinAvgList;
    }
}