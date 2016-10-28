package com.text.ysq.lanrenzhoumo.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.text.ysq.lanrenzhoumo.R;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
    }

    public void click(View view){
        int id = view.getId();
        switch (id){
            case R.id.setting_btn_back:
                finish();
                break;
        }
    }
}
