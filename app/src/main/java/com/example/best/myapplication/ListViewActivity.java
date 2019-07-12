package com.example.best.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.best.myapplication.entity.ListViewItem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListViewActivity extends BaseActivity {

    private ListView lv_show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitleStr("ListView显示");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        lv_show = findViewById(R.id.lv_show);
        //构建数据
        List<ListViewItem> data = new ArrayList<>();

        ListViewItem viewItem = new ListViewItem();
        viewItem.setImgUrl("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3855512303,928548282&fm=26&gp=0.jpg");
        viewItem.setTitle("别来无恙");
        viewItem.setContent("进来安好？可曾回忆老故事，曾的美好还在吗？曾的旧事能续吗？");
        data.add(viewItem);

        ListViewItem viewItem2 = new ListViewItem();
        viewItem2.setImgUrl("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=616523700,2401556629&fm=26&gp=0.jpg");
        viewItem2.setTitle("进来安好");
        viewItem2.setContent("别来无恙？可曾回忆老故事，曾的美好还在吗？曾的旧事能续吗？");
        data.add(viewItem2);


        ListAdapter_show  adapter_show = new ListAdapter_show( this,data );
        lv_show.setAdapter(adapter_show);
        lv_show.setOnItemClickListener( new itemClick() );
    }

    class itemClick implements AdapterView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(ListViewActivity.this, "点击第："+ position + "项 ", Toast.LENGTH_SHORT).show();
        }
    }

    private class ListAdapter_show extends BaseAdapter{

        private Context context;
        private LayoutInflater layoutInflater;
        private List<ListViewItem> data;

        public ListAdapter_show( Context context,List<ListViewItem> data){
            this.context = context;
            this.data = data;
            layoutInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int position) {
            return data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        class ViewHolder{
            public ImageView iv_headerImg;
            public TextView tv_title,tv_time,tv_content;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null) {
                convertView = layoutInflater.inflate(R.layout.layout_list_item,null);
                viewHolder = new ViewHolder();
                viewHolder.iv_headerImg = convertView.findViewById(R.id.iv_headerImg);
                viewHolder.tv_title = convertView.findViewById(R.id.tv_title);
                viewHolder.tv_time = convertView.findViewById(R.id.tv_time);
                viewHolder.tv_content = convertView.findViewById(R.id.tv_content);
                convertView.setTag(viewHolder);
            }else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            //给每个item设置值
            Glide.with(context)
                 .load(data.get(position).getImgUrl())
                 .apply( RequestOptions.circleCropTransform() ) //以圆形显示
                 .into(viewHolder.iv_headerImg);
            viewHolder.tv_title.setText( data.get(position).getTitle() );
            viewHolder.tv_time.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));
            viewHolder.tv_content.setText(data.get(position).getContent());
            return convertView;
        }

    }

}
