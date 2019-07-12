package com.example.best.myapplication.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.best.myapplication.BaseActivity;
import com.example.best.myapplication.R;

public class RecyclerViewMainActivity extends BaseActivity {

    private Button btn_recyclerView_linear,btn_rv_gird_hor,btn_rv_pu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_main);
        btn_recyclerView_linear = findViewById(R.id.btn_recyclerView_linear);
        btn_rv_gird_hor = findViewById(R.id.btn_rv_gird_hor);
        btn_rv_pu = findViewById(R.id.btn_rv_pu);
        setClickListeners();
    }

    private void setClickListeners(){
        OnClick onClick = new OnClick();
        btn_recyclerView_linear.setOnClickListener( onClick );
        btn_rv_gird_hor.setOnClickListener( onClick );
        btn_rv_pu.setOnClickListener( onClick );
    }

    private class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch ( v.getId() ){
                case R.id.btn_recyclerView_linear:
                    //跳转Linear显示页
                    intent = new Intent( RecyclerViewMainActivity.this,LinearRecyclerViewActivity.class );
                    break;
                case R.id.btn_rv_gird_hor:
                    //跳转grid水平显示页
                    intent = new Intent( RecyclerViewMainActivity.this,GridRVHorActivity.class );
                    break;
                case R.id.btn_rv_pu:
                    //跳转瀑布流页
                    intent = new Intent( RecyclerViewMainActivity.this,PuRVActivity.class );
                    break;
            }
            if (intent != null) {
                startActivity( intent );
            }
        }
    }
}
