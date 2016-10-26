package com.text.ysq.lanrenzhoumo.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.text.ysq.lanrenzhoumo.Fragment.HomeFragment;
import com.text.ysq.lanrenzhoumo.Https.ImageAsyncLoader;
import com.text.ysq.lanrenzhoumo.R;

/**
 * Created by ysq on 2016/10/26.
 */
public class MenuListAdapter extends BaseAdapter{

    private HomeFragment homeFragment = new HomeFragment();
    private Context mContext;

    public MenuListAdapter(Context mContext) {
        super();
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return homeFragment.datas == null ? 0 :homeFragment.datas.size();
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
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        ImageAsyncLoader.load(homeFragment.datas.get(position).getPicture(),viewHolder.imageView).execute();
        viewHolder.title.setText(homeFragment.datas.get(position).getTitle());
        viewHolder.poi.setText(homeFragment.datas.get(position).getPoi());
        viewHolder.category.setText(homeFragment.datas.get(position).getCategory());
        viewHolder.time_info.setText(homeFragment.datas.get(position).getTime_info());
        viewHolder.collected_num.setText(homeFragment.datas.get(position).getCollected_num());
        viewHolder.price.setText(homeFragment.datas.get(position).getPrice());
        return view;
    }
    class ViewHolder{
        public ImageView imageView;
        public TextView title;
        public TextView poi;
        public TextView category;
        public TextView time_info;
        public TextView collected_num;
        public TextView price;

        public ViewHolder(View view) {
            view.setTag(this);
            imageView = (ImageView) view.findViewById(R.id.home_item_imageview);
            title = (TextView) view.findViewById(R.id.home_item_txt_title);
            poi = (TextView) view.findViewById(R.id.home_item_txt_huodong);
            category = (TextView) view.findViewById(R.id.home_item_txt_fenlei);
            time_info = (TextView) view.findViewById(R.id.home_item_txt_time);
            collected_num = (TextView) view.findViewById(R.id.home_item_txt_shoucang);
            price = (TextView) view.findViewById(R.id.home_item_txt_price);

        }
    }
}
