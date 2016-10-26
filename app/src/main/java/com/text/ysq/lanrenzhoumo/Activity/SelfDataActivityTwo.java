package com.text.ysq.lanrenzhoumo.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.text.ysq.lanrenzhoumo.R;

public class SelfDataActivityTwo extends AppCompatActivity {

    private CheckBox mZhoubianyou;
    private CheckBox mJiuba;
    private CheckBox mYinyue;
    private CheckBox mXiju;
    private CheckBox mMeishi;
    private CheckBox mGouwu;
    private CheckBox mDianying;
    private CheckBox mJuhui;
    private CheckBox mYundong;
    private CheckBox mGongyi;
    private CheckBox mShangye;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_data_activity_two);
        mZhoubianyou = (CheckBox) findViewById(R.id.self_two_btn_zhoubianyou);
        mJiuba = (CheckBox) findViewById(R.id.self_two_btn_jiuba);
        mYinyue = (CheckBox) findViewById(R.id.self_two_btn_yinyue);
        mXiju = (CheckBox) findViewById(R.id.self_two_btn_xiju);
        mZhoubianyou = (CheckBox) findViewById(R.id.self_two_btn_zhanlan);
        mMeishi = (CheckBox) findViewById(R.id.self_two_btn_meishi);
        mGouwu = (CheckBox) findViewById(R.id.self_two_btn_gouwu);
        mDianying = (CheckBox) findViewById(R.id.self_two_btn_dianying);
        mJuhui = (CheckBox) findViewById(R.id.self_two_btn_juhui);
        mYundong = (CheckBox) findViewById(R.id.self_two_btn_yundong);
        mGongyi = (CheckBox) findViewById(R.id.self_two_btn_gongyi);
        mShangye = (CheckBox) findViewById(R.id.self_two_btn_shangye);
    }

    private boolean ischeck(Boolean b){
        if (mZhoubianyou.isChecked()||mJiuba.isChecked()||mYinyue.isChecked()||mXiju.isChecked()||
                mZhoubianyou.isChecked()||mMeishi.isChecked()||mGouwu.isChecked()||mDianying.isChecked()||
                mJuhui.isChecked()||mYundong.isChecked()||mGongyi.isChecked()||mShangye.isChecked()){
            return true;
         
        }
        return false;
    }

    public void click(View view){
        int ViewID = view.getId();
        switch (ViewID){
            case R.id.self_two_btn_back:
                finish();
                break;
            case R.id.self_two_btn_go:
                if (ischeck(true)){
                Intent intent = new Intent();
                intent.setClass(this,HomeActivity.class);
                startActivity(intent);
                finish();
                SelfDataActivity.instance.finish();
                WelcomeActivity.instance.finish();
                } else {
                    Toast.makeText(SelfDataActivityTwo.this, "还没有选择兴趣标签哦~", Toast.LENGTH_SHORT).show();
                }
        }
    }
}
