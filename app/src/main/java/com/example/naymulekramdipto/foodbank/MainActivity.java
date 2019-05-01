package com.example.naymulekramdipto.foodbank;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView iv = (ImageView) findViewById(R.id.image_view);
        scaleImg(iv, R.drawable.burger_chips_dinner70497);
        button = (Button) findViewById(R.id.button_id);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, First.class);
                startActivity(intent);
            }
        });
    }

    public void scaleImg(ImageView img, int pic)
    {
        Display screen=getWindowManager().getDefaultDisplay();//will give us access to screen
        BitmapFactory.Options opt=new BitmapFactory.Options();//java lib that will scale images for us
        opt.inJustDecodeBounds=true;
        BitmapFactory.decodeResource(getResources(),pic,opt);
        int imgWid=opt.outWidth;
        int scr=screen.getWidth();

        if(imgWid>scr){
            opt.inSampleSize= Math.round((float)(imgWid)/ (float)scr);
        }

        opt.inJustDecodeBounds=false;
        Bitmap scaleImg=BitmapFactory.decodeResource(getResources(),pic,opt);
        img.setImageBitmap(scaleImg);
    }
};
