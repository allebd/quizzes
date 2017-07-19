package com.alleb_d.eportal;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {
    Context c;
    static final String[] COURSES =
            new String[] {"CST511 (Technology Principles)",
                    "TMC612 (Introduction to Life)",
                    "EDS511 (Introduction to Management)",
                    "ENG711 (Adjective)",
                    "APC524 (Introduction to Negotiation)",
                    "PDP678 (Introduction to Politics)"
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);

        tabHost.setup();

        TabHost.TabSpec tabSpec = tabHost.newTabSpec("course");
        tabSpec.setContent(R.id.tabCourseWare);
        tabSpec.setIndicator("Courses");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("question");
        tabSpec.setContent(R.id.tabQuestion);
        tabSpec.setIndicator("Questions");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("report");
        tabSpec.setContent(R.id.tabReport);
        tabSpec.setIndicator("Reports");
        tabHost.addTab(tabSpec);

        final Button btnSubmit = (Button) findViewById(R.id.button1);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //toast("Congratulation!!, You scored 5/5");
                    Toast.makeText(getApplicationContext(),"Congratulation!!, You scored 5/5",Toast.LENGTH_SHORT).show();
            }
        });

        final ListView listview = (ListView) findViewById(R.id.lvCourses);

        final ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < COURSES.length; ++i) {
            list.add(COURSES[i]);
        }

        final StableArrayAdapter adapter = new StableArrayAdapter(this,
                android.R.layout.simple_list_item_1, list);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, final View view, int i, long l) {
                final String item = (String) adapterView.getItemAtPosition(i);
                view.animate().setDuration(2000).alpha(0)
                        .withEndAction(new Runnable() {
                            @Override
                            public void run() {
                                list.remove(item);
                                adapter.notifyDataSetChanged();
                                view.setAlpha(1);
                            }
                        });
            }
        });
    }

    private class StableArrayAdapter extends ArrayAdapter<String> {

        HashMap<String, Integer> mIdMap = new HashMap<>();

        public StableArrayAdapter(Context context, int textViewResourceId, List<String> objects) {
            super(context, textViewResourceId, objects);
            for (int i = 0; i < objects.size(); ++i) {
                mIdMap.put(objects.get(i), i);
            }
        }

        @Override
        public long getItemId(int position) {
            String item = getItem(position);
            return mIdMap.get(item);
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dashboard, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }else if (id == R.id.action_logout) {
            Intent LoginActivityIntent = new Intent(DashboardActivity.this, LoginActivity.class);
            startActivity(LoginActivityIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void toast(String s)
    {
        Toast.makeText(c,s,Toast.LENGTH_SHORT).show();
    }
}
