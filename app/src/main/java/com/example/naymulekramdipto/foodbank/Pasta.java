package com.example.naymulekramdipto.foodbank;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Pasta extends AppCompatActivity {

    private TextView textPasta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasta);

        textPasta=(TextView) findViewById(R.id.PastaId);
        new PastaTask().execute("https://api.myjson.com/bins/zayl2");
    }

    private class PastaTask extends AsyncTask<String,String,String>
    {

        @Override
        protected void onPostExecute(String s) {

            JSONObject jsonObj = null;
            try {
                jsonObj = new JSONObject(s);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            StringBuilder re = new StringBuilder();

            JSONArray jsonArray = jsonObj.optJSONArray("Pasta");


            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject c = jsonArray.optJSONObject(i);

                String rank=c.optString("Rank");
                String id = c.optString("Id");
                JSONObject price = c.optJSONObject("Price");
                String chicken_pasta =price.optString("Chicken Pasta");
                String beef_pasta=price.optString("Beef Pasta");
                String chicken_cream_pasta=price.optString("Chicken Cream Pasta");
                String pasta_basta=price.optString("Pasta Basta");
                String italian_pasta=price.optString("Italian Pasta");
                String contact_no=c.optString("Contact No");

                String res="\n\n\nRank: "+rank+"\nId: "+id+"\nPrice: "+"\nChicken Pasta: "+chicken_pasta+
                        "\nBeef Pasta: "+beef_pasta+"\nChicken Cream Pasta: " +chicken_cream_pasta
                        +"\nPasta Basta: "+pasta_basta+"\nItalian Pasta: "+italian_pasta+
                        "\nContact No: "+contact_no;
                re.append(res);
                Log.d("TAG", "onPostExecute: "+res);
            }
            textPasta.setText(re.toString());
        }
    @Override
    protected String doInBackground(String... strings) {

        StringBuilder result = new StringBuilder();

        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(strings[0]);
            urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());

            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            urlConnection.disconnect();
        }
        return result.toString();
    }
}
}
