package chapter.android.aweme.ss.com.homework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * 作业2：一个抖音笔试题：统计页面所有view的个数
 * Tips：ViewGroup有两个API
 * {@link android.view.ViewGroup #getChildAt(int) #getChildCount()}
 * 用一个TextView展示出来
 */
public class Exercises2 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count);

        final LinearLayout layout = (LinearLayout)findViewById(R.id.layout_count);
        Button btn1 = findViewById(R.id.btn1);
        final TextView tv1 = findViewById(R.id.tv1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                tv1.setText(String.valueOf(getViewCount(layout)));
            }
        });

    }

    public static int getViewCount(View view) {
        //todo 补全你的代码
        int viewcount = 0;

        if(null == view)
            return 0;

        if(view instanceof ViewGroup){
            viewcount++;
            for(int i = 0 ; i < ((ViewGroup) view).getChildCount() ; i++){
                View view1 = ((ViewGroup) view).getChildAt(i);
                if(view1 instanceof ViewGroup){
                    viewcount += getViewCount(view1);
                }else{
                    viewcount++;
                }
            }
        }
        return viewcount;
    }
}
