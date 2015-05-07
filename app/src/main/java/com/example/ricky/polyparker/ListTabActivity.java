package com.example.ricky.polyparker;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ricky on 4/21/2015.
 */
public class ListTabActivity extends Activity {

    private ArrayList<LotInfo> congestedList;
    private LotInfoAdapter congestedListAdapter;

    private LotInfoAdapter recentListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        congestedList = new ArrayList<LotInfo>();
        congestedList.add(new LotInfo("Lot A", 10));
        congestedList.add(new LotInfo("Lot B", 9));
        congestedList.add(new LotInfo("Lot C", 7));
        congestedList.add(new LotInfo("Lot E1", 2));
        congestedList.add(new LotInfo("Lot E2", 1));
        congestedList.add(new LotInfo("Lot J", 5));
        congestedList.add(new LotInfo("Lot K", 20));

        ListView congestedView = (ListView) findViewById(R.id.congested_list_view);

        congestedListAdapter = new LotInfoAdapter(this, congestedList);

        congestedView.setAdapter(congestedListAdapter);

        // Query all entries on Parse and display on all submitted
        ParseQuery<LotInfo> lotInfoQuery = ParseQuery.getQuery(LotInfo.class);

        lotInfoQuery.findInBackground(new FindCallback<LotInfo>() {
            @Override
            public void done(List<LotInfo> lotInfoQuery, ParseException e) {
                if (e == null) {
                    ListView allSubmitView = (ListView) findViewById(R.id.recent_listView);
                    recentListAdapter = new LotInfoAdapter(ListTabActivity.this, lotInfoQuery);
                    Log.i("LotInfo", "list Size = " + lotInfoQuery.size());
                    allSubmitView.setAdapter(recentListAdapter);
                } else {
                    Log.i("LotInfo", e.toString());
                }
            }
        });
    }
}
