package com.cs499.ricky.polyparker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Ricky on 4/25/2015.
 */
public class LotInfoAdapter extends ArrayAdapter<LotInfo> {

    public Context context;
    public List <LotInfo> lotInfos;

    public LotInfoAdapter (Context context, List<LotInfo> lotInfos){
        super(context, R.layout.listview_item, lotInfos);
        this.context = context;
        this.lotInfos = lotInfos;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.listview_item, parent, false);

        TextView lotView = (TextView) view.findViewById(R.id.lot_text);
        lotView.setText(lotInfos.get(position).getLotName());

        TextView waitView = (TextView) view.findViewById(R.id.time_text);
        waitView.setText("" + lotInfos.get(position).getWaitTime() + " Min");

        return view;
    }
}
