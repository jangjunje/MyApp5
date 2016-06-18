package com.example.user.myapp5.movie;

import android.content.Context;
import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.user.myapp5.R;

/**
 * Created by USER on 2016-06-18.
 */
public class MyGridAdapter extends BaseAdapter{
    Context context;

    Integer[] posterID = {
            R.drawable.mov01,R.drawable.mov02,R.drawable.mov03,
            R.drawable.mov04,R.drawable.mov05,R.drawable.mov06,
            R.drawable.mov07,R.drawable.mov08,R.drawable.mov09,
            R.drawable.mov10,R.drawable.mov11,R.drawable.mov12,
            R.drawable.mov13,R.drawable.mov14,R.drawable.mov15,
            R.drawable.mov16,R.drawable.mov17,R.drawable.mov18,
            R.drawable.mov19,R.drawable.mov20,R.drawable.mov21
    };

    public MyGridAdapter(Context c) {
        context = c;
    }

    @Override
    public int getCount() {
        return posterID.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageview = new ImageView(context);
        imageview.setLayoutParams(new GridView.LayoutParams(100,150));
        imageview.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageview.setPadding(5,5,5,5);

        imageview.setImageResource(posterID[position]);
        return imageview;
    }
}
