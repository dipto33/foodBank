package com.example.naymulekramdipto.foodbank;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Naymul Ekram Dipto on 12/5/2018.
 */

public class CustomAdapter extends BaseAdapter {
    int[] flags;
    String[] foodname;
    Context context;
    private LayoutInflater infalterm;
    CustomAdapter(Context context,String[] foodname,int[] flags )
    {
        Log.e("DEBUGME",foodname.length+"");
        this.context=context;
        this.foodname=foodname;
        this.flags=flags;
        infalterm=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return foodname.length;
    }

    @Override
    public Object getItem(int position) {
        return foodname[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = infalterm.inflate(R.layout.activity_first, null);
        //TextView tv=convertView.findViewById(R.id.foodid);
        //tv.setText("YOYO");
        ImageView imageView= (ImageView) v.findViewById(R.id.image_view_x);
       TextView textView = (TextView) v.findViewById(R.id.foodid);
        imageView.setImageResource(flags[position]);
        textView.setText(foodname[position]);
        return v;
    }
}
