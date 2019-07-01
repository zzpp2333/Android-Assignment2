package chapter.android.aweme.ss.com.homework;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * 大作业:实现一个抖音消息页面,所需资源已放在res下面
 */
public class Exercises3 extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);

        //mListView.setAdapter(adapter);
        //mListView.setAdapter(new MyAdapter());

        /*mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext()," "+i,Toast.LENGTH_LONG).show();
                Intent it_ = new Intent(Exercises3.this,DisplayData.class);
                it_.putExtra("data",String.valueOf(i));
                startActivity(it_);
            }
        });*/

        ListView mListView = findViewById(R.id.rv_list);

        ArrayList<User> userList = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            User user = new User();
            user.setTitle("id-" + i);
            user.setDescription("不用说你们都知道我是谁的啦！！！");
            user.setTime(String.format("%d%s",i,"分钟前"));
            userList.add(user);
        }

        Log.i("ListView","Set_ListView");
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext()," "+i,Toast.LENGTH_LONG).show();
                Intent it_ = new Intent(getApplicationContext(),DisplayData.class);
                it_.putExtra("data",String.valueOf(i));
                startActivity(it_);
            }
        });
        Log.i("ListView","Set_Click_ListView");

        MyAdapter mAdapter = new MyAdapter(this, userList);
        mListView.setAdapter(mAdapter);
        Log.i("ListView","Set_Adapter_ListView");
        //findViewById(R.id.rv_list).setOnClickListener(this);
        findViewById(R.id.fans_btn).setOnClickListener(this);
        findViewById(R.id.message_btn).setOnClickListener(this);
        findViewById(R.id.mentionedme_btn).setOnClickListener(this);
        findViewById(R.id.comments_btn).setOnClickListener(this);
        findViewById(R.id.bottomline1).setOnClickListener(this);
        findViewById(R.id.bottomline2).setOnClickListener(this);
        findViewById(R.id.bottomline3).setOnClickListener(this);
        findViewById(R.id.bottomline4).setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fans_btn:
                //System.out.println("click on fans");
                Intent it1 = new Intent(this, DisplayData.class);
                it1.putExtra("data","粉丝");
                startActivity(it1);
                break;
            case R.id.message_btn:
                Intent it2 = new Intent(this, DisplayData.class);
                it2.putExtra("data","消息");
                startActivity(it2);
                break;
            case R.id.mentionedme_btn:
                Intent it3 = new Intent(this, DisplayData.class);
                it3.putExtra("data","@我的");
                startActivity(it3);
                break;
            case R.id.comments_btn:
                Intent it4 = new Intent(this, DisplayData.class);
                it4.putExtra("data","评论");
                startActivity(it4);
                break;
            case R.id.bottomline1:
                Intent it5 = new Intent(this, DisplayData.class);
                it5.putExtra("data","首页");
                startActivity(it5);
                break;
            case R.id.bottomline2:
                Intent it6 = new Intent(this, DisplayData.class);
                it6.putExtra("data","关注");
                startActivity(it6);
                break;
            case R.id.bottomline3:
                Intent it7 = new Intent(this, DisplayData.class);
                it7.putExtra("data","消息");
                startActivity(it7);
                break;
            case R.id.bottomline4:
                Intent it8 = new Intent(this, DisplayData.class);
                it8.putExtra("data","我");
                startActivity(it8);
                break;
        }
    }
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

            MyAdapter.ViewHolder viewHolder = null;

            if (convertView == null) {
                convertView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.im_list_item, parent, false);
                viewHolder = new MyAdapter.ViewHolder();
                viewHolder.itemTitle = (TextView) convertView.findViewById(R.id.tv_title);
                viewHolder.itemDesc = (TextView) convertView.findViewById(R.id.tv_description);
                viewHolder.itemTime = (TextView) convertView.findViewById(R.id.tv_time);

                convertView.setTag(viewHolder);

            } else {
                viewHolder = (MyAdapter.ViewHolder) convertView.getTag();
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
