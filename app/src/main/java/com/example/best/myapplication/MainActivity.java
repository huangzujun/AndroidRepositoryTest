package com.example.best.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.example.best.myapplication.recyclerview.RecyclerViewMainActivity;

public class MainActivity extends AppCompatActivity {

    private Button btn_getImgByNetwork,btn_listView,btn_gridView,
            btn_recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去除标题栏
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        //获取按钮ID
        btn_getImgByNetwork = findViewById( R.id.btn_getImgByNetwork );
        btn_listView = findViewById(R.id.btn_listView);
        btn_gridView = findViewById(R.id.btn_gridView);
        btn_recyclerView = findViewById(R.id.btn_recyclerView);
        //设置按钮监听
        setClickListeners();
    }

    private void setClickListeners(){
        onClick onClick = new onClick();
        btn_getImgByNetwork.setOnClickListener( onClick );
        btn_listView.setOnClickListener( onClick );
        btn_gridView.setOnClickListener( onClick );
        btn_recyclerView.setOnClickListener( onClick );
    }

    private class onClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch ( v.getId() ){
                case R.id.btn_getImgByNetwork:
                    //跳转展示图片页
                    intent = new Intent( MainActivity.this,ImageActivity.class );
                    break;
                case R.id.btn_listView:
                    //跳转ListView页
                    intent = new Intent( MainActivity.this,ListViewActivity.class );
                    break;
                case R.id.btn_gridView:
                    //跳转GridView页
                    intent = new Intent( MainActivity.this,GridViewActivity.class );
                    break;
                case R.id.btn_recyclerView:
                    //跳转RecyclerView主页
                    intent = new Intent( MainActivity.this,RecyclerViewMainActivity.class );
                    break;
            }
            if (intent != null) {
                startActivity( intent );
            }
        }
    }


}
