package com.text.ysq.lanrenzhoumo.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;

import com.text.ysq.lanrenzhoumo.R;

public class SelfDataActivity extends AppCompatActivity {

    public static SelfDataActivity instance = null;
    private ImageButton mImageButtonone;
    private ImageButton mImageButtontwo;
    private RadioButton mRBman;
    private RadioButton mRBwoman;
    private RadioButton mRBparent;
    private RadioButton mRBloving;
    private RadioButton mRBsingle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_data);
        mImageButtonone = (ImageButton) findViewById(R.id.self_btn_back);
        mImageButtontwo = (ImageButton) findViewById(R.id.self_btn_go);
        mRBman = (RadioButton) findViewById(R.id.self_btn_man);
        mRBwoman = (RadioButton) findViewById(R.id.self_btn_woman);
        mRBparent = (RadioButton) findViewById(R.id.self_btn_parent);
        mRBloving = (RadioButton) findViewById(R.id.self_btn_loving);
        mRBsingle = (RadioButton) findViewById(R.id.self_btn_single);
        instance = this;
    }

    public boolean ischeck(Boolean b) {
        if (mRBman.isChecked()||mRBwoman.isChecked()){
            if (mRBparent.isChecked()||mRBloving.isChecked()||mRBsingle.isChecked()){
                return true;
            }
        }
        return false;
    }

    public void click(View view){
        int btnID = view.getId();
        switch (btnID){
            case R.id.self_btn_back:
                finish();
                break;
            case R.id.self_btn_go:
                if (ischeck(true)){
                Intent intent = new Intent();
                intent.setClass(this,SelfDataActivityTwo.class);
                startActivity(intent);
                } else {
                    Toast.makeText(SelfDataActivity.this, "为能给您推荐更适合的产品，请选择个人状态哦~", Toast.LENGTH_SHORT).show();
                }
                break;

        }
    }


}
