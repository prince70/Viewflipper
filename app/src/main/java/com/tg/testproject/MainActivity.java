package com.tg.testproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    private ViewFlipper flipper;
    private static final String TAG = "MainActivity";

    /**
     * 查看源码看viewflipper的方法
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flipper = findViewById(R.id.marquee_view);
        View view = View.inflate(this, R.layout.notice_item, null);
        ImageView iv_notice = view.findViewById(R.id.iv_notice);
        TextView tv_notice = view.findViewById(R.id.tv_notice);
        iv_notice.setImageResource(R.mipmap.ic_launcher);
        tv_notice.setText("通知都是假的，公司要倒闭了");
        flipper.addView(view);
        flipper.addView(View.inflate(this, R.layout.notice_item, null));
        flipper.addView(View.inflate(this, R.layout.notice_item, null));
        flipper.getInAnimation().setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
//                监听的是所有的
//                Toast.makeText(MainActivity.this, textView.getText(), Toast.LENGTH_SHORT).show();
                View currentView = flipper.getCurrentView();
                final TextView textView = currentView.findViewById(R.id.tv_notice);
                flipper.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
//                        Toast.makeText(MainActivity.this, textView.getText(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                        intent.putExtra("message", textView.getText());
                        startActivity(intent);
                    }
                });
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                View currentView = flipper.getCurrentView();
                final TextView textView = currentView.findViewById(R.id.tv_notice);
                flipper.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                        intent.putExtra("message", textView.getText());
                        startActivity(intent);
                    }
                });

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


    }
}
