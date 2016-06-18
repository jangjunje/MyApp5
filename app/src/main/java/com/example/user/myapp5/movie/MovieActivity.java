package com.example.user.myapp5.movie;

import android.app.Activity;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.user.myapp5.R;

public class MovieActivity extends Activity implements View.OnClickListener{

    MyGridAdapter gAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        setTitle("그리드뷰 영화 포스터");

        final GridView gv = (GridView) findViewById(R.id.gridView1);

        MyGridAdapter gAdapter = new MyGridAdapter(this);
        gv.setAdapter(gAdapter);

        //findViewById(R.id.gridView1).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //View dialogView = (View) View.inflate(MovieActivity.this, R.layout.dailog, null);
        //AlertDialog.Builder dlg = new AlertDialog.Builder(MovieActivity.this);
        //ImageView ivPoster = (ImageView) dialogView.findViewById(R.id.ivPoster);
        //ivPoster.setImageResource(gAdapter.posterID[gAdapter.pos]);

    }
}
