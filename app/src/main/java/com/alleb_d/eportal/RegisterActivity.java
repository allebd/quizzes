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

public class RegisterActivity extends AppCompatActivity {
    Context c;
    EditText etNameReg;
    EditText etEmailReg;
    EditText etUsernameReg;
    EditText etPasswordReg;
    EditText etConfirmPassReg;
    TextView tvSignAdmin;
    TextView tvSignStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        c = this;
        etNameReg = (EditText) findViewById(R.id.etNameReg);
        etEmailReg = (EditText) findViewById(R.id.etEmailReg);
        etUsernameReg = (EditText) findViewById(R.id.etUsernameReg);
        etPasswordReg = (EditText) findViewById(R.id.etPasswordReg);
        etConfirmPassReg = (EditText) findViewById(R.id.etConfirmPassReg);
        tvSignAdmin = (TextView) findViewById(R.id.tvSignAdmin);
        tvSignStudent = (TextView) findViewById(R.id.tvSignStudent);
        final Button btnRegister = (Button) findViewById(R.id.btnRegister);

        etNameReg.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                btnRegister.setEnabled(!etNameReg.getText().toString().isEmpty());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if(etPasswordReg.getText().toString() != etConfirmPassReg.getText().toString()){
//                    toast("Passwords entered are not the same");
//                }else if(!etNameReg.getText().toString().isEmpty() && !etEmailReg.getText().toString().isEmpty() && !etUsernameReg.getText().toString().isEmpty() && !etPasswordReg.getText().toString().isEmpty() && !etConfirmPassReg.getText().toString().isEmpty()) {
//                    toast("Your have Successfully Registered!");
//                } else {
                    //toast("Kindly fill in all empty fields!");
                toast("Your have Successfully Registered!");
//                }
            }
        });

        tvSignAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent StaffLoginActivityIntent = new Intent(RegisterActivity.this, StaffLoginActivity.class);
                startActivity(StaffLoginActivityIntent);
            }
        });

        tvSignStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent LoginActivityIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(LoginActivityIntent);
            }
        });
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_register, menu);
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
