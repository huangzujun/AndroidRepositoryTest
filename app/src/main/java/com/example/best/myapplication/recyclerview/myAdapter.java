package com.example.best.myapplication.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.best.myapplication.R;

/**
 * @author hzj
 * @date 2019-07-05 17:07
 */
public class myAdapter extends RecyclerView.Adapter<myAdapter.ViewHolder> {

    private Context context;
    private int inflateResource;

    public myAdapter( Context context, int inflateResource ) {
        this.context = context;
        this.inflateResource = inflateResource;
    }

    @Override
    public myAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder( LayoutInflater.from(context).inflate(inflateResource,parent,false) );
    }

    @Override
    public void onBindViewHolder(myAdapter.ViewHolder holder, final int position) {
        if (inflateResource != R.layout.layout_recycleview_item) {
            if( position%2 != 0 ){
                Glide.with(context)
                        .load("http://hbimg.b0.upaiyun.com/f6b437b648adf8ed733991cddd60dda0c51e9e9aafb6-QyXh37_fw236")
                        .into(holder.iv_rv_pu_img);
            }else {
                Glide.with(context)
                        .load("http://hbimg.b0.upaiyun.com/767a1301265ef29389c0379f437afde6e9ca1aea240cd-UHfJcD_fw236")
                        .into(holder.iv_rv_pu_img);
            }
        }else{
            holder.tv_rv_linear_name.setText("内容"+position);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Toast.makeText(context, "点击 position:"+position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 100;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_rv_linear_name;
        private ImageView iv_rv_pu_img;

        public ViewHolder(View itemView) {
            super(itemView);
            if (inflateResource != R.layout.layout_recycleview_item) {
                iv_rv_pu_img = itemView.findViewById(R.id.iv_rv_pu_img);
            }else{
                tv_rv_linear_name = itemView.findViewById(R.id.tv_rv_linear_name);
            }
        }
    }
}
