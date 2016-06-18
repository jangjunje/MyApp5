package com.example.user.myapp5.main;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import com.example.user.myapp5.R;
import com.example.user.myapp5.calc.CalcActivity;
import com.example.user.myapp5.group.GroupActivity;
import com.example.user.myapp5.kaup.KaupActivity;
import com.example.user.myapp5.login.loginActivity;
import com.example.user.myapp5.spinner.SpinnerActivity;
import com.example.user.myapp5.signup.SignupActivity;


public class MainActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((Button) findViewById(R.id.btKaup)).setOnClickListener(this);
        ((Button) findViewById(R.id.btCalc)).setOnClickListener(this);
        ((Button) findViewById(R.id.btLogin)).setOnClickListener(this);
        ((Button) findViewById(R.id.btSignup)).setOnClickListener(this);
        ((Button) findViewById(R.id.btGroup)).setOnClickListener(this);
        ((Button) findViewById(R.id.btSpinner)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btKaup:
                startActivity(new Intent(this, KaupActivity.class));
                break;
            case R.id.btCalc:
                startActivity(new Intent(this, CalcActivity.class));
                break;
            case R.id.btLogin:
                startActivity(new Intent(this, loginActivity.class));
                break;
            case R.id.btSignup:
                startActivity(new Intent(this, SignupActivity.class));
                break;
            case R.id.btGroup:
                startActivity(new Intent(this, GroupActivity.class));
                break;
            case R.id.btSpinner:
                startActivity(new Intent(this, SpinnerActivity.class));
                break;
        }

    }
}
