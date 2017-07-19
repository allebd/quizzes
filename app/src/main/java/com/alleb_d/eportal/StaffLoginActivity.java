package com.alleb_d.eportal;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class StaffLoginActivity extends AppCompatActivity {
    Context c;
    EditText etUsername;
    EditText etPassword;
    TextView tvSignStudent;
    TextView tvRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_login);

        c = this;
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        tvSignStudent = (TextView) findViewById(R.id.tvSignStudent);
        tvRegister = (TextView) findViewById(R.id.tvRegister);
        final Button btnLogin = (Button) findViewById(R.id.btnLogin);

        etUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                btnLogin.setEnabled(!etUsername.getText().toString().isEmpty());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!etUsername.getText().toString().isEmpty() && !etPassword.getText().toString().isEmpty()) {
                    Intent DashboardActivityIntent = new Intent(StaffLoginActivity.this, StaffDashboardActivity.class);
                    startActivity(DashboardActivityIntent);
                } else {
                    etUsername.setText("");
                    etPassword.setText("");
                    toast("Please fill in email and password!");
                }
            }
        });

        tvSignStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent LoginActivityIntent = new Intent(StaffLoginActivity.this, LoginActivity.class);
                startActivity(LoginActivityIntent);
            }
        });

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent RegisterActivityIntent = new Intent(StaffLoginActivity.this, RegisterActivity.class);
                startActivity(RegisterActivityIntent);
            }
        });
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_staff_login, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
    private void toast(String s)
    {
        Toast.makeText(c, s, Toast.LENGTH_SHORT).show();
    }
}
