package com.example.user.myapp5.login;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.user.myapp5.R;
import com.example.user.myapp5.member.MemberBean;
import com.example.user.myapp5.member.MemberDAO;

public class loginActivity extends Activity implements View.OnClickListener{
    EditText etID,etPW;
    TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etID = (EditText) findViewById(R.id.etID);
        etPW = (EditText) findViewById(R.id.etPW);
        textResult = (TextView) findViewById(R.id.textResult);
        ((Button)findViewById(R.id.btSignup)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String id = etID.getText().toString();
        String pw = etPW.getText().toString();
        MemberBean member = new MemberBean();
        //    MemberServiceImpl service = new MemberServiceImpl();
        MemberDAO dao = new MemberDAO(this.getApplicationContext());
        member.setId(id);
        member.setPw(pw);
        member = dao.login(member);
        Log.i("DB 다녀온 결과 ID ",member.getId());
        if (member == null){
            textResult.setText("로그인 결과 : 실패");
        }else{
            textResult.setText("로그인 결과 : "+member.getName()+" 환영합니다");
        }
    }
}
