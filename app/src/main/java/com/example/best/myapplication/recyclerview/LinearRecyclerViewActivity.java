package com.example.best.myapplication.recyclerview;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.best.myapplication.BaseActivity;
import com.example.best.myapplication.R;

public class LinearRecyclerViewActivity extends BaseActivity {

    private RecyclerView rvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitleStr("LinearLayoutManager");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        rvMain = findViewById(R.id.rv_main);
        rvMain.setLayoutManager( new LinearLayoutManager(this) );
        rvMain.addItemDecoration( new DividerItemDecoration( this,DividerItemDecoration.VERTICAL ));
        rvMain.setAdapter( new myAdapter(this,R.layout.layout_recycleview_item) );
    }

}
