package com.example.best.myapplication;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    private String titleStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //添加顶部返回
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(titleStr);
    }

}

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }

    public void setTitleStr(String titleStr) {
        this.titleStr = titleStr;
    }
}
