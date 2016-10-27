package com.text.ysq.lanrenzhoumo.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.text.ysq.lanrenzhoumo.Fragment.HomeFragment;
import com.text.ysq.lanrenzhoumo.Https.ImageAsyncLoader;
import com.text.ysq.lanrenzhoumo.R;
import com.text.ysq.lanrenzhoumo.Tools.HomeBean;
import com.text.ysq.lanrenzhoumo.Tools.LogUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ysq on 2016/10/26.
 */
public class MenuListAdapter extends BaseAdapter{

    private HomeFragment homeFragment = new HomeFragment();
    private Context mContext;
    private List<HomeBean.ResultBean> datas = new ArrayList();
    private HomeBean homeBean;

    public MenuListAdapter(Context mContext,List<HomeBean.ResultBean> datas) {
        super();
        this.mContext = mContext;
        Log.i(LogUtils.TAG, "MenuListAdapter: datas.size"+datas.size());
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas == null ? 0 :datas.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder viewHolder = null;
        if(view == null){
            view = LayoutInflater.from(mContext).inflate(R.layout.fragment_home_item,parent,false);
            viewHolder = new ViewHolder(view);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        ImageAsyncLoader.load(datas.get(position).getFront_cover_image_list().get(0),viewHolder.imageView).execute();
        viewHolder.title.setText(datas.get(position).getTitle());
        viewHolder.poi.setText(datas.get(position).getPoi());
        viewHolder.distance.setText(datas.get(position).getDistance()+"m");
        viewHolder.category.setText(datas.get(position).getCategory());
        viewHolder.time_info.setText(datas.get(position).getTime_info());
        viewHolder.collected_num.setText(datas.get(position).getCollected_num() + "人收藏");
        viewHolder.price.setText( "￥ "+ datas.get(position).getPrice());
        return view;
    }
    class ViewHolder{
        public ImageView imageView;
        public TextView title;
        public TextView poi;
        public TextView distance;
        public TextView category;
        public TextView time_info;
        public TextView collected_num;
        public TextView price;

        public ViewHolder(View view) {
            view.setTag(this);
            imageView = (ImageView) view.findViewById(R.id.home_item_imageview);
            title = (TextView) view.findViewById(R.id.home_item_txt_title);
            poi = (TextView) view.findViewById(R.id.home_item_txt_huodong);
            distance = (TextView) view.findViewById(R.id.home_item_txt_juli);
            category = (TextView) view.findViewById(R.id.home_item_txt_fenlei);
            time_info = (TextView) view.findViewById(R.id.home_item_txt_time);
            collected_num = (TextView) view.findViewById(R.id.home_item_txt_shoucang);
            price = (TextView) view.findViewById(R.id.home_item_txt_price);

        }
    }
}
