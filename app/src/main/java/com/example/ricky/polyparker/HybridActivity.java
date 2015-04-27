package com.example.ricky.polyparker;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Ricky on 4/21/2015.
 */
public class HybridActivity extends Activity {

    private ArrayList<LotInfo> congestedList;
    private LotInfoAdapter congestedListAdapter;

    private ArrayList<LotInfo> recentList;
    private LotInfoAdapter recentListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hybrid);

        congestedList = new ArrayList<LotInfo>();
        congestedList.add(new LotInfo("Lot A", 10));
        congestedList.add(new LotInfo("Lot B", 9));
        congestedList.add(new LotInfo("Lot C", 7));
        congestedList.add(new LotInfo("Lot D", 2));
        congestedList.add(new LotInfo("Lot E", 1));
        congestedList.add(new LotInfo("Lot F", 5));
        congestedList.add(new LotInfo("Lot G", 20));

        ListView congestedView = (ListView) findViewById(R.id.congested_list_view);

        congestedListAdapter = new LotInfoAdapter(this, congestedList);

        congestedView.setAdapter(congestedListAdapter);

        recentList = new ArrayList<LotInfo>();
        recentList.add(new LotInfo("Lot J1", 13));
        recentList.add(new LotInfo("Lot J2", 12));
        recentList.add(new LotInfo("Lot J3", 10));
        recentList.add(new LotInfo("Lot J4", 9));
        recentList.add(new LotInfo("Lot J5", 4));

        ListView recentView = (ListView) findViewById(R.id.recent_listView);

        recentListAdapter = new LotInfoAdapter(this, recentList);

        recentView.setAdapter(recentListAdapter);
    }
}
