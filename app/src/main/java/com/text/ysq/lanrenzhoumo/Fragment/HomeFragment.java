package com.text.ysq.lanrenzhoumo.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.text.ysq.lanrenzhoumo.Adapter.MenuListAdapter;
import com.text.ysq.lanrenzhoumo.Https.AsyncTaskTool;
import com.text.ysq.lanrenzhoumo.R;
import com.text.ysq.lanrenzhoumo.Tools.HomeBean;
import com.text.ysq.lanrenzhoumo.Tools.LogUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    private ListView mListView;
    private MenuListAdapter menuListAdapter;
    public List<HomeBean> datas = new ArrayList<>();
    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        initView(view);
        return view;
    }

    private void initView(View view){
        mListView = (ListView) view.findViewById(R.id.home_list_view);
        menuListAdapter = new MenuListAdapter(getContext());
        mListView.setAdapter(menuListAdapter);
        AsyncTaskTool.load(LogUtils.PATH).execute(new AsyncTaskTool.IMyCallback() {
            @Override
            public void success(String result) {
                perseJson(result);
            }
        });
    }
    private void perseJson(String result){
        try {
            JSONObject jsonObject = new JSONObject(result);
            JSONArray jsonArray = jsonObject.getJSONArray("result");
            int len = jsonArray.length();
            for (int i = 0; i < len; i++) {
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                String picture = jsonObject1.getString("front_cover_image_list") == null ? "" : jsonObject1.getString("front_cover_image_list");
                String title = jsonObject1.getString("title") == null ? "" : jsonObject1.getString("title");
                String poi = jsonObject1.getString("poi") == null ? "" : jsonObject1.getString("poi");
                String category = jsonObject1.getString("category") == null ? "" : jsonObject1.getString("category");
                String time_info = jsonObject1.getString("time_info") == null ? "" : jsonObject1.getString("time_info");
                String collected_num = jsonObject1.getString("collected_num") == null ? "" : jsonObject1.getString("collected_num");
                String price = jsonObject1.getString("price") == null ? "" : jsonObject1.getString("price");
                HomeBean bean = new HomeBean(picture,title,poi,category,time_info,collected_num,price);
                datas.add(bean);
                Log.i(LogUtils.getTAG(), "perseJson: "+datas.get(i).toString());
            }
            menuListAdapter.notifyDataSetChanged();

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }




}