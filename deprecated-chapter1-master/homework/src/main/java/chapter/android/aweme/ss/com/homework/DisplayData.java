package chapter.android.aweme.ss.com.homework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayData extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        Button btn1 = findViewById(R.id.display_btn);
        final TextView tv1 = findViewById(R.id.display_tv);

        Log.i("display","hhh");

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String data = getIntent().getStringExtra("data");
                Log.i("display",data);
                tv1.setText(data);
                Toast.makeText(getApplicationContext(),data,Toast.LENGTH_LONG);
            }
        });
    }
}
