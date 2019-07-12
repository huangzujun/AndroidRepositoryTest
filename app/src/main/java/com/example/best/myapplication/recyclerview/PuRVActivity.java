package com.example.best.myapplication.recyclerview;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.best.myapplication.BaseActivity;
import com.example.best.myapplication.R;

public class PuRVActivity extends BaseActivity {

    private RecyclerView rv_pu_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pu_rv);
        rv_pu_main = findViewById(R.id.rv_pu_main);
        rv_pu_main.setLayoutManager( new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL) );
        rv_pu_main.setAdapter( new myAdapter(this,R.layout.layout_staggeredrv_item) );
    }
}
