package com.text.ysq.lanrenzhoumo.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.text.ysq.lanrenzhoumo.R;

public class SelfDataActivityTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_data_activity_two);
    }

    public void click(View view){
        int ViewID = view.getId();
        switch (ViewID){
            case R.id.self_two_btn_one:
                finish();
                break;
            case R.id.self_two_btn_two:
                Intent intent = new Intent();
                intent.setClass(this,HomeActivity.class);
                startActivity(intent);
                finish();
        }
    }
}
