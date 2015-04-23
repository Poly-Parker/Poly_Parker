package com.example.ricky.polyparker;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by Ricky on 4/22/2015.
 */
public class ContributeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceBundle){
        super.onCreate(savedInstanceBundle);
        setContentView(R.layout.activity_contribute);

        Spinner lotSpinner = (Spinner) findViewById(R.id.lot_spinner);
        ArrayAdapter<CharSequence> lotAdapt = ArrayAdapter.createFromResource(this,
                R.array.lots, android.R.layout.simple_spinner_item);
        lotAdapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lotSpinner.setAdapter(lotAdapt);

        Spinner timeSpinner = (Spinner) findViewById(R.id.time_spinner);
        ArrayAdapter<CharSequence> timeAdapt = ArrayAdapter.createFromResource(this,
                R.array.wait_times, android.R.layout.simple_spinner_item);
        timeAdapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        timeSpinner.setAdapter(timeAdapt);
    }
}
