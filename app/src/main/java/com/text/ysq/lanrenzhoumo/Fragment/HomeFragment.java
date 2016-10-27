package com.text.ysq.lanrenzhoumo.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ListView;

import com.google.gson.Gson;
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
    private List<HomeBean.ResultBean> datas = new ArrayList<>();
    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        initView(view);
        menuListAdapter = new MenuListAdapter(getContext(),datas);
        mListView.setAdapter(menuListAdapter);
        return view;
    }

    private void initView(View view){
        mListView = (ListView) view.findViewById(R.id.home_list_view);
        AsyncTaskTool.load(LogUtils.PATH).execute(new AsyncTaskTool.IMyCallback() {
            @Override
            public void success(String result) {
                perseJson(result);
                menuListAdapter.notifyDataSetChanged();
            }
        });
    }
    private void perseJson(String result){
        Gson gson = new Gson();
        HomeBean homeBean = gson.fromJson(result, HomeBean.class);
        List<HomeBean.ResultBean> result1 = homeBean.getResult();
        datas.addAll(result1);

    }




}