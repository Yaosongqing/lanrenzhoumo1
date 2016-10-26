package com.text.ysq.lanrenzhoumo.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.text.ysq.lanrenzhoumo.R;

import java.util.ArrayList;
import java.util.List;

public class WelcomeActivity extends AppCompatActivity {

    public static WelcomeActivity instance = null;
    private ViewPager mViewPager;
    private List<Integer> images = new ArrayList<>();
    private List<String> titleviews = new ArrayList<>();
    private List<String> subviews = new ArrayList<>();
    private MyPagerAdapter myPagerAdapter;
    //每隔多少秒发一条消息到主线程，更新viewpager界面
    private long scrollTimeOffset = 5000;
    private boolean isStop = false;
    private TextView mSubtxt;
    private TextView mTitletxt;
    private long exitTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        mViewPager = (ViewPager) findViewById(R.id.welcome_view_pager);
        mTitletxt = (TextView) findViewById(R.id.welcome_title_txt);
        mSubtxt = (TextView) findViewById(R.id.welcome_sub_txt);
        initpictures();
        myPagerAdapter = new MyPagerAdapter();
        mViewPager.setAdapter(myPagerAdapter);
        startBannerScrollThread();
        instance = this;
    }

//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){
//            if((System.currentTimeMillis() - exitTime) > 2000){
//                Toast.makeText(getApplicationContext(), "再按一次，离开懒人周末", Toast.LENGTH_SHORT).show();
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
        if (System.currentTimeMillis() - exitTime > 2000){
            Toast.makeText(getApplicationContext(), "再按一次，离开懒人周末", Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            finish();
            System.exit(0);
        }
    }

    /**
     * 开启Banner滚动线程
     */
    private void startBannerScrollThread() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                while (!isStop) {
                    SystemClock.sleep(scrollTimeOffset);
                    runOnUiThread(new Runnable() {
                        public void run() {
                            int newindex = mViewPager.getCurrentItem() + 1;
                            mViewPager.setCurrentItem(newindex);
                        }
                    });
                }
            }
        }).start();
    }

    public void click(View view){
        int btnID = view.getId();
        switch (btnID){
            case R.id.welcome_btn_one:
                Toast.makeText(WelcomeActivity.this, "这是微博登录", Toast.LENGTH_SHORT).show();
                break;
            case R.id.welcome_btn_two:
                Toast.makeText(WelcomeActivity.this, "这是微信登录", Toast.LENGTH_SHORT).show();
                break;
            case R.id.welcome_btn_three:
                Intent intent = new Intent();
                intent.setClass(this,SelfDataActivity.class);
                startActivity(intent);
                break;
        }

    }

    private void initpictures() {
        images.add(R.drawable.pic1);
        images.add(R.drawable.pic2);
        images.add(R.drawable.pic3);
        images.add(R.drawable.pic4);
        titleviews.add("闭目");
        titleviews.add("睁眼");
        titleviews.add("启程");
        titleviews.add("我们");
        subviews.add("难掩喜悦与期待");
        subviews.add("因为你心为所动");
        subviews.add("只因追寻你所爱");
        subviews.add("做最了解你的人");

    }

    class MyPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView imageView = new ImageView(WelcomeActivity.this);
            mTitletxt.setText(titleviews.get(position%4));
            mSubtxt.setText(subviews.get(position%4));
            imageView.setImageResource(images.get(position%4));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            container.addView(imageView);
            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View)object);
        }
    }

    @Override
    protected void onDestroy() {
        isStop = true;
        super.onDestroy();
    }

}
