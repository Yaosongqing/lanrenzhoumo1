package com.text.ysq.lanrenzhoumo.Activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.text.ysq.lanrenzhoumo.Adapter.MenuAdapter;
import com.text.ysq.lanrenzhoumo.Fragment.AssistantFragment;
import com.text.ysq.lanrenzhoumo.Fragment.HomeFragment;
import com.text.ysq.lanrenzhoumo.Fragment.PersonFragment;
import com.text.ysq.lanrenzhoumo.Fragment.SearchFragment;
import com.text.ysq.lanrenzhoumo.R;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private List<Fragment> fragments = new ArrayList<>();
    private MenuAdapter menuAdapter;
    private ViewPager mViewPager;
    private RadioGroup mRadioGroup;
    private RadioButton mCurrentBtn;
    private long exitTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mViewPager = (ViewPager) findViewById(R.id.home_view_pager);
        mRadioGroup = (RadioGroup) findViewById(R.id.home_menu_rg);
        initdata();
        menuAdapter = new MenuAdapter(getSupportFragmentManager(), fragments);
        mViewPager.setAdapter(menuAdapter);
        initListener();
    }

    public void click(View view){
        int id = view.getId();
        switch (id){
            case R.id.assistant_txt3:
                Toast.makeText(HomeActivity.this, "懒喵助手", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fragment_person_btn_one:
                Intent intent = new Intent();
                intent.setClass(this,LogingActivity.class);
                startActivity(intent);
                break;
            case R.id.fragment_person_btn_two:
                Toast.makeText(HomeActivity.this, "兴趣标签", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fragment_person_btn_three:
                Intent intent2 = new Intent();
                intent2.setClass(HomeActivity.this,SettingActivity.class);
                startActivity(intent2);
                break;

        }
    }

//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){
//            if((System.currentTimeMillis()-exitTime) > 2000){
//                Toast.makeText(HomeActivity.this, "再点一次，离开懒人周末", Toast.LENGTH_SHORT).show();
//                exitTime = System.currentTimeMillis();
//            } else {
//                finish();
//                System.exit(0);
//            }
//            return true;
//        }
//        return super.onKeyDown(keyCode, event);
//    }

    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis()-exitTime > 2000){
            Toast.makeText(HomeActivity.this, "再点一次，离开懒人周末", Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            finish();
        }
    }

    /**
     * 以下是RG与VP实现
     */
    private void initdata() {
        fragments.add(HomeFragment.newInstance());
        fragments.add(SearchFragment.newInstance());
        fragments.add(AssistantFragment.newInstance());
        fragments.add(PersonFragment.newInstance());
    }

    public void initListener(){
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.home_menu_item1:
                        mViewPager.setCurrentItem(0);
                        mCurrentBtn = (RadioButton) mRadioGroup.getChildAt(0);
                        break;
                    case R.id.home_menu_item2:
                        mViewPager.setCurrentItem(1);
                        mCurrentBtn = (RadioButton) mRadioGroup.getChildAt(1);
                        break;
                    case R.id.home_menu_item3:
                        mViewPager.setCurrentItem(2);
                        mCurrentBtn = (RadioButton) mRadioGroup.getChildAt(2);
                        break;
                    case R.id.home_menu_item4:
                        mViewPager.setCurrentItem(4);
                        mCurrentBtn = (RadioButton) mRadioGroup.getChildAt(4);
                        break;
                }
            }
        });
            mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener(){

                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        mRadioGroup.check(R.id.home_menu_item1);
                        break;
                    case 1:
                        mRadioGroup.check(R.id.home_menu_item2);
                        break;
                    case 2:
                        mRadioGroup.check(R.id.home_menu_item3);
                        break;
                    case 3:
                        mRadioGroup.check(R.id.home_menu_item4);
                        break;
                    }
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });

    }


}
