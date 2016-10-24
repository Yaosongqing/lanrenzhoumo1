package com.text.ysq.lanrenzhoumo.Activity;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.text.ysq.lanrenzhoumo.R;

import java.util.ArrayList;
import java.util.List;

public class WelcomeActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private List<Integer> images = new ArrayList<>();
    private List<TextView> views = new ArrayList<>();
    private MyPagerAdapter myPagerAdapter;
    //每隔多少秒发一条消息到主线程，更新viewpager界面
    private long scrollTimeOffset = 5000;
    private boolean isStop = false;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        mViewPager = (ViewPager) findViewById(R.id.welcome_view_pager);
        mTextView = (TextView) findViewById(R.id.welcome_txt_view);
        initpictures();
        myPagerAdapter = new MyPagerAdapter();
        mViewPager.setAdapter(myPagerAdapter);
        startBannerScrollThread();
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
        Intent intent = new Intent();
        intent.setClass(this,SelfDataActivity.class);
        startActivity(intent);
    }

    private void initpictures() {
        images.add(R.drawable.pic1);
        images.add(R.drawable.pic2);
        images.add(R.drawable.pic3);
        images.add(R.drawable.pic4);
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
