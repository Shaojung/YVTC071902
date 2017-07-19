package com.example.yvtc.yvtc071902;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

/**
 * Created by yvtc on 2017/7/19.
 */

public class MyAdapter extends BaseAdapter {

    private String cities[];
    private boolean chks[];
    Context context;
    public MyAdapter(Context context, String cities[], boolean chks[])
    {
        this.context = context;
        this.cities = cities;
        this.chks = chks;
    }



    @Override
    public int getCount() {
        return cities.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Log.d("MyView", "getView position:" + position);

        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.myitem, null);
        final CheckBox chk = (CheckBox) v.findViewById(R.id.checkBox);
        chk.setText(cities[position]);
        chk.setChecked(chks[position]);
        chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                chks[position] = isChecked;
            }
        });

        TextView tv = (TextView) v.findViewById(R.id.textView);
        tv.setText(cities[position]);
        return v;
    }
}
