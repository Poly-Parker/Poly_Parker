package com.cs499.ricky.polyparker;

import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TextView;

/**
 * Created by Ricky on 4/21/2015.
 */
public class TabbedActivity extends TabActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TabHost mTabHost = getTabHost();

        mTabHost.addTab(mTabHost.newTabSpec("Hybrid").setIndicator("Hybrid").setContent(new Intent(this, HybridActivity.class)));
        mTabHost.addTab(mTabHost.newTabSpec("List").setIndicator("List").setContent(new Intent(this, ListTabActivity.class)));
        mTabHost.addTab(mTabHost.newTabSpec("Map").setIndicator("Map").setContent(new Intent(this, MapActivity.class)));
        mTabHost.addTab(mTabHost.newTabSpec("Contribute").setIndicator("Contribute").setContent(new Intent(this, ContributeActivity.class)));
        mTabHost.setCurrentTab(0);
        mTabHost.getTabWidget().setBackgroundColor(Color.parseColor("#19C422"));

        for(int i=0;i<mTabHost.getTabWidget().getChildCount();i++)
        {
            TextView tv = (TextView) mTabHost.getTabWidget().getChildAt(i).findViewById(android.R.id.title);
            tv.setTextColor(Color.parseColor("#FFFFFF"));
        }
    }


}
