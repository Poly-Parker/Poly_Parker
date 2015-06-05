package com.cs499.ricky.polyparker;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

/**
 * Created by Ricky on 4/22/2015.
 */
public class MapActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        WebView map = (WebView) findViewById(R.id.webMap);
        map.loadUrl("file:///android_asset/parkingmap.jpg");
        map.getSettings().setBuiltInZoomControls(true);
        map.getSettings().setDisplayZoomControls(false);
        map.setLongClickable(true);
        map.getSettings().setLoadWithOverviewMode(true);
        map.getSettings().setUseWideViewPort(true);

        map.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return true;
            }
        });
        map.zoomOut();
    }
}
