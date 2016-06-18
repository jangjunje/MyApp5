package com.example.user.myapp5.signup;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.user.myapp5.R;
import com.example.user.myapp5.member.MemberBean;
import com.example.user.myapp5.member.MemberDAO;

public class SignupActivity extends Activity implements View.OnClickListener{
    EditText etID,etPW,etName,etEmail;
    TextView textResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        etName = (EditText) findViewById(R.id.etName);
        etID = (EditText) findViewById(R.id.etID);
        etPW = (EditText) findViewById(R.id.etPW);
        etEmail = (EditText) findViewById(R.id.etEmail);
        textResult = (TextView) findViewById(R.id.textResult);
        ((Button)findViewById(R.id.btSignup)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String name = etName.getText().toString();
        String id = etID.getText().toString();
        String pw = etPW.getText().toString();
        String email = etEmail.getText().toString();
        MemberBean member = new MemberBean();
        //    MemberServiceImpl service = new MemberServiceImpl();
        MemberDAO dao = new MemberDAO(this.getApplicationContext());
        member.setId(id);
        member.setPw(pw);
        member.setName(name);
        member.setEmail(email);
        String msg = dao.signup(member);
        textResult.setText("회원가입 결과 : "+msg);
    }
}
