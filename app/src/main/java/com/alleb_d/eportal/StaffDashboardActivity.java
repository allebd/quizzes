package com.alleb_d.eportal;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.Toast;

public class StaffDashboardActivity extends AppCompatActivity {
    Context c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_dashboard);

        TabHost tabHost = (TabHost) findViewById(R.id.tabStaffHost);

        tabHost.setup();

        TabHost.TabSpec tabSpec = tabHost.newTabSpec("course");
        tabSpec.setContent(R.id.tabStaffCourseWare);
        tabSpec.setIndicator("Courses");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("question");
        tabSpec.setContent(R.id.tabStaffQuestion);
        tabSpec.setIndicator("Questions");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("report");
        tabSpec.setContent(R.id.tabStaffReport);
        tabSpec.setIndicator("Reports");
        tabHost.addTab(tabSpec);

        final Button btnAddCourse = (Button) findViewById(R.id.btnAddCourse);
        final Button btnAddQuestion2 = (Button) findViewById(R.id.btnAddQuestion2);
        final Button btnAddGrade3 = (Button) findViewById(R.id.btnAddGrade3);

        btnAddCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast("New Course has been Added!");
            }
        });

        btnAddQuestion2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast("New Question has been Added!");
            }
        });

        btnAddGrade3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast("New Grade has been Added!");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_staff_dashboard, menu);
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
            Intent StaffLoginActivityIntent = new Intent(StaffDashboardActivity.this, StaffLoginActivity.class);
            startActivity(StaffLoginActivityIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void toast(String s)
    {
        Toast.makeText(c, s, Toast.LENGTH_SHORT).show();
    }
}
