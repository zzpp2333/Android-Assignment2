package chapter.android.aweme.ss.com.homework;

import android.content.Intent;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListViewActi extends AppCompatActivity {

    private ListView mListView;
    private MyAdapter mAdapter;
    private Context mContext;
    private List<User> userList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);

        Log.i("ListView","On_Create_ListView");
        mContext = ListViewActi.this;

        mListView = findViewById(R.id.rv_list);

        userList = new ArrayList<User>();

        for (int i = 0; i < 20; i++) {
            User user = new User();
            user.setTitle("id-" + i);
            user.setDescription("不用说你们都应该知道是谁的啦！！！");
            user.setTime(String.valueOf(i));
            userList.add(user);
        }

        Log.i("ListView","Set_ListView");
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext()," "+i,Toast.LENGTH_LONG).show();
                Intent it_ = new Intent(mContext,DisplayData.class);
                it_.putExtra("data",String.valueOf(i));
                startActivity(it_);
            }
        });
        Log.i("ListView","Set_Click_ListView");

        mAdapter = new MyAdapter(this, userList);
        mListView.setAdapter(mAdapter);
        Log.i("ListView","Set_Adapter_ListView");

    }

    /*@Override
    public void onItemClickListener(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(getApplicationContext()," "+i,Toast.LENGTH_LONG).show();
        Intent it_ = new Intent(ListViewActi.this,DisplayData.class);
        it_.putExtra("data",String.valueOf(i));
        startActivity(it_);
    }*/

    private class MyAdapter extends BaseAdapter{
        //返回条目数
        private List<User> users;

        public MyAdapter(Context context, List<User> users) {
            this.users = users;
        }
        @Override
        public int getCount() {
            return users != null ? users.size() : 0;
        }

        @Override
        public Object getItem(int position) {
            return users.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder viewHolder = null;

            if (convertView == null) {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.im_list_item, parent, false);
                viewHolder = new ViewHolder();
                viewHolder.itemTitle = (TextView) convertView.findViewById(R.id.tv_title);
                viewHolder.itemDesc = (TextView) convertView.findViewById(R.id.tv_description);
                viewHolder.itemTime = (TextView) convertView.findViewById(R.id.tv_time);

                convertView.setTag(viewHolder);

            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            User user = (User)getItem(position);
            if (user != null) {
                // 这里只是模拟，实际开发可能需要加载网络图片，可以使用ImageLoader这样的图片加载框架来异步加载图片
                viewHolder.itemTitle.setText(user.getTitle());
                viewHolder.itemDesc.setText(user.getDescription());
                viewHolder.itemTime.setText(user.getTime());

            }
            Log.i("ListView","Return_covertView");
            return convertView;
        }
        class ViewHolder {
            TextView itemTitle;
            TextView itemDesc;
            TextView itemTime;
        }
    }
}
