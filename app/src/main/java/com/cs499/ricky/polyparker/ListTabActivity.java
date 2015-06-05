package com.cs499.ricky.polyparker;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ricky on 4/21/2015.
 */
public class ListTabActivity extends Activity {

    private LotInfoAdapter totalListAdapter;

    private LotInfoAdapter recentListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        loadLotInfo();

        final Button refreshButton = (Button) findViewById(R.id.refresh_button);

        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadLotInfo();
            }
        });
    }

    private void loadLotInfo(){

        final ProgressDialog progressDialog = ProgressDialog.show(
                ListTabActivity.this, "", "Loading Data");

        ParseQuery<LotInfo> lotInfoQuery = ParseQuery.getQuery(LotInfo.class);
        lotInfoQuery.findInBackground(new FindCallback<LotInfo>() {
            @Override
            public void done(List<LotInfo> lotInfoQuery, ParseException e) {
                if (e == null) {
                    AverageLotInfo averageLotInfo = new AverageLotInfo();
                    averageLotInfo.setLotInfoList(lotInfoQuery);

                    ArrayList<LotInfo> avg = averageLotInfo.getAveragedLotList();
                    ListView totalAvgView = (ListView) findViewById(R.id.total_avg_listView);
                    totalListAdapter = new LotInfoAdapter(ListTabActivity.this, avg);
                    totalAvgView.setAdapter(totalListAdapter);

                    ArrayList<LotInfo> recentAvg = averageLotInfo.getLastTenMinAvgList();
                    ListView recentAvgView = (ListView) findViewById(R.id.recent_avg_listView);
                    recentListAdapter = new LotInfoAdapter(ListTabActivity.this, recentAvg);
                    recentAvgView.setAdapter(recentListAdapter);

                    progressDialog.hide();
                }
                else {
                    Log.i("LotInfo", e.toString());
                    progressDialog.hide();
                }
            }
        });

    }


}
