package chapter.android.aweme.ss.com.homework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;
import android.content.res.Configuration;
import android.widget.Toast;
import android.util.Log;
import android.support.v7.app.AppCompatActivity;

/**
 * 作业1：
 * 打印出Activity屏幕切换 Activity会执行什么生命周期？
 */
public class Exercises1 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);
        Log.i("lifecycle:","ON_CREATE");
        TextView tv1 = findViewById(R.id.tv1);
        tv1.setText(tv1.getText().toString()+"\nON_CREATE");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        // TODO Auto-generated method stub
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            Toast.makeText(this, "现在是竖屏", Toast.LENGTH_SHORT)
                    .show();
        }
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "现在是横屏", Toast.LENGTH_SHORT)
                    .show();
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("lifecycle:","ON_RESTART");
        TextView tv1 = findViewById(R.id.tv1);
        tv1.setText(tv1.getText().toString()+"\nON_RESTART");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("lifecycle:","ON_START");
        TextView tv1 = findViewById(R.id.tv1);
        tv1.setText(tv1.getText().toString()+"\nON_START");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("lifecycle:","ON_RESUME");
        TextView tv1 = findViewById(R.id.tv1);
        tv1.setText(tv1.getText().toString()+"\nON_RESUME");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.i("lifecycle:","ON_PAUSE");
        TextView tv1 = findViewById(R.id.tv1);
        tv1.setText(tv1.getText().toString()+"\nON_PAUSE");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("lifecycle:","ON_STOP");
        TextView tv1 = findViewById(R.id.tv1);
        tv1.setText(tv1.getText().toString()+"\nON_STOP");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("lifecycle:","ON_DESTROY");
        TextView tv1 = findViewById(R.id.tv1);
        tv1.setText(tv1.getText().toString()+"\nON_DESTROY");
    }
}
