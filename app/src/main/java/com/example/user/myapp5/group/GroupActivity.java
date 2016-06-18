package com.example.user.myapp5.group;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.myapp5.R;
import com.example.user.myapp5.group.GroupActivity;

public class GroupActivity extends Activity implements View.OnClickListener {
    GroupDBHelper groupDBHelper = new GroupDBHelper(this);
    SQLiteDatabase db;
    EditText editName, editNum, editID;
    Button btnInsert, btnInit, btnDelete, btnUpdate, btnSearch, btnList, btnGroupNum;
    TextView textResultName, textResultNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

        editName = (EditText) findViewById(R.id.editName);
        editNum = (EditText) findViewById(R.id.editNum);
        editID  = (EditText) findViewById(R.id.editID);
        btnInsert = (Button) findViewById(R.id.btnInsert);
        btnInit = (Button) findViewById(R.id.btnInit);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnSearch = (Button) findViewById(R.id.btnSearch);
        btnList = (Button) findViewById(R.id.btnList);
        btnGroupNum = (Button) findViewById(R.id.btnGroupNum);
        textResultName = (TextView) findViewById(R.id.textResultName);
        textResultNum = (TextView) findViewById(R.id.textResultNum);

        btnGroupNum.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                db = groupDBHelper.getReadableDatabase();

                Cursor cursor = db.rawQuery("SELECT * FROM girl_group;", null);

                Integer cnt = cursor.getCount();
                textResultName.setText("DB에 저장된 값의 갯수 : ");
                textResultNum.setText(String.valueOf(cnt));

                db.close();
            }
        });

        btnInsert.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                db = groupDBHelper.getWritableDatabase();
                db.execSQL("INSERT INTO girl_group(name, num) VALUES('"+editName.getText().toString()+"', '"+editNum.getText().toString()+"');");
                Toast.makeText(getApplicationContext(), "입력성공 "+ editName.getText().toString()+", " + editNum.getText().toString(), Toast.LENGTH_LONG).show();
                db.close();
            }
        });

        btnList.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                db = groupDBHelper.getReadableDatabase();
                Cursor cursor = db.rawQuery("SELECT * FROM girl_group;", null);
                String name = "id "+"\t"+"그룹이름" + "\r\n" + "-----  ----------" + "\r\n";
                String num = "멤버수" + "\r\n" + "---------------" + "\r\n";

                while (cursor.moveToNext()) {
                    name += String.valueOf(cursor.getInt(0))+"     "+ cursor.getString(1) + "\r\n";
                    num += cursor.getString(2) + "\r\n";
                }

                textResultName.setText(name);
                textResultNum.setText(num);

                db.close();
            }
        });

        btnSearch.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                db = groupDBHelper.getReadableDatabase();
                Cursor cursor = db.rawQuery("SELECT * FROM girl_group WHERE _id='" + editID.getText().toString() + "';", null);

                String result = "검색결과 : ";
                while (cursor.moveToNext()) {
                    result += String.valueOf(cursor.getInt(0)) + "\t" + cursor.getString(1) + "\t" + cursor.getString(2) + "\r\n";
                }

                textResultName.setText(result);
                textResultNum.setText("");

                db.close();
            }
        });

        btnDelete.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                db = groupDBHelper.getWritableDatabase();
                db.execSQL("DELETE FROM girl_group WHERE _id = '"+editID.getText().toString()+"'");

                Cursor cursor = db.rawQuery("SELECT * FROM girl_group;", null);
                String name = "id "+"\t"+"그룹이름" + "\r\n" + "-----  ----------" + "\r\n";
                String num = "멤버수" + "\r\n" + "---------------" + "\r\n";

                while (cursor.moveToNext()) {
                    name += String.valueOf(cursor.getInt(0))+"     "+ cursor.getString(1) + "\r\n";
                    num += cursor.getString(2) + "\r\n";
                }

                textResultName.setText(name);
                textResultNum.setText(num);

                db.close();
            }
        });
    }

    @Override
    public void onClick(View v) {

    }


//    @Override
//    public void onClick(View v) {
//        switch (v.getId()){
//            case R.id.btnList: {
//                db = groupDBHelper.getReadableDatabase();
//                Cursor cursor = db.rawQuery("SELECT * FROM girl_group;", null);
//                String name = "그룹이름" + "\r\n" + "---------------" + "\r\n";
//                String num = "멤버수" + "\r\n" + "---------------" + "\r\n";
//
//                while (cursor.moveToNext()) {
//                    name += String.valueOf(cursor.getInt(2))+"  "+ cursor.getString(1) + "\r\n";
//                    num += cursor.getString(2) + "\r\n";
//                }
//
//                textResultName.setText(name);
//                textResultNum.setText(num);
//
//                db.close();
//            }
//                break;
//            case R.id.btnGroupNum:{
//                db = groupDBHelper.getReadableDatabase();
//                Cursor cursor;
//                cursor = db.rawQuery("SELECT * FROM girl_group;", null );
//
//                Integer cout = cursor.getCount();
//                textResultName.setText("DB에 저장된 값의 갯수 : ");
//                textResultNum.setText(cout);
//
//                db.close();
//            }
//                break;
//            case R.id.btnInit: {
//                db = groupDBHelper.getWritableDatabase();
//                groupDBHelper.onUpgrade(db, 1, 2);
//                db.close();
//            }
//                break;
//            case R.id.btnInsert:{
//                db = groupDBHelper.getWritableDatabase();
//                db.execSQL("INSERT INTO girl_group(name, num) VALUES('"+editName.getText().toString()+"', '"+editNum.getText().toString()+"');");
//                Toast.makeText(getApplicationContext(), "입력성공 "+ editName.getText().toString()+", " + editNum.getText().toString(), Toast.LENGTH_LONG).show();
//                db.close();
//            }
//                break;
//            case R.id.btnUpdate:
//                db = groupDBHelper.getWritableDatabase();
//                db.execSQL("UPDATE TABLE girl_group SET WHERE _id=1 name ='"+editName.getText().toString()+"' num ='"+editNum.getText().toString()+";' ");
//                break;
//            case R.id.btnSearch: {
//                db = groupDBHelper.getReadableDatabase();
//                Cursor cursor;
//                cursor = db.rawQuery("SELECT * FROM girl_group WHERE _id=1;", null);
//
//                String name = cursor.getString(1);
//                String num = String.valueOf(cursor.getInt(2));
//
//                textResultName.setText(name);
//                textResultNum.setText(num);
//                db.close();
//            }
//                break;
//            case R.id.btnDelete: {
//                db = groupDBHelper.getWritableDatabase();
//                db.execSQL("DELETE FROM girl_group WHERE _id = 1");
//                db.close();
//            }
//                break;
//
//        }
//    }
}
