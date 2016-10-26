package com.text.ysq.lanrenzhoumo.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.text.ysq.lanrenzhoumo.Adapter.MenuListAdapter;
import com.text.ysq.lanrenzhoumo.R;


public class HomeFragment extends Fragment {

    private ListView mListView;
    private MenuListAdapter menuListAdapter;

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
    }
    




}