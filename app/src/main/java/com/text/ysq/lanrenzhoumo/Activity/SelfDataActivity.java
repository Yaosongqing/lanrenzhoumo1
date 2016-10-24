package com.text.ysq.lanrenzhoumo.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.text.ysq.lanrenzhoumo.R;

public class SelfDataActivity extends AppCompatActivity {

    private ImageButton mImageButtonone;
    private ImageButton mImageButtontwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_data);
        mImageButtonone = (ImageButton) findViewById(R.id.self_btn_one);
        mImageButtontwo = (ImageButton) findViewById(R.id.self_btn_two);

    }

    public void click(View view){
        int btnID = view.getId();
        switch (btnID){
            case R.id.self_btn_one:
                finish();
                break;
            case R.id.self_btn_two:
                break;
        }
    }

}
