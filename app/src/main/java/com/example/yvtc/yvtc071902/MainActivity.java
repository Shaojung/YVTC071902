package com.example.yvtc.yvtc071902;

import android.Manifest;
import android.app.backup.BackupDataOutput;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.StringBuilderPrinter;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    String cities[] = {"台北", "台中", "台南", "高雄","台北1", "台中1", "台南1", "高雄1","台北2", "台中2", "台南2", "高雄2"};
    boolean chks[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chks = new boolean[cities.length];
        lv = (ListView) findViewById(R.id.listView);
        MyAdapter adapter = new MyAdapter();
        lv.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Show");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        StringBuilder sb = new StringBuilder();
        int i;
        for (i=0;i<cities.length;i++)
        {
            if (chks[i])
            {
                sb.append(cities[i] + ",");
            }
        }
        Toast.makeText(MainActivity.this, sb.toString(), Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }

    class MyAdapter extends BaseAdapter
    {

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

            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
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

}

