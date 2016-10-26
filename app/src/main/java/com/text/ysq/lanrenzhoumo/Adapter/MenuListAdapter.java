package com.text.ysq.lanrenzhoumo.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.text.ysq.lanrenzhoumo.R;

/**
 * Created by ysq on 2016/10/26.
 */
public class MenuListAdapter extends BaseAdapter{

    private Context mContext;

    public MenuListAdapter(Context mContext) {
        super();
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return 10;
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
            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView) view.findViewById(R.id.home_item_imageview);
            viewHolder.txt1 = (TextView) view.findViewById(R.id.home_item_txt_one);
            viewHolder.txt2 = (TextView) view.findViewById(R.id.home_item_txt_two);
            viewHolder.txt3 = (TextView) view.findViewById(R.id.home_item_txt_three);
            viewHolder.txt4 = (TextView) view.findViewById(R.id.home_item_txt_four);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        return view;
    }
    class ViewHolder{
        public ImageView imageView;
        public TextView txt1;
        public TextView txt2;
        public TextView txt3;
        public TextView txt4;
    }
}
