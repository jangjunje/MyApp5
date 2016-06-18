package com.example.user.myapp5.group;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.myapp5.R;

public class GroupActivity extends Activity implements View.OnClickListener{
    GroupDBHelper groupDBHelper;
    SQLiteDatabase db;
    EditText editName, editNum;
    Button btnInsert, btnInit, btnDelete, btnUpdate, btnSearch, btnList, btnGroupNum;
    TextView textResultName, textResultNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

        editName       = (EditText) findViewById(R.id.editName);
        editNum        = (EditText) findViewById(R.id.editNum);
        btnInsert      = (Button) findViewById(R.id.btnInsert);
        btnInit        = (Button) findViewById(R.id.btnInit);
        btnDelete      = (Button) findViewById(R.id.btnDelete);
        btnUpdate      = (Button) findViewById(R.id.btnUpdate);
        btnSearch      = (Button) findViewById(R.id.btnSearch);
        btnList        = (Button) findViewById(R.id.btnList);
        btnGroupNum    = (Button) findViewById(R.id.btnGroupNum);
        textResultName = (TextView) findViewById(R.id.textResultName);
        textResultNum  = (TextView) findViewById(R.id.textResultNum);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnList: {
                db = groupDBHelper.getReadableDatabase();
                Cursor cursor = db.rawQuery("SELECT * FROM group;", null);
                String name = "그룹이름" + "\r\n" + "---------------" + "\r\n";
                String num = "멤버수" + "\r\n" + "---------------" + "\r\n";

                while (cursor.moveToNext()) {
                    name += cursor.getString(0) + "\r\n";
                    num += cursor.getString(1) + "\r\n";
                }

                textResultName.setText(name);
                textResultNum.setText(num);

                db.close();
            }
                break;
            case R.id.btnGroupNum:
                break;
            case R.id.btnInit:
                db = groupDBHelper.getWritableDatabase();
                groupDBHelper.onUpgrade(db, 1, 2);
                db.close();
                break;
            case R.id.btnInsert:{
                db = groupDBHelper.getWritableDatabase();
                db.execSQL("INSERT INTO group(name, num) VALUES('"+editName.getText().toString()+"', '"+editNum.getText().toString()+"')");
                Toast.makeText(getApplicationContext(), "입력성공 "+ editName.getText().toString()+", " + editNum.getText().toString(), Toast.LENGTH_LONG).show();
                db.close();
            }
                break;
            case R.id.btnUpdate:
                break;
            case R.id.btnSearch:
                break;
            case R.id.btnDelete:
                break;

        }
    }
}
