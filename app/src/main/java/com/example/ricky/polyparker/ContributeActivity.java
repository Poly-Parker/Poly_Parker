package com.example.ricky.polyparker;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.parse.ParseObject;

/**
 * Created by Ricky on 4/22/2015.
 */
public class ContributeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceBundle){
        super.onCreate(savedInstanceBundle);
        setContentView(R.layout.activity_contribute);

        final Spinner LOT_SPINNER = (Spinner) findViewById(R.id.lot_spinner);
        ArrayAdapter<CharSequence> lotAdapt = ArrayAdapter.createFromResource(this,
                R.array.lots, android.R.layout.simple_spinner_item);
        lotAdapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        LOT_SPINNER.setAdapter(lotAdapt);

        final Spinner TIME_SPINNER = (Spinner) findViewById(R.id.time_spinner);
        ArrayAdapter<CharSequence> timeAdapt = ArrayAdapter.createFromResource(this,
                R.array.wait_times, android.R.layout.simple_spinner_item);
        timeAdapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        TIME_SPINNER.setAdapter(timeAdapt);

        final Button submitButton = (Button) findViewById(R.id.contribute);


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseObject lotInfo = ParseObject.create("LotInfo");
                lotInfo = new LotInfo(LOT_SPINNER.getSelectedItem().toString(),
                        Integer.parseInt("" + TIME_SPINNER.getSelectedItem().toString().charAt(0)));
                lotInfo.saveInBackground();
                Toast.makeText(ContributeActivity.this, "Thank You!", Toast.LENGTH_LONG).show();
                submitButton.setEnabled(false);
                submitButton.setText("Submitted, Thank You!");
            }
        });
    }
}
