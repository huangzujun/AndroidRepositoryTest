package com.example.best.myapplication.recyclerview;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.best.myapplication.BaseActivity;
import com.example.best.myapplication.R;

public class GridRVHorActivity extends BaseActivity {

    private RecyclerView rv_grid_hor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_rvhor);
        rv_grid_hor = findViewById(R.id.rv_grid_hor);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 5);
        gridLayoutManager.setOrientation(GridLayoutManager.HORIZONTAL);
        rv_grid_hor.setLayoutManager( gridLayoutManager );
        rv_grid_hor.setAdapter( new myAdapter(this,R.layout.layout_recycleview_item) );
    }

}
