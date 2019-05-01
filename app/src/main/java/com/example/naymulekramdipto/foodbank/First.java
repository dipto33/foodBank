package com.example.naymulekramdipto.foodbank;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class First extends AppCompatActivity {

    private int[] flags;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        final String[] food_name = getResources().getStringArray(R.array.foodname);
        flags = new int[9];
        flags[0] = R.drawable.pizza;
        flags[1] = R.drawable.burger;
        flags[2] = R.drawable.pasta;
        flags[3] = R.drawable.macaroni;
        flags[4] = R.drawable.shorma;
        flags[5] = R.drawable.nachos;
        flags[6] = R.drawable.frenchfry;
        flags[7] = R.drawable.chicken;
        flags[8] = R.drawable.noodlezzz;
        ListView listView= (ListView) findViewById(R.id.lis_view_id);
        CustomAdapter itt=new CustomAdapter(this,food_name,flags);
        listView.setAdapter(itt);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(First.this, food_name[position]+" is clicked", Toast.LENGTH_SHORT).show();
                if(food_name[position].equals("Pasta"))
                {
                    Intent intent=new Intent(First.this,Pasta.class);
                    startActivity(intent);
                }

            }
        });
    }
}
