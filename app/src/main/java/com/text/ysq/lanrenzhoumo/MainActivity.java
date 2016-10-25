package com.text.ysq.lanrenzhoumo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import com.text.ysq.lanrenzhoumo.Activity.WelcomeActivity;

public class MainActivity extends AppCompatActivity {

    final Object synObj = new Object();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        init();
    }

    private void init() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                    try {
                        Thread.sleep(3000);
                        Intent intent = new Intent();
                        intent.setClass(MainActivity.this, WelcomeActivity.class);
                        startActivity(intent);
                        finish();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        }).start();
    }


}
