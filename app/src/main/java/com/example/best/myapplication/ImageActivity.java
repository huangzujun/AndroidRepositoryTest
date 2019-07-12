package com.example.best.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageActivity extends AppCompatActivity {

    private ImageView iv_showImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature( Window.FEATURE_NO_TITLE );
        setContentView(R.layout.activity_image);
        iv_showImage = findViewById(R.id.iv_showImage);
        Glide.with(this)
             .load("https://imgsa.baidu.com/exp/w=480/sign=28e7795e9282d158bb8258b9b00b19d5/d788d43f8794a4c284f0189b00f41bd5ac6e39ab.jpg")
             .into(iv_showImage);
    }
}
