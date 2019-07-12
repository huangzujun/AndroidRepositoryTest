package com.example.best.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class GridViewActivity extends BaseActivity {

    private GridView gv_show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitleStr("GridView显示");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        gv_show = findViewById(R.id.gv_show);
        gv_show.setAdapter( new MyGrideView(this) );
        gv_show.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GridViewActivity.this, "点击 "+(position+1)+"项", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private class MyGrideView extends BaseAdapter{

        private Context context;
        private LayoutInflater layoutInflater;

        public MyGrideView(Context context) {
            this.context = context;
            layoutInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        class ViewHolder{
            public ImageView iv_gv_img;
            public TextView tv_gv_content;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                convertView = layoutInflater.inflate( R.layout.layout_grid_item,null );
                holder = new ViewHolder();
                holder.iv_gv_img = convertView.findViewById(R.id.iv_gv_img);
                holder.tv_gv_content = convertView.findViewById(R.id.tv_gv_content);
                convertView.setTag(holder);
            }else {
                holder = (ViewHolder) convertView.getTag();
            }
            //赋值
            holder.tv_gv_content.setText("企鹅");
            Glide.with(context)
                    .load("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3930178913,4060332511&fm=26&gp=0.jpg")
                    .apply(RequestOptions.centerCropTransform())
                    .into(holder.iv_gv_img);
            return convertView;
        }
    }

}
